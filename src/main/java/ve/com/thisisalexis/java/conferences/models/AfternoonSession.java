package ve.com.thisisalexis.java.conferences.models;

import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;

public class AfternoonSession extends Session {

	public AfternoonSession() {
		super();
		this.setSessionType( SessionTypeEnum.AFTERNOON );
	}

}