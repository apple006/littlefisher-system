package com.littlefisher.core.utils.db.cmd;

import java.util.Date;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;
import com.littlefisher.core.utils.db.dao.DBMapper;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月17日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class QryDBDateTimeCmd extends AbstractCommand<Date> {

//    @Override
//    public List<Object> getInputArgs() {
//        return null;
//    }

    @Override
    public Date execute() throws BaseAppException {
        DBMapper dbMapper = this.getMapper(DBMapper.class);
        Date date = dbMapper.getDBDateTime();
        return date;
    }

}
