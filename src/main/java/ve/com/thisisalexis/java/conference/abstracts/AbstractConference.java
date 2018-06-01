package ve.com.thisisalexis.java.conference.abstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractConference {
	
	public static final Logger LOGGER = Logger.getLogger( AbstractConference.class.getName() );
	private List<AbstractSession> sessions;
	private List<AbstractThematic> thematics;

	public AbstractConference() {
		this.setSessions( new ArrayList<AbstractSession>() );
		this.setThematics( new ArrayList<AbstractThematic>() );
	}

	public List<AbstractSession> getSessions() {
		return sessions;
	}

	protected void setSessions( List<AbstractSession> sessions ) {
		this.sessions = sessions;
	}
	
	public List<AbstractThematic> getThematics() {
		return thematics;
	}

	protected void setThematics( List<AbstractThematic> thematics ) {
		this.thematics = thematics;
	}
	
	public int getNeeedTimeForConference() {
		return 1; // TODO
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	/***
	 * It checks if an AbstractSession instance can be added to the session list
	 * validating that the time of the new session does not match the time of
	 * existing sessions.
	 * @param newSession an abstractSession instance to check against the list of current sessions
	 * @return true if the session is valid and can be added to the session list
	 */
	public boolean isSessionValid( AbstractSession sessionToCompare ) {
		try {
			for( AbstractSession session : this.getSessions() ) {
				if ( session.isTimeMatches(sessionToCompare) )
					return false;
			}
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
			LOGGER.log( Level.WARNING, "There was a problem while validating if the session is valid", e );
		}
		return false;
	}
	
	public abstract boolean addSession( AbstractSession session );
	public abstract boolean addThematic( AbstractThematic thematic );
	public abstract boolean addTalks( List<AbstractTalk> talks );
	
}