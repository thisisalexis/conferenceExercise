package ve.com.thisisalexis.java.conference.exceptions;

public class StartTimeNotSetForSessionException extends SessionException {

	public StartTimeNotSetForSessionException() {
		super("Start time has not been set for the Session; you must set it before to set the end time.");
	}

}
