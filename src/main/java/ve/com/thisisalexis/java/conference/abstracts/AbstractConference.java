package ve.com.thisisalexis.java.conference.abstracts;

import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractConference {
	
	public static final Logger LOGGER = Logger.getLogger( AbstractConference.class.getName() );
	public static final int MAX_NUMBER_OF_THEMATIC = 20;
	private List<AbstractThematic> thematics;
	
	public AbstractConference() {
		
	}

	public List<AbstractThematic> getThematics() {
		return thematics;
	}

	public void setThematics(List<AbstractThematic> thematics) {
		this.thematics = thematics;
	}
	
}