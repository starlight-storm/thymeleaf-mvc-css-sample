package sample.common.core.exception;

import java.util.List;

import sample.common.core.context.Message;

public class C10SystemException extends C10Exception {

	public C10SystemException() {
		super();
	}
	
	public C10SystemException(final Message message) {
		super(message);
	}
	
	public C10SystemException(final List<Message> messageList) {
		super(messageList);
	}
	
	public C10SystemException(final Throwable cause) {
		super(cause);
	}
	
	public C10SystemException(final Message message, final Throwable cause) {
		super(message, cause);
	}
	
	public C10SystemException(final List<Message> messageList, final Throwable cause) {
		super(messageList, cause);
	}

	private static final long serialVersionUID = 1L;	

}
