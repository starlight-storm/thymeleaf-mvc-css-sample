package sample.common.core.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.SystemUtils;

import sample.common.core.context.Message;

public class C10Exception extends RuntimeException {

	private final List<Message> messageList = new ArrayList<Message>();
	
	public C10Exception() {
		super();
	}
	
	public C10Exception(final Message message) {
		super();
		this.messageList.add(message);
	}
	
	public C10Exception(final List<Message> messageList) {
		super();
		this.messageList.addAll(messageList);
	}
	
	public C10Exception(final Throwable cause) {
		super(cause);
	}
	
	public C10Exception(final Message message, final Throwable cause) {
		super(cause);
		this.messageList.add(message);
	}
	
	public C10Exception(final List<Message> messageList, final Throwable cause) {
		super(cause);
		this.messageList.addAll(messageList);
	}
	
	public List<Message> getMessageList() {
		return Collections.unmodifiableList(messageList);
	}
	
	public String getMessage() {
		if(messageList.isEmpty()) {
			final Throwable cause = getCause();
			if(cause != null) return cause.getMessage();
			return null; // TODO: これで良いの既存Spring?
		}
		final StringBuilder builder = new StringBuilder();
		for(final Message message:messageList) {
			if(builder.length() > 0) {
				builder.append(SystemUtils.LINE_SEPARATOR);
			}
			builder.append(message);
		}
		return builder.toString();
	}
	
	private static final long serialVersionUID = 1L;

}
