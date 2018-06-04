package ve.com.thisisalexis.java.conference.abstracts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.comparators.SortTalkByDurationDescComparator;
import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;
import ve.com.thisisalexis.java.conferences.models.Talk;

/***
 * An abstract representation of a conference which represent a wrapper for
 * AbstractSessions (sessions) and AbstractThematics (Thematics).
 * @author abravo
 */
public abstract class AbstractConference {
	
	public static final Logger LOGGER = Logger.getLogger( AbstractConference.class.getName() );
	private List<AbstractSession> sessions;
	private List<AbstractThematic> thematics;

	public AbstractConference( List<AbstractSession> sessions, List<AbstractTalk> talks )
	 throws SessionException {
		this.setSessions( new ArrayList<AbstractSession>() );
		this.addSessions( sessions );
		talks = this.sortTalks( talks );
		this.setThematics( new ArrayList<AbstractThematic>() );
	}
	
	protected List<AbstractTalk> sortTalks( List<AbstractTalk> talks ) {
		return AbstractTalk.sortTalksByDurationDescending( talks );
	}

	public List<AbstractSession> getSessions() {
		return sessions;
	}
	
	
	/**
	 * List only the sessions which permit to wrap talks into them
	 * @return A List of sessions
	 */
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

	protected void setSessions( List<AbstractSession> sessions ) {
		this.sessions = sessions;
	}
	
	public List<AbstractThematic> getThematics() {
		return thematics;
	}

	protected void setThematics( List<AbstractThematic> thematics ) {
		this.thematics = thematics;
	}
	
	public void doAlgo( List<AbstractTalk> talks ) {
		/*
		List<AbstractSession> talkWrapperSessions = this.getTalkWrapperSessions();
		
		if ( talkWrapperSessions == null ) {
			
		}
		
		
		int tiempoNecesarioTotal = 500;
		int tiempoDisponibleTotal = 240;
		
		
		for ( AbstractTalk talk : talks ) {
			
			if ( tiempoTarea < tiempoDisponible )
				Agregar
			
			
			for( AbstractSession session : talkWrapperSessions ) {
				
				int duration = session.getSessionDuration();
				int remainintTime
			}	
			
		}
		*/
	
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
	private boolean isSessionValid( AbstractSession sessionToCompare ) {
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
	
	private boolean addSession( AbstractSession session ) throws SessionException {
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
	
	private boolean addSessions( List<AbstractSession> sessions ) throws SessionException {
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
	
	private boolean addThematic( AbstractThematic thematic ) {
		try {
			return this.getThematics().add( thematic );
		} catch ( NullPointerException e ) {
			e.printStackTrace();
			LOGGER.log(Level.WARNING, "Thematic list was not defined in the conference instance", e);
		}
		return false;
	}
}