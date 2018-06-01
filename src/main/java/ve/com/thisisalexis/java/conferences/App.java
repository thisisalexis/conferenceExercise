package ve.com.thisisalexis.java.conferences;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.abstracts.AbstractConference;
import ve.com.thisisalexis.java.conference.abstracts.AbstractSession;
import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.enums.SessionTypeEnum;
import ve.com.thisisalexis.java.conference.exceptions.ConfigurationFileNotLoadedException;
import ve.com.thisisalexis.java.conference.exceptions.LoadingTalksFileException;
import ve.com.thisisalexis.java.conference.factories.SessionFactory;
import ve.com.thisisalexis.java.conference.settings.AppSetUp;
import ve.com.thisisalexis.java.conference.utils.TalkLoader;

public class App 
{
	
	public static final Logger LOGGER = Logger.getLogger( App.class.getName() );
	
    public static void main( String[] args )
    {
    	try {
    		AppSetUp appSetUp = AppSetUp.getInstance();
    		
    		if ( appSetUp == null || !appSetUp.isSetUp() ) {
    			throw new ConfigurationFileNotLoadedException("The configuration File was not found.");
    		}
    		
    		//Configurar plantilla de sesiones (Mañana y tarde)
    		AbstractSession morningSession = SessionFactory.getSession( 
    				SessionTypeEnum.MORNING, appSetUp.getSessionMorgingStartTime(), appSetUp.getSessionMorgingEndTime() );
    		AbstractSession afternoonSession = SessionFactory.getSession( 
    				SessionTypeEnum.AFTERNOON, appSetUp.getSessionAfternoonStartTime(), appSetUp.getSessionAfternoonEndTime() );
    		
    		AbstractSession lunch = SessionFactory.getSession( 
    				SessionTypeEnum.LUNCH, appSetUp.getLunchStartTime(), appSetUp.getLuchEndTime() );
    		
    		//Configurar conferencia
    		AbstractConference conference = null;
    		
    		try {
    			List<AbstractTalk> talks = TalkLoader.getTalksFromExternalSource( args[0] );
    		} catch ( IOException e ) {
    			throw new LoadingTalksFileException("There was a problem and the file with the list of "
    					+ "talks could not be loaded");
    		}
    		
    		//Agregar talks a la conferencia
    		
    		
    		//Imprimir resultado
    		// conference.Tostring
    		
    		
    		
    		
    	} catch ( ConfigurationFileNotLoadedException e ) {
    		e.printStackTrace();
    		App.LOGGER.log( Level.WARNING, e.getMessage() );
    	} catch ( LoadingTalksFileException  e ) {
    		e.printStackTrace();
    		App.LOGGER.log(Level.WARNING, e.getMessage() );
    	} catch ( IndexOutOfBoundsException e ) {
    		e.printStackTrace();
    		App.LOGGER.log(Level.WARNING, "Wrong number of params passed to run the application; you must provide the route "
    				+ "to the file with the lists of tasks" );
    	} catch ( RuntimeException e ) {
    		e.printStackTrace();
    		App.LOGGER.log( Level.WARNING, "There was a problem while trying to run the application; "
    				+ "please check the parameters, the entry file and the configuration files and try again." );
    	}
    }
}