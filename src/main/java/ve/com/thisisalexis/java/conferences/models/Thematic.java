package ve.com.thisisalexis.java.conferences.models;

import java.util.List;

import ve.com.thisisalexis.java.conference.abstracts.AbstractSession;
import ve.com.thisisalexis.java.conference.abstracts.AbstractThematic;

public class Thematic extends AbstractThematic {
	public Thematic( List<AbstractSession>  sessions ) {
		super( sessions );
	}
}