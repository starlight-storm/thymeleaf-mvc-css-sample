package sample.common.core.context;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Message {
	private final String messageId;
	private final String message;
	
	protected Message() {
		this.messageId = null;
		this.message = null;
	}
	
	protected Message(final String messageId, final String message) {
		this.messageId = messageId;
		this.message = message;
	}
	
	public boolean isWarning() {
		return messageId.endsWith("I");
	}
	
	public boolean isError() {
		return messageId.endsWith("E");
	}
	
	public boolean isSeriousError() {
		return messageId.endsWith("S");
	}	
}
