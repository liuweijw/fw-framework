package com.fw.api.log.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class LogFilter extends Filter<ILoggingEvent> {

	public static final String LOG_TAG = "LOG_FLAG";
	
	@Override
	public FilterReply decide(ILoggingEvent event) {
		if (event.getMessage().contains(LOG_TAG)) {
			return FilterReply.ACCEPT;
	    }
		return FilterReply.DENY;
	}

}
