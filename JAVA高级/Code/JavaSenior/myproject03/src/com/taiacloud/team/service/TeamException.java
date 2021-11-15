package com.taiacloud.team.service;
/**
 * 
 * @Description 自定义异常类
 * @author taia
 * @version 
 * @date 2021年10月11日上午11:38:26
 *
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -3387513124229948L;
	
    public TeamException() {
    	super();
    }
    
    public TeamException(String msg) {
    	super(msg);
    }
}
