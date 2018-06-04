package ve.com.thisisalexis.java.conference.exceptions.session;

public class StartTimeGreaterThanEndTimeSessionException extends SessionException {
	
	private static final long serialVersionUID = 6924706253802118027L;

	public StartTimeGreaterThanEndTimeSessionException() {
		super("Start time is greater than end time for this session");
	}

}
