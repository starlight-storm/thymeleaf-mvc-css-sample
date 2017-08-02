package sample.common.core.logging;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

abstract class AbstractLogger implements C10Log {
	
	private final List<C10LogHandler> handlers = new ArrayList<C10LogHandler>();
	
	public AbstractLogger(final String name, final C10LogHandler[] handlers) {
		if(ArrayUtils.isNotEmpty(handlers)) {
			for(final C10LogHandler handler : handlers) {
				this.handlers.add(handler);
			}
		}
	}

	protected Object callHandlers(final C10LogLevel logLevel, 
			final Object sourceMessage, final Throwable throwable) {
		Object currentMessage = sourceMessage;
		for(final C10LogHandler handler : handlers) {
			final C10LogEvent event = new C10LogEvent(logLevel, sourceMessage, currentMessage, throwable);
			currentMessage = handler.handleLog(event);
		}
		return currentMessage;
	}

}
