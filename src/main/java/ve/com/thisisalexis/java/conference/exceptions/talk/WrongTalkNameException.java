package ve.com.thisisalexis.java.conference.exceptions.talk;

public class WrongTalkNameException extends TalkValidationException {

	private static final long serialVersionUID = 3936780300320143150L;

	public WrongTalkNameException() {
		super( "Talk title can only contain numbers: " );
	}
	
}
