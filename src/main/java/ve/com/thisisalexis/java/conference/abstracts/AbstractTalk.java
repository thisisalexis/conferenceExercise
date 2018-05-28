package ve.com.thisisalexis.java.conference.abstracts;

import java.util.List;
import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.exceptions.TalkValidationException;
import ve.com.thisisalexis.java.conference.exceptions.WrongTalkNameException;

public abstract class AbstractTalk {
	
	public static final Logger LOGGER = Logger.getLogger( AbstractConference.class.getName() );
	
	private String talkName;
	private int talkDuration;
	
	public AbstractTalk(String talkName, int duration) throws TalkValidationException, IllegalArgumentException {
		this.setTalkName(talkName);
		this.setTalkDuration(duration);
	}
	
	public String getTalkName() {
		return talkName;
	}

	public void setTalkName(String talkName) throws WrongTalkNameException {
		if( this.isTalkNameValid( talkName ) ) {
			this.talkName = talkName;
		} else {
			throw new WrongTalkNameException();
		}
	}
	
	public int getTalkDuration() {
		return talkDuration;
	}

	public void setTalkDuration(int talkDuration) {
		this.talkDuration = talkDuration;
	}
	
	protected abstract boolean isTalkNameValid( String talkName );
}
