package ve.com.thisisalexis.java.conferences.models;

import java.util.List;
import java.util.logging.Level;

import ve.com.thisisalexis.java.conference.abstracts.AbstractConference;
import ve.com.thisisalexis.java.conference.abstracts.AbstractSession;
import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.abstracts.AbstractThematic;

public class Conference extends AbstractConference {
	
	public Conference() {
		super();
	}

	@Override
	public boolean addSession(AbstractSession session) {
		try {
			if ( this.isSessionValid( session ) )
				return this.getSessions().add( session );
		} catch ( NullPointerException e ) {
			e.printStackTrace();
			LOGGER.log(Level.WARNING, "Session list was not defined in the conference instance", e);
		}
		return false;
	}

	@Override
	public boolean addThematic(AbstractThematic thematic) {
		try {
			return this.getThematics().add( thematic );
		} catch ( NullPointerException e ) {
			e.printStackTrace();
			LOGGER.log(Level.WARNING, "Thematic list was not defined in the conference instance", e);
		}
		return false;
	}

	@Override
	public boolean addTalks(List<AbstractTalk> talks) {
		return true;
	}
	
}