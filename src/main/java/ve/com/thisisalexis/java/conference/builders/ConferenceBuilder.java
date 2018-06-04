package ve.com.thisisalexis.java.conference.builders;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.abstracts.AbstractConference;
import ve.com.thisisalexis.java.conference.abstracts.AbstractSession;
import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;
import ve.com.thisisalexis.java.conferences.models.Conference;

public class ConferenceBuilder<T extends AbstractTalk> {

	public static final Logger LOGGER = Logger.getLogger( AbstractConference.class.getName() );
	private List<AbstractSession> sessions;
	private List<T> talks;

	public ConferenceBuilder() {}

	public ConferenceBuilder<T> setSessions(List<AbstractSession> sessions) {
		this.sessions = sessions;
		return this;
	}
	
	private List<AbstractSession> getSessions() {
		return sessions;
	}

	public ConferenceBuilder<T> setTalks(List<T> talks) {
		this.talks = talks;
		return this;
	}
	
	private List<T> getTalks() {
		return talks;
	}
	
	public AbstractConference<T> build() {
		try {
			return new Conference<T>( this.getSessions(), this.getTalks() );
		} catch( SessionException e ) {
			e.printStackTrace();
			LOGGER.log( Level.WARNING, e.getMessage(), e );
		} catch ( Exception e ) {
			e.printStackTrace();
			LOGGER.log( Level.WARNING , "There was a problem while building the conference instance", e);
		}
		return null;
	}
	
}