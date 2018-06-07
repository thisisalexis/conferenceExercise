package ve.com.thisisalexis.java.conference.abstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;

public abstract class AbstractThematic {

	public static final Logger LOGGER = Logger.getLogger( AbstractThematic.class.getName() );
	private List<AbstractSession> sessions;

	public AbstractThematic( List<AbstractSession> sessions ) {
		this.setSessions( sessions );
	}
	
	public List<AbstractSession> getSessions() {
		return sessions;
	}

	protected void setSessions(List<AbstractSession> sessions) {
		this.sessions = sessions;
	}
	
	protected boolean addSessions( List<AbstractSession> sessions ) throws SessionException {
		try {
			for ( AbstractSession session : sessions ) {
				if ( !this.addSession( session ) )
					return false;
			}
			return true;
		} catch ( NullPointerException e ) {
			e.printStackTrace();
			LOGGER.log(Level.WARNING, "Session list was not defined in the conference instance", e);
		}
		return false;
	}
	
	protected boolean addSession( AbstractSession session ) throws SessionException {
		try {
			if ( this.isSessionValid( session ) )
				return this.getSessions().add( session );
			else
				throw new SessionException("There was a problem and the session could not be added");
		} catch ( Exception e ) {
			e.printStackTrace();
			LOGGER.log(Level.WARNING, "Session list was not defined in the conference instance", e);
			throw new SessionException("There was a problem and the session could not be added");
		}
	}
	
	protected boolean isSessionValid( AbstractSession sessionToCompare ) {
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
	
	public List<AbstractSession> getTalkWrapperSessions() {
		List<AbstractSession> talkWrapperSessions = new ArrayList<AbstractSession>();
		try {
			for( AbstractSession session : this.getSessions() ) {
				if ( session.isAcceptTalks() )
					talkWrapperSessions.add( session );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
			LOGGER.log( Level.WARNING, "There was a problem while trying to get talk wrappers", e );
		}
		return talkWrapperSessions;
	}
	
}