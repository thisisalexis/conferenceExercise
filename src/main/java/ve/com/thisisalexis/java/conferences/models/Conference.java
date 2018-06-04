package ve.com.thisisalexis.java.conferences.models;

import java.util.List;
import java.util.logging.Level;

import ve.com.thisisalexis.java.conference.abstracts.AbstractConference;
import ve.com.thisisalexis.java.conference.abstracts.AbstractSession;
import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.abstracts.AbstractThematic;
import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;

public class Conference<T extends AbstractTalk> extends AbstractConference<T> {
	
	public Conference( List<AbstractSession> sessions, List<T> talks ) throws SessionException {
		super( sessions, talks );
	}
	
	@Override
	protected boolean prepareConference() {

		try {
			List<AbstractSession> talkWrapperSessions = this.getTalkWrapperSessions();
			
			if ( talkWrapperSessions == null ) {
				
			}
			
			AbstractThematic currentThematic;
			List<AbstractThematic> thematics = this.getThematics();
			
			if ( thematics.size() > 0 ) {
				currentThematic = this.getThematics().get( this.getThematics().size() - 1 );
			} else {
				currentThematic = new Thematic();
				this.addThematic( currentThematic );
			}
			
			// currentThematic.getRemainintTime();
			for ( AbstractSession session : this.getSessions() ) {
				int availableTime = session.getSessionDuration();
				int remainintTime = availableTime;
				
				// for ()
				
				
			}
			
		} catch ( NullPointerException e ) {
			e.printStackTrace();
			Conference.LOGGER.log( Level.WARNING, "There was a problem while setting up the conference", e );
		}
			
		/*
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
		
		return false;
	}
	
}