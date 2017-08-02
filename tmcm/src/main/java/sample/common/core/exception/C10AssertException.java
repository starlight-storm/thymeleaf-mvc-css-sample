package sample.common.core.exception;

import sample.common.core.context.Message;

public class C10AssertException extends C10Exception {
	
	public C10AssertException(final Message message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;
}
