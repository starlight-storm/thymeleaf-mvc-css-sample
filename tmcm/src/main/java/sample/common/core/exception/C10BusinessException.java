package sample.common.core.exception;

import java.util.List;

import sample.common.core.context.Message;

public class C10BusinessException extends C10Exception {

	public C10BusinessException() {
		super();
	}
	
	public C10BusinessException(final Message message) {
		super(message);
	}
	
	public C10BusinessException(final List<Message> messageList) {
		super(messageList);
	}
	
	public C10BusinessException(final Throwable cause) {
		super(cause);
	}
	
	public C10BusinessException(final Message message, final Throwable cause) {
		super(message, cause);
	}
	
	public C10BusinessException(final List<Message> messageList, final Throwable cause) {
		super(messageList, cause);
	}

	private static final long serialVersionUID = 1L;	

}
