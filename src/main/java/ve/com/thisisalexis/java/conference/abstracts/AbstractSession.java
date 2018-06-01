package ve.com.thisisalexis.java.conference.abstracts;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalTime;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.DateTimeException;
import static java.time.temporal.ChronoUnit.MINUTES;

import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;
import ve.com.thisisalexis.java.conference.exceptions.SessionException;
import ve.com.thisisalexis.java.conference.exceptions.StartTimeGreaterThanEndTimeSessionException;
import ve.com.thisisalexis.java.conference.exceptions.StartTimeNotSetForSessionException;

public abstract class AbstractSession {

	public static final Logger LOGGER = Logger.getLogger( AbstractConference.class.getName() );
	private SessionTypeEnum sessionType;
	private LocalTime startTime;
	private LocalTime endTime;
	private boolean isAcceptTalks;

	public AbstractSession() {} // TODO inicializar variables de instancia
	
	public SessionTypeEnum getSessionType() {
		return sessionType;
	}

	public void setSessionType(SessionTypeEnum sessionType) {
		this.sessionType = sessionType;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}

	private void setStartTime( LocalTime startTime ) throws StartTimeGreaterThanEndTimeSessionException {
		if( this.getEndTime() != null && startTime.isAfter( this.getEndTime() ) ) {
			throw new StartTimeGreaterThanEndTimeSessionException();
		}
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	private void setEndTime( LocalTime endTime ) throws SessionException {
		if ( this.getStartTime() == null ) 
			throw new StartTimeNotSetForSessionException();
		else if( endTime.compareTo( this.getStartTime() ) < 0 )
			throw new StartTimeGreaterThanEndTimeSessionException();
		this.endTime = endTime;
	}
	
	public int getSessionDuration() throws UnsupportedTemporalTypeException, 
		DateTimeException, ArithmeticException {
		Long difference = MINUTES.between(this.startTime, this.endTime);
		return difference.intValue();
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
	public boolean isTimeMatches( AbstractSession sessionToCompare ) {
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