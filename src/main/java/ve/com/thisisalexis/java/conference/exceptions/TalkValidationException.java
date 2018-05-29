package ve.com.thisisalexis.java.conference.exceptions;

public class TalkValidationException extends Exception {

	private static final long serialVersionUID = -6812436662547077478L;

	public TalkValidationException(String message) {
		super( message );
	}
	
}
