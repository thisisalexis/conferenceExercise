package ve.com.thisisalexis.java.conferences.models;

import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.exceptions.TalkValidationException;
import ve.com.thisisalexis.java.conference.utils.StringUtil;

public class Talk extends AbstractTalk {
	
	public Talk(String talkName, int duration) throws TalkValidationException {
		super(talkName, duration);
	}
	
	protected boolean isTalkNameValid( String talkName ) {
		return !this.doesTalkNameHasNumericValues(talkName)
				&& !this.isTalkNameEmpty(talkName) ;
	}
	
	private boolean isTalkNameEmpty( String talkName ) {
		return talkName.isEmpty();
	}
	
	private boolean doesTalkNameHasNumericValues( String talkName ) {
		return StringUtil.doesStringHasNumericValues( talkName );
	}
	
}