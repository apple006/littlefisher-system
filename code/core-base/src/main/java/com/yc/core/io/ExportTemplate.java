package com.yc.core.io;

import java.util.Map;

import com.yc.core.exception.BaseAppException;

/**
 * 
 * Description: 导出接口类
 *  
 * Created on 2017年1月5日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public interface ExportTemplate {
    
    /**
     * 
     * Description: 具体导出业务逻辑
     * 
     * @author jinyanan
     *
     * @param paramsMap 入参
     * @return Map<String, Object> 其中要包含文件名，文件具体类等
     * @throws BaseAppException <br>
     */
    @SuppressWarnings("rawtypes")
    Map<String, Object> doExport(Map paramsMap) throws BaseAppException;
}
