package com.yc.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.yc.core.io.domain.IODefine;
import com.yc.core.utils.ConfigParamUtil;
import com.yc.core.utils.Room1000Logger;
import com.yc.core.utils.StringUtil;

/**
 * 
 * Description: 导出Servlet(获取系统目录下的文件直接导出)
 *  
 * Created on 2017年1月5日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class DownloadServlet extends HttpServlet {

    /** serialVersionUID  */
    private static final long serialVersionUID = 3940131645197063173L;
    
    /** logger */
    private static final Room1000Logger logger = Room1000Logger.getLogger(DownloadServlet.class);

    /**
     * 构造函数
     */
    public DownloadServlet() {
        super();
    }

    /**
     * Description: doPost
     * 
     * @author jinyanan
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Description: doGet
     * 
     * @author jinyanan
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(IODefine.LOCAL_CHARSET);

        String fileName = "";
        String filePath = "";
        String absolutePath = request.getParameter("absolutePath");
        if (StringUtil.isNotEmptyInTrim(absolutePath)) {
            absolutePath = new String(absolutePath.trim().getBytes(IODefine.ISO_8859_1), IODefine.LOCAL_CHARSET);
            fileName = FilenameUtils.getName(absolutePath);
            filePath = FilenameUtils.getFullPath(absolutePath);
        }
        else {
            fileName = request.getParameter("fileName");
            if (fileName == null || fileName.trim().equals("")) {
                return;
            }
            else {
                fileName = new String(fileName.getBytes(IODefine.ISO_8859_1), IODefine.LOCAL_CHARSET);
            }

            // 如果前台没有传入文件路径，则从系统配置文件设置的路径中取
            filePath = request.getParameter("filePath");
            if (StringUtil.isEmptyInTrim(filePath)) {
                filePath = ConfigParamUtil.getString("UPLOAD_FILE_DIR");
            }
            else {
                filePath = new String(filePath.getBytes(IODefine.ISO_8859_1), IODefine.LOCAL_CHARSET);
            }
        }

        // 设置响应头和下载保存的文件名
        String newName = request.getParameter("newName");
        String resFileName = "";
        if (StringUtil.isEmpty(newName)) {
            // 文件名中文乱码的问题
            String userAgent = request.getHeader("USER-AGENT");
            if (userAgent != null && userAgent.indexOf("MSIE") > -1) {
                resFileName = URLEncoder.encode(fileName, IODefine.LOCAL_CHARSET);
                resFileName = resFileName.replace("+", "%20");
            }
            else {
                resFileName = new String(fileName.getBytes(), IODefine.ISO_8859_1);
            }
        }
        else {
            resFileName = new String(newName.getBytes(), IODefine.ISO_8859_1);
        }
        response.setContentType("APPLICATION/OCTET-STREAM;charset=" + IODefine.LOCAL_CHARSET);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + resFileName + "\"");

        // 打开指定文件的流信息
        File f = new File(filePath, fileName);

        // 写出流信息
        response.setContentLength((int) f.length());

        int i = 0;
        byte[] bt = new byte[8192];
        ServletOutputStream sos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            sos = response.getOutputStream();
            while ((i = fis.read(bt)) != -1) {
                sos.write(bt, 0, i);
            }
        }
        catch (FileNotFoundException ex) {
            logger.error("Download file error!", ex);
        }
        catch (Exception ex) {
            logger.error("Download file error!", ex);
        }
        finally {
            if (sos != null) {
                try {
                    sos.flush();
                    sos.close();
                }
                catch (IOException ex) {
                    sos = null;
                    logger.error("Close servlet output stream exception!", ex);
                }

                sos = null;
            }
            if (fis != null) {

                try {
                    fis.close();
                }
                catch (IOException ex) {
                    fis = null;
                    logger.error("Close file input stream exception!", ex);
                }
            }
        }
    }
}
