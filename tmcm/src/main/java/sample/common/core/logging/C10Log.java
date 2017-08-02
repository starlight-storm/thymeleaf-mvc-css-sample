package sample.common.core.logging;

public interface C10Log {
	boolean isTraceEnable();
	boolean idDebugEnabled();
	boolean isInfoEnable();
	boolean isWarnEnable();
	boolean isErrorEnable();
//	boolean isOff(); // Logback用
//	boolean isFatalEnable(); Log4j用
	
	
	
	
	void trace(Object message);
	void trace(Object message, Throwable t);
	void debug(Object message);
	void debug(Object message, Throwable t);
	void info(Object message);
	void info(Object message, Throwable t);
	void warn(Object message);
	void warn(Object message, Throwable t);
	void error(Object message);
	void error(Object message, Throwable t);
//	void off(Object message); // Logback用
//	void off(Object message, Throwable t); // Logback用
//	void fatal(Object message);　Log4j用
//	void fatal(Object message, Throwable t);　Log4j用
	
}
