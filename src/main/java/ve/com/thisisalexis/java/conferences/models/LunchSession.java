package ve.com.thisisalexis.java.conferences.models;

import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;

public class LunchSession extends Session {
	
	public LunchSession() {
		super();
		this.setSessionType( SessionTypeEnum.LUNCH );
		this.setAcceptTalks( false );
	}
	
}
