package ve.com.thisisalexis.java.conferences.models;

import java.time.LocalTime;

import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;
import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;
import ve.com.thisisalexis.java.conference.exceptions.session.StartTimeGreaterThanEndTimeSessionException;

public class LunchSession extends Session {
	
	public LunchSession( LocalTime startTime, LocalTime endTime ) 
			throws StartTimeGreaterThanEndTimeSessionException, SessionException {
		super( SessionTypeEnum.LUNCH, startTime, endTime, false );
	}
	
}
