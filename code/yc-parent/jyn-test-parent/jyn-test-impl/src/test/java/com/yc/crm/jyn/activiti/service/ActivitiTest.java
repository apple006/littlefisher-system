package com.yc.crm.jyn.activiti.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yc.activiti.IProcessDeploy;
import com.yc.activiti.IProcessStart;
import com.yc.activiti.impl.ProcessDeployImpl;
import com.yc.activiti.impl.ProcessStartImpl;

/**
 * 
 * Description: 
 *  
 * Created on 2017年1月13日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:activiti.cfg.xml")
@Rollback
@Transactional
public class ActivitiTest {

    /**
     * 
     * Description: 测试流程编译
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testDeploy() {
        String processName = "HelloWorldProcess";
        String classPath = "diagrams/helloworld";
        IProcessDeploy deploy = new ProcessDeployImpl();
        deploy.deployFlow(processName, classPath);
    }
    
    /**
     * 
     * Description: 测试流程启动
     * 
     * @author jinyanan
     *
     */
    @Test
    public void testStart() {
        String processInstanceKey = "HelloWorldProcess";
        IProcessStart start = new ProcessStartImpl();
        start.flowStart(processInstanceKey);
    }
}