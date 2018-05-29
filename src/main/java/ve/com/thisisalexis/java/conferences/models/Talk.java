package ve.com.thisisalexis.java.conferences.models;

import java.util.List;

import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.exceptions.LoadTalkException;
import ve.com.thisisalexis.java.conference.exceptions.TalkValidationException;
import ve.com.thisisalexis.java.conference.utils.StringUtil;
import ve.com.thisisalexis.java.conference.utils.TalkLoader;

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
	
	public static List<AbstractTalk> getTalksFromExternalSource( String pathToFile ) throws LoadTalkException {
		try {
			List<AbstractTalk> talks = TalkLoader.getTalksFromExternalSource(pathToFile);
			return talks;
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoadTalkException();
		}
	}

}