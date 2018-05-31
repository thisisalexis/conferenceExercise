package ve.com.thisisalexis.java.conference.abstracts;

import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractConference {
	
	public static final Logger LOGGER = Logger.getLogger( AbstractConference.class.getName() );
	private List<AbstractThematic> thematics;
	
	public AbstractConference() {
		
	}

	public List<AbstractThematic> getThematics() {
		return thematics;
	}

	public void setThematics(List<AbstractThematic> thematics) {
		this.thematics = thematics;
	}
	
	public int getNeeedTimeForConference() {
		return 1; // TODO
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}