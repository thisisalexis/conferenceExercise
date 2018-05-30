package ve.com.thisisalexis.java.conferences;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.settings.AppSetUp;
import ve.com.thisisalexis.java.conference.utils.TalkLoader;

public class App 
{
	
	public static final Logger LOGGER = Logger.getLogger( App.class.getName() );
	
    public static void main( String[] args )
    {
    	try {
    		//Ejecutar archivo de configuración
    		AppSetUp appSetUp = AppSetUp.getInstance();
    		
    		//Abrir archivo 
    		try {
    			List<AbstractTalk> talks = TalkLoader.getTalksFromExternalSource(args[0]); 	
    		} catch ( IOException e) {
    			
    		}
    		
    	} catch ( IndexOutOfBoundsException e ) {
    		e.getStackTrace();
    		System.out.print( "Wrong number of params passed to run the application" );
    	} catch ( RuntimeException e ) {
    		e.printStackTrace();
    		System.out.println("there was a problem while trying to run the application; "
    				+ "please check the parameters, the entry file and the configuration files and try again.");
    		App.LOGGER.log( Level.WARNING, "An error happened in App.main() method" );
    	}
    }
}