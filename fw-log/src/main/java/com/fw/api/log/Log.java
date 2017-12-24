package com.fw.api.log;

public class Log {

	/**
	 * 
	 * 获取Logger
	 * 
	 * @param name
	 *            参数名，一般是编码或类名，但不要重复
	 * @return
	 * @example <调用范例>
	 */
	public static Logger get(String name) {
		return getLogFactory(Logtype.COMMON).getLogger(name);
	}

	/**
	 * 
	 * 获取Logger
	 * 
	 * @param name
	 *            参数名，一般是编码或类名，但不要重复
	 * @return
	 * @example <调用范例>
	 */
	public static Logger get(Class<?> clazz) {
		return getLogFactory(Logtype.COMMON).getLogger(clazz.getName());
	}

	private static ILogFactory getLogFactory(Logtype type) {
		return new Slf4jLogFactory(type);
	}
	
}
