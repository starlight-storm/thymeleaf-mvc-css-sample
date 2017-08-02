package sample.common.core.logging;

import lombok.Value;

@Value
public class C10LogEvent {
	private final C10LogLevel logLevel;
	private final Object sourceMessage;
	private final Object currentMessage;
	private final Throwable throwable;
}
