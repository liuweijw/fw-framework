package com.fw.api.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import com.fw.api.log.exception.LogConfigException;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;

/**
 * 加载Slf4j的配置文件，详细的可见类org.slf4j.LoggerFactory
 * 
 * @author liuweijw
 */
public class Slf4jLogger implements Lifecycle {

	/**
	 * 初始化失败异常ErrorID
	 */
	private String errorid = "fw.logging.ex.init";

	/**
	 * Logback配置文件，可以在Classpath或者在FileSystem中
	 */
	private Resource logback;

	/** 是否输出堆栈信息，默认不输出，接口属性 */
	private static boolean isStack = false;

	/** 是否输出堆栈信息，默认不输出,spring注入属性 */
	private boolean printStackTrace = false;

	@Override
	public void cleanup() {
		// nothing to do.
	}

	@Override
	public void initializing() {
		if (printStackTrace) {
			isStack = true;
		}
		if (logback != null) {
			LoggerContext loggerContext = (LoggerContext) LoggerFactory
					.getILoggerFactory();
			loggerContext.reset();
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(loggerContext);
			try {
				configurator.doConfigure(logback.getInputStream());
			} catch (Exception e) {
				new LogConfigException(errorid, e,
						"Initializing logger configuration faile!");
			}
		}
	}

	/**
	 * 
	 * @description: 获得log对象
	 * @param: name Logger对象的名字，即Log.get("name")的name，可以是类名，也可以普通的编码
	 * @return: @see org.slf4j.Logger
	 * @throws: < 抛出异常列表，格式： 异常类型 - 描述 >
	 */
	public static Logger get(String name) {
		return LoggerFactory.getLogger(name);
	}

	/**
	 * 
	 * @description: 获得log对象
	 * @param: name Logger对象的名字，类Class
	 * @return: @see org.slf4j.Logger
	 * @throws: < 抛出异常列表，格式： 异常类型 - 描述 >
	 */
	public static Logger get(Class<?> clazz) {
		return LoggerFactory.getLogger(clazz);
	}

	// ///////////////////////////////////Getter and
	// Setter/////////////////////////////////////

	public String getErrorid() {
		return errorid;
	}

	public Resource getLogback() {
		return logback;
	}

	public void setLogback(Resource logback) {
		this.logback = logback;
	}

	public void setErrorid(String errorid) {
		this.errorid = errorid;
	}

	public void setPrintStackTrace(boolean printStackTrace) {
		this.printStackTrace = printStackTrace;
	}

	/** 是否输出堆栈信息，默认不输出 */
	public static boolean isStack() {
		return isStack;
	}
}
