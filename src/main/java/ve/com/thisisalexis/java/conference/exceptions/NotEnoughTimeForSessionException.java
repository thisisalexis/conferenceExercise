package ve.com.thisisalexis.java.conference.exceptions;

public class NotEnoughTimeForSessionException extends SessionException {

	private static final long serialVersionUID = 2325618397498843812L;

	public NotEnoughTimeForSessionException(String message) {
		super(message);
	}

}
