package ve.com.thisisalexis.java.conference.abstracts;

import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractThematic {

	public static final Logger LOGGER = Logger.getLogger( AbstractThematic.class.getName() );
	public static final int MAX_NUMBER_OF_SESSIONS = 2;
	private List<AbstractSession> sessions;

	public AbstractThematic() {}

	public List<AbstractSession> getSessions() {
		return sessions;
	}

	public void setSessions(List<AbstractSession> sessions) {
		if( sessions.size() > AbstractThematic.MAX_NUMBER_OF_SESSIONS )
			return; // TODO lanzar exception personalizada desde aquí
		this.sessions = sessions;
	}
	
}