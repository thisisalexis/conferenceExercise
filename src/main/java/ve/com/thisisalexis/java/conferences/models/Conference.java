package ve.com.thisisalexis.java.conferences.models;

import java.util.List;

import ve.com.thisisalexis.java.conference.abstracts.AbstractConference;
import ve.com.thisisalexis.java.conference.abstracts.AbstractSession;
import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;

public class Conference extends AbstractConference {
	
	public Conference( List<AbstractSession> sessions, List<AbstractTalk> talks ) throws SessionException {
		super( sessions, talks );
	}
	
}