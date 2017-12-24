package com.fw.api.log;

/**
 * 日志类型
 *
 * @author lw
 * 
 */
public enum Logtype {

	/** 默认值，用于正常的开发输出，相当于log4j */
	COMMON,

	/** 后台统计日志志用 */
	STAT,

	/** 异常统计专用 */
	THROWS,

	/** 系统排查定位写日志用 */
	SYSTEM,

	/** 普通的用于写文件用 */
	FILE
}
