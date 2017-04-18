package com.yc.room1000.engine.attr.cmd;

import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;

import com.yc.room1000.engine.attr.dao.AttrDtoMapper;
import com.yc.room1000.engine.attr.model.AttrDto;

/**
 * 
 * Description: 
 *  
 * Created on 2017年3月1日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class QryAttrByIdCmd extends AbstractCommand<AttrDto> {
    
    /**
     * attrId
     */
    private Long attrId;
    
    /**
     * QryAttrByIdCmd
     * 
     * @param attrId attrId
     */
    public QryAttrByIdCmd(Long attrId) {
        this.attrId = attrId;
    }

    @Override
    public AttrDto execute() throws BaseAppException {
        AttrDtoMapper attrDtoMapper = this.getMapper(AttrDtoMapper.class);
        return attrDtoMapper.selectByPrimaryKey(attrId);
    }

}