package com.littlefisher.core.interceptor;

import com.littlefisher.core.interceptor.cfg.TransactionPropagation;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月10日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class CommandConfig {

    /**
     * contextReusePossible 是否可被多次使用
     */
    private boolean contextReusePossible;

    /**
     * propagation 事务类型
     */
    private TransactionPropagation propagation;
    
    /**
     * CommandConfig
     */
    public CommandConfig() {
        this.contextReusePossible = true;
        this.propagation = TransactionPropagation.REQUIRED;
    }
    
    /**
     * CommandConfig
     * @param contextReusePossible <br>
     */
    public CommandConfig(boolean contextReusePossible) {
        this.contextReusePossible = contextReusePossible;
        this.propagation = TransactionPropagation.REQUIRED;
    }
    
    /**
     * CommandConfig
     * @param commandConfig <br>
     */
    protected CommandConfig(CommandConfig commandConfig) {
        this.contextReusePossible = commandConfig.contextReusePossible;
        this.propagation = commandConfig.propagation;
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @param contextReusePossible <br>
     * @return <br>
     */
    public CommandConfig setContextReusePossible(boolean contextReusePossible) {
        CommandConfig config = new CommandConfig(this);
        config.contextReusePossible = contextReusePossible;
        return config;
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @return <br>
     */
    public CommandConfig transactionRequired() {
        CommandConfig config = new CommandConfig(this);
        config.propagation = TransactionPropagation.REQUIRED;
        return config;
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @return <br>
     */
    public static CommandConfig transactionRequiresNew() {
        CommandConfig config = new CommandConfig();
        config.contextReusePossible = false;
        config.propagation = TransactionPropagation.REQUIRES_NEW;
        return config;
    }
    
    /**
     * 
     * Description: <br> 
     *  
     * @author jinyanan<br>
     * @taskId <br>
     * @return <br>
     */
    public static CommandConfig transactionNotSupported() {
        CommandConfig config = new CommandConfig();
        config.contextReusePossible = false;
        config.propagation = TransactionPropagation.NOT_SUPPORTED;
        return config;
    }
    
    public boolean isContextReusePossible() {
        return contextReusePossible;
    }
    
    public TransactionPropagation getTransactionPropagation() {
        return propagation;
    }
}
