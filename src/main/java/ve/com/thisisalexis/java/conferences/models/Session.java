package ve.com.thisisalexis.java.conferences.models;

import java.time.LocalTime;

import ve.com.thisisalexis.java.conference.abstracts.AbstractSession;
import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;
import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;
import ve.com.thisisalexis.java.conference.exceptions.session.StartTimeGreaterThanEndTimeSessionException;

public class Session extends AbstractSession {

	public Session( SessionTypeEnum sessionType, 
			LocalTime startTime, 
			LocalTime endTime, 
			boolean isAcceptTalks ) throws StartTimeGreaterThanEndTimeSessionException, SessionException {
		super( sessionType, startTime, endTime, isAcceptTalks );
	}
	
}