package ve.com.thisisalexis.java.conferences;

import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.settings.AppSetUp;

public class App 
{
	
	public static final Logger LOGGER = Logger.getLogger( App.class.getName() );
	
    public static void main( String[] args )
    {
    	try {
    		//Creación de objeto de configuraci´pion
    		AppSetUp appSetUp = AppSetUp.getInstance();
    		
    		//Cargar listado de charlas
    		
    		
    		
    		//Creación de conferencia
    		
    		//Creación de tematicas
    		
    		//Creación de sessiones
    		
    		//Creación de charlas
    		// TODO algoritmo 
    		
    	} catch ( RuntimeException e ) {
    		LOGGER.warning( "An error happened in App.main() method" );
    	}
    }
}