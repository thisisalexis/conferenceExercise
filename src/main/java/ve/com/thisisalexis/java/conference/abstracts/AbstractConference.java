package ve.com.thisisalexis.java.conference.abstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;

/***
 * An abstract representation of a conference which represent a wrapper for
 * AbstractSessions (sessions) and AbstractThematics (Thematics).
 * @author abravo
 */
public abstract class AbstractConference<T extends AbstractTalk> {
	
	public static final Logger LOGGER = Logger.getLogger( AbstractConference.class.getName() );
	private List<AbstractThematic> thematics;

	public AbstractConference( List<AbstractSession> sessions, List<T> talks )
	 throws SessionException {
		talks = this.sortTalks( talks );
		this.setThematics( new ArrayList<AbstractThematic>() );
	}
	
	protected List<T> sortTalks( List<T> talks ) {
		AbstractTalk.<T>sortTalksByDurationDescending( talks );
		return talks;
	}
	
	public List<AbstractThematic> getThematics() {
		return thematics;
	}

	protected void setThematics( List<AbstractThematic> thematics ) {
		this.thematics = thematics;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	
	protected boolean addThematic( AbstractThematic thematic ) {
		try {
			return this.getThematics().add( thematic );
		} catch ( NullPointerException e ) {
			e.printStackTrace();
			LOGGER.log(Level.WARNING, "Thematic list was not defined in the conference instance", e);
		}
		return false;
	}
	
	protected abstract boolean prepareConference( List<T> talks );
	
}