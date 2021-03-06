package com.littlefisher.blog.system.cmd;

import com.littlefisher.blog.system.dao.SystemParamDtoMapper;
import com.littlefisher.blog.system.model.SystemParamDto;
import com.littlefisher.core.exception.BaseAppException;
import com.littlefisher.core.interceptor.AbstractCommand;

/**
 * 
 * Description: 修改系统参数
 *  
 * Created on 2017年5月23日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class UpdateSystemParamCmd extends AbstractCommand<SystemParamDto> {
    
    /**
     * systemParamDto
     */
    private SystemParamDto systemParamDto;

    /** 
     * Description: 构造函数
     *
     * @author jinyanan
     *
     * @param systemParamDto systemParamDto 
     */ 
    public UpdateSystemParamCmd(SystemParamDto systemParamDto) {
        super();
        this.systemParamDto = systemParamDto;
    }

    @Override
    public SystemParamDto execute() throws BaseAppException {
        SystemParamDtoMapper systemParamDtoMapper = this.getMapper(SystemParamDtoMapper.class);
        systemParamDtoMapper.updateByPrimaryKey(systemParamDto);
        return systemParamDto;
    }

}
