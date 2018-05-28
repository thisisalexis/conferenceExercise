package ve.com.thisisalexis.java.conferences.models;

import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;

public class MorningSession extends Session {

	public MorningSession() {
		super();
		this.setSessionType( SessionTypeEnum.MORNING );
	}

}
