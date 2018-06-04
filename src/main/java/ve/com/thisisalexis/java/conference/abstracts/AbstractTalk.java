package ve.com.thisisalexis.java.conference.abstracts;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import ve.com.thisisalexis.java.conference.comparators.SortTalkByDurationDescComparator;
import ve.com.thisisalexis.java.conference.exceptions.talk.TalkValidationException;
import ve.com.thisisalexis.java.conference.exceptions.talk.WrongTalkNameException;

public abstract class AbstractTalk {
	
	public static final Logger LOGGER = Logger.getLogger( AbstractConference.class.getName() );
	
	private String talkName;
	private int talkDuration;
	
	public AbstractTalk( String talkName, int duration ) 
			throws TalkValidationException, IllegalArgumentException {
		this.setTalkName(talkName);
		this.setTalkDuration(duration);
	}
	
	public String getTalkName() {
		return talkName;
	}

	protected void setTalkName( String talkName ) throws WrongTalkNameException {
		if( this.isTalkNameValid( talkName ) ) {
			this.talkName = talkName;
		} else {
			throw new WrongTalkNameException();
		}
	}
	
	public int getTalkDuration() {
		return talkDuration;
	}

	protected void setTalkDuration(int talkDuration) {
		this.talkDuration = talkDuration;
	}
	
	/***
	 * IT orders the talks in a List instance in ascending order by duration
	 * @param talks
	 * @return the same object but sorted
	 */
	public static <T extends AbstractTalk> List<T> sortTalksByDurationDescending( List<T> talks ) {
		Collections.sort( talks,  new SortTalkByDurationDescComparator() );
		return talks;
	}
	
	protected abstract boolean isTalkNameValid( String talkName );
	
}
