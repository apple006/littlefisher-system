package com.yc.room1000.jyn.helloworld.service.impl;

import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;

import com.yc.room1000.core.activiti.IProcessAction;
import com.yc.room1000.core.utils.Room1000Logger;

/**
 * 
 * Description: Auto2ServiceImpl
 *  
 * Created on 2017年1月13日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class Auto2ServiceImpl implements IProcessAction {

    /**
     * serialVersionUID 
     */
    private static final long serialVersionUID = -4481635432789419742L;
    
    /** logger */
    private static Room1000Logger logger = Room1000Logger.getLogger(Auto2ServiceImpl.class);

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Map<String, Object> variables = execution.getVariables();
        logger.debug("------------Auto2ServiceImpl-----------");
        logger.debug("variables: " + variables);
    }

}