package ve.com.thisisalexis.java.conferences;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.exceptions.ConfigurationFileNotLoadedException;
import ve.com.thisisalexis.java.conference.exceptions.LoadingTalksFileException;
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
    		
    		
    		//Configurar plantilla de temática (a partir de plantillas sesiones creadas)
    		
    		
    		try {
    			List<AbstractTalk> talks = TalkLoader.getTalksFromExternalSource( args[0] );
    		} catch ( IOException e ) {
    			throw new LoadingTalksFileException("There was a problem and the file with the list of "
    					+ "talks could not be loaded");
    		}
    		
    		//Configurar conferencia
    		
    		//Inyectar talks a sessiones a partir de plantilla
    		
    		//Agregar sesiones a temáticas
    		
    		//Imprimir resultado
    		// Conferencia.Tostring
    		
    		
    		
    		
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