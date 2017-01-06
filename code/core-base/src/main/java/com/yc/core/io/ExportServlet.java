package com.yc.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.yc.core.exception.BaseAppException;
import com.yc.core.io.domain.IODefine;
import com.yc.core.utils.ExceptionUtil;
import com.yc.core.utils.Room1000Logger;
import com.yc.core.utils.StringUtil;

/**
 * 
 * Description: 下载Servlet(读取数据库来导出文件)
 *  
 * Created on 2017年1月5日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class ExportServlet extends HttpServlet {

    /** serialVersionUID */
    private static final long serialVersionUID = -3739252449254850296L;

    /*** logger */
    private static Room1000Logger logger = Room1000Logger.getLogger(ExportServlet.class);
    
    /**
     * CONTENT_TYPES
     */
    private static Map<String, String> contentTypes = new HashMap<String, String>();

    static {
        contentTypes.put("xml", "text/xml");
        contentTypes.put("txt", "text/plain");
        contentTypes.put("pdf", "application/pdf");
        contentTypes.put("xls", "application/vnd.ms-excel");
        contentTypes.put("doc", "application/msword");
//        contentTypes.put("zip", "application/zip");
//        contentTypes.put("tar", "application/x-tar");
//        contentTypes.put("gzip", "application/x-gzip");
//        contentTypes.put("z", "appication/x-compress");
    }

    /**
     * 
     * Description: doGet
     * 
     * @author jinyanan
     *
     * @param request request
     * @param response response
     * @throws ServletException <br>
     * @throws IOException <br>
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * 
     * Description: doPost
     * 
     * @author jinyanan
     *
     * @param request request
     * @param response response
     * @throws ServletException <br>
     * @throws IOException <br>
     */
    @SuppressWarnings("rawtypes")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map paramsMap = request.getParameterMap();
        String path = (String) paramsMap.get(IODefine.EXPORT_CLASS_PATH);
        try {
            ExportTemplate et = (ExportTemplate) Class.forName(path).newInstance();
            Map<String, Object> exportFile = et.doExport(paramsMap);
            this.writeResult(exportFile, response);
        }
        catch (BaseAppException e) {
            logger.error("BaseAppException", e);
        }
        catch (InstantiationException e) {
            logger.error("InstantiationException", e);
        }
        catch (IllegalAccessException e) {
            logger.error("IllegalAccessException", e);
        }
        catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException", e);
        }
        
        
    }

    /**
     * 
     * Description: 输出流
     * 
     * @author jinyanan
     *
     * @param exportFile 导出文件内容
     * @param response response
     * @throws IOException <br>
     * @throws BaseAppException <br>
     */
    private void writeResult(Map<String, Object> exportFile, HttpServletResponse response) throws IOException, BaseAppException {
        // 导出文件的文件名，带后缀
        String fileName = (String) exportFile.get(IODefine.EXPORT_FILE_NAME);
        // 导出的具体文件
        Object result = exportFile.get(IODefine.EXPORT_RESULT);
        
        // 根据文件后缀设置contentType
        String contentType = contentTypes.get("txt");
        String extension = FilenameUtils.getExtension(fileName).toLowerCase();
        if (contentTypes.containsKey(extension)) {
            contentType = contentTypes.get(extension);
        }
        
        response.setContentType(contentType + ";charset=UTF-8");
        response.addHeader("content-disposition", "attachment; filename=" + toUtf8(fileName));
        
        OutputStream os = response.getOutputStream();
        if (result != null) {
            if (result.getClass().isArray() && result.getClass().getComponentType() == byte.class) {
                os.write(((byte[]) result));
            }
            else if (result instanceof String) {
                os.write(((String) result).getBytes(IODefine.LOCAL_CHARSET));
            }
            else {
                os.write(result.toString().getBytes(IODefine.LOCAL_CHARSET));
            }
            os.flush();
        }
        else {
            ExceptionUtil.publish("");
        }
    }

    /**
     * 
     * Description: 替换不支持的字符
     * 
     * @author jinyanan
     *
     * @param src src
     * @return String
     */
    private String toUtf8(String src) {
        // 转换文件名不支持的字符，ie6、ie7在转换文件名不支持的字符时存在问题，所以程序自己转
        src = StringUtil.replace(src, "\\", "_");
        src = StringUtil.replace(src, "/", "_");
        src = StringUtil.replace(src, ":", "_");
        src = StringUtil.replace(src, "*", "_");
        src = StringUtil.replace(src, "?", "_");
        src = StringUtil.replace(src, "\"", "_");
        src = StringUtil.replace(src, "<", "_");
        src = StringUtil.replace(src, ">", "_");
        src = StringUtil.replace(src, "|", "_");
        return src;
    }
}
