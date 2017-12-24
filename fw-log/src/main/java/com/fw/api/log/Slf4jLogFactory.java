package com.fw.api.log;

/**
 * 一个调用slf4j来实现日志的工厂类
 *
 * @author lw
 */
public class Slf4jLogFactory implements ILogFactory {

	@SuppressWarnings("unused")
	private Logtype logtype;

	public Slf4jLogFactory(Logtype logtype) {
		this.logtype = logtype;
	}

	@Override
	public Logger getLogger(String name) {
		return new Slf4jLog(Slf4jLogger.get(name), Slf4jLogger.isStack());
	}

}
