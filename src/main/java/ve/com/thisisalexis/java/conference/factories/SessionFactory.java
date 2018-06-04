package ve.com.thisisalexis.java.conference.factories;

import java.time.LocalTime;

import ve.com.thisisalexis.java.conference.abstracts.AbstractSession;
import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;
import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;
import ve.com.thisisalexis.java.conference.exceptions.session.StartTimeGreaterThanEndTimeSessionException;
import ve.com.thisisalexis.java.conferences.models.AfternoonSession;
import ve.com.thisisalexis.java.conferences.models.LunchSession;
import ve.com.thisisalexis.java.conferences.models.MorningSession;

/***
 * This class implements the Factory pattern to be able to create
 * different type of pre set sessions (morning, afternoon, and so on)
 * @author abravo
 * @since 2018-05-27
 */
public class SessionFactory {
	
	private SessionFactory() {  }
	
	public static AbstractSession getSession( 
			SessionTypeEnum sessionType, 
			LocalTime startTime, 
			LocalTime endTime ) throws StartTimeGreaterThanEndTimeSessionException, SessionException {
		if( sessionType.equals( SessionTypeEnum.MORNING ) ) {
			return new MorningSession( startTime, endTime );
		} else if ( sessionType.equals( SessionTypeEnum.AFTERNOON ) ) {
			return new AfternoonSession( startTime, endTime );
		} else if ( sessionType.equals( SessionTypeEnum.LUNCH ) ) {
			return new LunchSession( startTime, endTime );
		}
		return null;
	}
	
}