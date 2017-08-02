package sample.common.core.logging;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogBackLogger extends AbstractLogger {
	
	private static final String FQCN = log.getName(); 

	public LogBackLogger(final String name, final C10LogHandler[] handlers) {
		super(name, handlers);
	}
	
	@Override
	public boolean isTraceEnable() {
		return log.isTraceEnabled();
	}

	@Override
	public boolean idDebugEnabled() {
		return log.isDebugEnabled();
	}

	@Override
	public boolean isInfoEnable() {
		return log.isInfoEnabled();
	}

	@Override
	public boolean isWarnEnable() {
		return log.isWarnEnabled();
	}

	@Override
	public boolean isErrorEnable() {
		return log.isErrorEnabled();
	}

	@Override
	public void trace(Object message) {
		trace(message);
	}

	@Override
	public void trace(Object message, Throwable t) {
		final Object result = callHandlers(C10LogLevel.TRACE, message, t);
		log.trace(FQCN, result, t);

	}

	@Override
	public void debug(Object message) {
		debug(message);

	}

	@Override
	public void debug(Object message, Throwable t) {
		final Object result = callHandlers(C10LogLevel.DEBUG, message, t);
		log.trace(FQCN, result, t);
	}

	@Override
	public void info(Object message) {
		info(message);
	}

	@Override
	public void info(Object message, Throwable t) {
		final Object result = callHandlers(C10LogLevel.INFO, message, t);
		log.trace(FQCN, result, t);
	}

	@Override
	public void warn(Object message) {
		warn(message);

	}

	@Override
	public void warn(Object message, Throwable t) {
		final Object result = callHandlers(C10LogLevel.WARN, message, t);
		log.trace(FQCN, result, t);
	}

	@Override
	public void error(Object message) {
		error(message);
	}

	@Override
	public void error(Object message, Throwable t) {
		final Object result = callHandlers(C10LogLevel.ERROR, message, t);
		log.trace(FQCN, result, t);
	}
}
