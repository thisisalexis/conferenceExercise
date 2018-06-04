package ve.com.thisisalexis.java.conference.exceptions.session;

public class StartTimeNotSetForSessionException extends SessionException {

	private static final long serialVersionUID = -5445140113890432177L;

	public StartTimeNotSetForSessionException() {
		super("Start time has not been set for the Session; you must set it before to set the end time.");
	}

}
