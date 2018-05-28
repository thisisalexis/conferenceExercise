package ve.com.thisisalexis.java.conference.abstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.time.LocalTime;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.DateTimeException;

import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;
import ve.com.thisisalexis.java.conference.exceptions.SessionException;
import ve.com.thisisalexis.java.conference.exceptions.StartTimeGreaterThanEndTimeSessionException;
import ve.com.thisisalexis.java.conference.exceptions.StartTimeNotSetForSessionException;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractSession {

	public static final Logger LOGGER = Logger.getLogger( AbstractConference.class.getName() );
	private List<AbstractTalk> talks;
	private SessionTypeEnum sessionType;
	private LocalTime startTime;
	private LocalTime endTime;

	public AbstractSession() {}

	public List<AbstractTalk> getTalks() {
		return talks;
	}

	public void setTalks(List<AbstractTalk> talks) {
		this.talks = talks;
	}
	
	public SessionTypeEnum getSessionType() {
		return sessionType;
	}

	public void setSessionType(SessionTypeEnum sessionType) {
		this.sessionType = sessionType;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) throws SessionException {
		if ( this.getStartTime() == null ) 
			throw new StartTimeNotSetForSessionException();
		else if( endTime.compareTo( this.getStartTime() ) < 0 )
			throw new StartTimeGreaterThanEndTimeSessionException();
		this.endTime = endTime;
	}
	
	public int getMinutesSessionDuration() throws UnsupportedTemporalTypeException, 
		DateTimeException, ArithmeticException {
		Long difference = MINUTES.between(this.startTime, this.endTime);
		return difference.intValue();
	}
	
	public void addTalk(AbstractTalk talk ) {
		//TODO este es el codigo duro donde se irán haciendo cálculos
		
	}
}