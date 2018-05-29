package ve.com.thisisalexis.java.conferences;

import java.util.logging.Logger;

public class App 
{
	
	public static final Logger LOGGER = Logger.getLogger( App.class.getName() );
	
    public static void main( String[] args )
    {
    	try {
    	
    		
    	} catch ( RuntimeException e ) {
    		LOGGER.warning( "An error happened in App.main() method" );
    	}
    }
}