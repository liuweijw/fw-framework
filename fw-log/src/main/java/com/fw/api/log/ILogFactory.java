package com.fw.api.log;

/**
 * 
 * 获取Logger的接口，可以实现本接口获取其他日志的Logger
 * 
 * @author lw
 */
public interface ILogFactory {

	Logger getLogger(String name);

}