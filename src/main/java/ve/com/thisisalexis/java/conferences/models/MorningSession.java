package ve.com.thisisalexis.java.conferences.models;

import java.time.LocalTime;

import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;
import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;
import ve.com.thisisalexis.java.conference.exceptions.session.StartTimeGreaterThanEndTimeSessionException;

public class MorningSession extends Session {

	public MorningSession( LocalTime startTime, LocalTime endTime  ) 
			throws StartTimeGreaterThanEndTimeSessionException, SessionException {
		super( SessionTypeEnum.MORNING, startTime, endTime, true );
	}

}
