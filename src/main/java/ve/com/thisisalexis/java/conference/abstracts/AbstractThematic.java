package ve.com.thisisalexis.java.conference.abstracts;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractThematic {

	public static final Logger LOGGER = Logger.getLogger( AbstractThematic.class.getName() );
	private List<AbstractTalk> talks;
	private int availableTime;

	public AbstractThematic() {
		this.setTalks( new ArrayList<AbstractTalk>() );
	}
	
	public List<AbstractTalk> getTalks() {
		return talks;
	}

	private void setTalks(List<AbstractTalk> talks) {
		this.talks = talks;
	}
	
	public int getAvailableTime() {
		return availableTime;
	}

	protected void setAvailableTime( int availableTime ) {
		this.availableTime = availableTime;
	}
	
	public void addTalk( AbstractTalk talk ) {
		//TODO este es el codigo duro donde se irán haciendo cálculos
	}
	
}