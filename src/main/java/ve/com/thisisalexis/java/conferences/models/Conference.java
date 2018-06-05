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
	protected boolean prepareConference( List<T> allTalks ) {

		try {
			List<AbstractSession> talkWrapperSessions = this.getTalkWrapperSessions();
			
			if ( talkWrapperSessions == null ) {
				// TODO lanzar excepti+op si no existen sessiones wrapanles
			}
			
			
			AbstractThematic currentThematic = new Thematic();
			
			// currentThematic.getRemainintTime();
			for ( AbstractSession session : talkWrapperSessions ) {
				int remainingTimeForSession = session.getSessionDuration();
				
				for ( T talk :  allTalks ) {
					if ( talk.getTalkDuration() <= remainingTimeForSession ) {
						currentThematic.getTalks().add( talk ); //TODO crear un método addTalks
						remainingTimeForSession -= talk.getTalkDuration();
						allTalks.remove( talk );
					} else {
						break;
					}
				}	
			}
			
			if ( allTalks.size() > 0 ) {
				//TODO repetir proceso anterior: crear temática e ir agregando
			}
			
		} catch ( NullPointerException e ) {
			e.printStackTrace();
			Conference.LOGGER.log( Level.WARNING, "There was a problem while setting up the conference", e );
		}
		return false;
	}
	
	protected void addThematic( List<Talk> remainingtalks ) {
		// TODO aquí se decide si hay tematica o si se crea una nueva
	}
	
	protected void addTalksToThematic( AbstractThematic thematic ) {
		//TODO aquí se agregan las tareas a la temática según tiempo disponible en la misma
	}
	
}