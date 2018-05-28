package ve.com.thisisalexis.java.conference.exceptions;

public class StartTimeGreaterThanEndTimeSessionException extends SessionException {

	public StartTimeGreaterThanEndTimeSessionException() {
		super("Start time is greater than end time for this session");
	}

}
