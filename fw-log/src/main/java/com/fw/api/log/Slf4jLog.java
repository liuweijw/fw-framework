package com.fw.api.log;

import org.slf4j.Marker;

/**
 * 日志接口的实现类
 * 
 * @author liuweijw
 */
public class Slf4jLog implements Logger {

	/** 是否输出堆栈信息，默认不输出 */
	protected boolean printStackTrace = false;

	org.slf4j.Logger log;

	public Slf4jLog(org.slf4j.Logger log, boolean printStackTrace) {
		this.log = log;
		this.printStackTrace = printStackTrace;
	}

	@Override
	public void debug(String msg) {
		this.log.debug(msg);
	}

	@Override
	public void debug(String format, Object arg) {
		this.log.debug(format, arg);

	}

	@Override
	public void debug(String format, Object... argArray) {
		this.log.debug(format, argArray);
	}

	@Override
	public void debug(String msg, Throwable t) {
		if (printStackTrace) {
			this.log.debug(msg, t);
		} else {
			this.log.debug(msg, t.toString());
		}
	}

	@Override
	public void debug(Marker marker, String msg) {
		this.log.debug(marker, msg);

	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		this.log.debug(format, arg1, arg2);

	}

	@Override
	public void debug(Marker marker, String format, Object arg) {
		this.log.debug(marker, format, arg);

	}

	@Override
	public void debug(Marker marker, String format, Object... argArray) {
		this.log.debug(marker, format, argArray);

	}

	@Override
	public void debug(Marker marker, String msg, Throwable t) {
		if (printStackTrace) {
			this.log.debug(marker, msg, t);
		} else {
			this.log.debug(marker, msg, t.toString());
		}
	}

	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		this.log.debug(marker, format, arg1, arg2);
	}

	@Override
	public void error(String msg) {
		this.log.error(msg);

	}

	@Override
	public void error(String format, Object arg) {
		this.log.error(format, arg);

	}

	@Override
	public void error(String format, Object... argArray) {
		this.log.error(format, argArray);

	}

	@Override
	public void error(String msg, Throwable t) {
		if (printStackTrace) {
			this.log.error(msg, t);
		} else {
			this.log.error(msg, t.toString());
		}
	}

	@Override
	public void errorDetail(String msg, Throwable t) {
		this.log.error(msg, t);
	}

	@Override
	public void error(Marker marker, String msg) {
		this.log.error(marker, msg);

	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		this.log.error(format, arg1, arg2);

	}

	@Override
	public void error(Marker marker, String format, Object arg) {
		this.log.error(marker, format, arg);

	}

	@Override
	public void error(Marker marker, String format, Object... argArray) {
		this.log.error(marker, format, argArray);

	}

	@Override
	public void error(Marker marker, String msg, Throwable t) {
		if (printStackTrace) {
			this.error(marker, msg, t);
		} else {
			this.error(marker, msg, t.toString());
		}
	}

	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		this.error(marker, format, arg1, arg2);
	}

	@Override
	public String getName() {
		return this.log.getName();
	}

	@Override
	public void info(String msg) {
		this.log.info(msg);
	}

	@Override
	public void info(String format, Object arg) {
		this.log.info(format, arg);

	}

	@Override
	public void info(String format, Object... argArray) {
		this.log.info(format, argArray);

	}

	@Override
	public void info(String msg, Throwable t) {
		if (printStackTrace) {
			this.log.info(msg, t);
		} else {
			this.log.info(msg, t.toString());
		}
	}

	@Override
	public void info(Marker marker, String msg) {
		this.log.info(marker, msg);

	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		this.log.info(format, arg1, arg2);

	}

	@Override
	public void info(Marker marker, String format, Object arg) {
		this.log.info(marker, format, arg);

	}

	@Override
	public void info(Marker marker, String format, Object... argArray) {
		this.log.info(marker, format, argArray);

	}

	@Override
	public void info(Marker marker, String msg, Throwable t) {
		if (printStackTrace) {
			this.log.info(marker, msg, t);
		} else {
			this.log.info(marker, msg, t.toString());
		}
	}

	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		this.log.info(marker, format, arg1, arg2);

	}

	@Override
	public boolean isDebugEnabled() {
		return this.log.isDebugEnabled();
	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		return this.log.isDebugEnabled(marker);
	}

	@Override
	public boolean isErrorEnabled() {
		return this.log.isErrorEnabled();
	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		return this.log.isDebugEnabled(marker);
	}

	@Override
	public boolean isInfoEnabled() {
		return this.log.isInfoEnabled();
	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		return this.log.isInfoEnabled(marker);
	}

	@Override
	public boolean isTraceEnabled() {
		return this.log.isTraceEnabled();
	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		return this.log.isTraceEnabled(marker);
	}

	@Override
	public boolean isWarnEnabled() {
		return this.log.isWarnEnabled();
	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		return this.isWarnEnabled(marker);
	}

	@Override
	public void trace(String msg) {
		this.log.trace(msg);
	}

	@Override
	public void trace(String format, Object arg) {
		this.log.trace(format, arg);
	}

	@Override
	public void trace(String format, Object... argArray) {
		this.log.trace(format, argArray);
	}

	@Override
	public void trace(String msg, Throwable t) {
		if (printStackTrace) {
			this.log.trace(msg, t);
		} else {
			this.log.trace(msg, t.toString());
		}
	}

	@Override
	public void trace(Marker marker, String msg) {
		this.log.trace(marker, msg);
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		this.log.trace(format, arg1, arg2);
	}

	@Override
	public void trace(Marker marker, String format, Object arg) {
		this.log.trace(marker, format, arg);
	}

	@Override
	public void trace(Marker marker, String format, Object... argArray) {
		this.log.trace(marker, format, argArray);
	}

	@Override
	public void trace(Marker marker, String msg, Throwable t) {
		if (printStackTrace) {
			this.log.trace(marker, msg, t);
		} else {
			this.log.trace(marker, msg, t.toString());
		}
	}

	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		this.log.trace(marker, format, arg1, arg2);
	}

	@Override
	public void warn(String msg) {
		this.log.warn(msg);
	}

	@Override
	public void warn(String format, Object arg) {
		this.log.warn(format, arg);
	}

	@Override
	public void warn(String format, Object... argArray) {
		this.log.warn(format, argArray);

	}

	@Override
	public void warn(String msg, Throwable t) {
		if (printStackTrace) {
			this.log.warn(msg, t.toString());
		} else {
			this.log.warn(msg, t.toString());
		}
	}

	@Override
	public void warn(Marker marker, String msg) {
		this.log.warn(marker, msg);

	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		this.log.warn(format, arg1, arg2);

	}

	@Override
	public void warn(Marker marker, String format, Object arg) {
		this.log.warn(marker, format, arg);

	}

	@Override
	public void warn(Marker marker, String format, Object... argArray) {
		this.log.warn(marker, format, argArray);

	}

	@Override
	public void warn(Marker marker, String msg, Throwable t) {
		if (printStackTrace) {
			this.log.warn(marker, msg, t);
		} else {
			this.log.warn(marker, msg, t.toString());
		}

	}

	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		this.log.warn(marker, format, arg1, arg2);

	}

}
