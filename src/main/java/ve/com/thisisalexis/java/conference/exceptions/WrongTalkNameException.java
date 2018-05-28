package ve.com.thisisalexis.java.conference.exceptions;

public class WrongTalkNameException extends TalkValidationException {
	private static final long serialVersionUID = 1L;
	
	public WrongTalkNameException() {
		super( "Talk title can only contain numbers: " );
	}
	
}
