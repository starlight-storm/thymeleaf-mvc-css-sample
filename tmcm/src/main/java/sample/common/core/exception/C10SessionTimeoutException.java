package sample.common.core.exception;

import sample.common.core.context.Message;

public class C10SessionTimeoutException extends C10Exception {

	public C10SessionTimeoutException() {
		super();
	}

	public C10SessionTimeoutException(final Message message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;
}