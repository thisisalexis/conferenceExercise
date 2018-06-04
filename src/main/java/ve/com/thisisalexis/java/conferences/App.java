package ve.com.thisisalexis.java.conferences;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.abstracts.AbstractConference;
import ve.com.thisisalexis.java.conference.abstracts.AbstractSession;
import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.builders.ConferenceBuilder;
import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;
import ve.com.thisisalexis.java.conference.exceptions.ConfigurationFileNotLoadedException;
import ve.com.thisisalexis.java.conference.exceptions.session.SessionException;
import ve.com.thisisalexis.java.conference.exceptions.session.StartTimeGreaterThanEndTimeSessionException;
import ve.com.thisisalexis.java.conference.exceptions.talk.LoadingTalksFileException;
import ve.com.thisisalexis.java.conference.factories.SessionFactory;
import ve.com.thisisalexis.java.conference.settings.AppSetUp;
import ve.com.thisisalexis.java.conference.utils.TalkLoader;
import ve.com.thisisalexis.java.conferences.models.Talk;

public class App 
{
	
	public static final Logger LOGGER = Logger.getLogger( App.class.getName() );
	
    public static void main( String[] args )
    {
    	try {
    		AppSetUp appSetUp = AppSetUp.getInstance();
    		List<AbstractSession> sessions = new ArrayList<AbstractSession>();
    		
    		if ( appSetUp == null || !appSetUp.isSetUp() ) {
    			throw new ConfigurationFileNotLoadedException("The configuration File was not found.");
    		}
    		
    		AbstractSession morningSession = SessionFactory.getSession( 
    				SessionTypeEnum.MORNING, appSetUp.getSessionMorgingStartTime(), appSetUp.getSessionMorgingEndTime() );
    		
    		
    		AbstractSession afternoonSession = SessionFactory.getSession( 
    				SessionTypeEnum.AFTERNOON, appSetUp.getSessionAfternoonStartTime(), appSetUp.getSessionAfternoonEndTime() );
    		
    		
    		AbstractSession lunch = SessionFactory.getSession( 
    				SessionTypeEnum.LUNCH, appSetUp.getLunchStartTime(), appSetUp.getLuchEndTime() );
    		
    		
    		if ( morningSession == null || afternoonSession == null || lunch == null )
    			throw new SessionException("There was a problem and some of the sessions could not be"
    					+ "created properly.");
    		
    		sessions.add( morningSession );
    		sessions.add( afternoonSession );
    		sessions.add( lunch );
    		
    		try {
    			List<Talk> talks = TalkLoader.getTalksFromExternalSource( args[0] );
        		AbstractConference<Talk> conference = 
        				new ConferenceBuilder<Talk>().setSessions( sessions ).setTalks( talks ).build();
        		conference.toString();
    		} catch ( IOException e ) {
    			throw new LoadingTalksFileException(
    					"There was a problem and the file with the list of talks could not be loaded");
    		}
    		
    	} catch ( ConfigurationFileNotLoadedException e ) {
    		e.printStackTrace();
    		App.LOGGER.log( Level.WARNING, e.getMessage() );
    	} catch( StartTimeGreaterThanEndTimeSessionException e ) {
    		e.printStackTrace();
    		App.LOGGER.log( Level.WARNING, e.getMessage(), e );
    	} catch ( SessionException e ) {
    		e.printStackTrace();
    		App.LOGGER.log( Level.WARNING, e.getMessage(), e );
    	} catch ( LoadingTalksFileException  e ) {
    		e.printStackTrace();
    		App.LOGGER.log(Level.WARNING, e.getMessage() );
    	} catch ( IndexOutOfBoundsException e ) {
    		e.printStackTrace();
    		App.LOGGER.log(Level.WARNING, "Wrong number of params passed to run the application; you must provide the route "
    				+ "to the file with the lists of tasks" );
    	} catch ( NullPointerException e ) {
    		e.printStackTrace();
    		App.LOGGER.log( Level.WARNING, "There was a problem and some configuration objetc could not be"
    				+ "created properly and was set to null", e );
    	}
    }
}