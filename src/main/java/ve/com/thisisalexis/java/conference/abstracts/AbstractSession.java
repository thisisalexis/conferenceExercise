package ve.com.thisisalexis.java.conference.abstracts;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalTime;
import java.time.DateTimeException;
import static java.time.temporal.ChronoUnit.MINUTES;

import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;
import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;
import ve.com.thisisalexis.java.conference.exceptions.session.StartTimeGreaterThanEndTimeSessionException;
import ve.com.thisisalexis.java.conference.exceptions.session.StartTimeNotSetForSessionException;

public abstract class AbstractSession {

	public static final Logger LOGGER = Logger.getLogger( AbstractConference.class.getName() );
	private SessionTypeEnum sessionType;
	private LocalTime startTime;
	private LocalTime endTime;
	private boolean isAcceptTalks;
	private int sessionDuration = 0;

	public AbstractSession( SessionTypeEnum sessionType, 
			LocalTime startTime, 
			LocalTime endTime, 
			boolean isAcceptTalks ) throws StartTimeGreaterThanEndTimeSessionException, SessionException {
		this.setSessionType( sessionType );
		this.setStartTime( startTime );
		this.setEndTime( endTime );
		this.setAcceptTalks( isAcceptTalks );
		this.setSessionDuration();
	}
	
	public SessionTypeEnum getSessionType() {
		return sessionType;
	}

	protected void setSessionType(SessionTypeEnum sessionType) {
		this.sessionType = sessionType;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}

	protected void setStartTime( LocalTime startTime ) throws StartTimeGreaterThanEndTimeSessionException {
		if( this.getEndTime() != null && startTime.isAfter( this.getEndTime() ) ) {
			throw new StartTimeGreaterThanEndTimeSessionException();
		}
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	protected void setEndTime( LocalTime endTime ) throws SessionException {
		if ( this.getStartTime() == null ) 
			throw new StartTimeNotSetForSessionException();
		else if( endTime.compareTo( this.getStartTime() ) < 0 )
			throw new StartTimeGreaterThanEndTimeSessionException();
		this.endTime = endTime;
	}
	
	public int getSessionDuration() {
		return this.sessionDuration;
	}
	
	protected void setSessionDuration() {
		try {
			Long difference = MINUTES.between(this.startTime, this.endTime);
			this.sessionDuration = difference.intValue();
		} catch ( DateTimeException e ) {
			e.printStackTrace();
			LOGGER.log( Level.WARNING, "There was a problem while trying to set session duration", e );
			this.sessionDuration = 0;
		} catch ( ArithmeticException e ) {
			e.printStackTrace();
			LOGGER.log( Level.WARNING, "There was a problem while calculating session duration", e );
			this.sessionDuration = 0;
		}
	}
	
	public boolean isAcceptTalks() {
		return isAcceptTalks;
	}

	protected void setAcceptTalks(boolean isAcceptTalks) {
		this.isAcceptTalks = isAcceptTalks;
	}
	
	/***
	 * It check if the time between the start and end of the current session 
	 * matches the time of a given session
	 * @param sessionToCompare
	 * @return true if the time of both sessions matches in some way
	 */
	protected boolean isTimeMatches( AbstractSession sessionToCompare ) {
		try {
			return this.getEndTime().isAfter( sessionToCompare.getStartTime() )
					|| this.getStartTime().isBefore( sessionToCompare.getEndTime() ) ;
		} catch ( Exception e ) {
			e.printStackTrace();
			LOGGER.log( Level.WARNING, "There was an error while trying to check if the session matches", e );
		}
		return false;
	}
	
	@Override
	public String toString() {
		try {
			return this.getSessionType().toString() + ": From " + this.getStartTime().toString() + " to " + this.getEndTime() + ".";
		} catch (NullPointerException e) {
			e.printStackTrace();
			LOGGER.log( Level.WARNING, "There was a problem when trying to print out the session", e );
		}
		return null;
	}
}