package ve.com.thisisalexis.java.conferences;

import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.abstracts.AbstractSession;
import ve.com.thisisalexis.java.conferences.models.MorningSession;

public class App 
{
	
	public static final Logger LOGGER = Logger.getLogger( App.class.getName() );
	
    public static void main( String[] args )
    {
    	try {
    		
    		
    		AbstractSession session = new MorningSession();
    	
    		
    	} catch ( RuntimeException e ) {
    		LOGGER.warning( "An error happened in App.main() method" );
    	}
    }
}