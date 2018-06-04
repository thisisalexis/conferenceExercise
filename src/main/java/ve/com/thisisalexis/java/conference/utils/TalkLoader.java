package ve.com.thisisalexis.java.conference.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.exceptions.talk.LoadTalkException;
import ve.com.thisisalexis.java.conference.exceptions.talk.TalkValidationException;
import ve.com.thisisalexis.java.conferences.models.Talk;

public class TalkLoader {
	
	public static final String SEPARATOR = ",";
	public static final Logger LOGGER = Logger.getLogger( TalkLoader.class.getName() );

	private TalkLoader()  {}

	public static List<Talk> getTalksFromExternalSource(String pathToFile) throws IOException  {
        String sourceFile = pathToFile;
        String line = "";
        List<Talk> talks = new ArrayList<Talk>();
        Reader reader = new FileReader( sourceFile );
        BufferedReader br = null;
        
        try {
        	br = new BufferedReader( reader );
            while ((line = br.readLine()) != null) {
                String[] sessionStringDescriptor = line.split( TalkLoader.SEPARATOR );
                try {
                	Talk talk = new Talk( sessionStringDescriptor[0], Integer.parseInt( sessionStringDescriptor[1] ) );
                	 talks.add( talk );   	 
                } catch ( IndexOutOfBoundsException e ) {
                	e.printStackTrace();
                	TalkLoader.LOGGER.warning( "Loading talk record: Missing data." );
                } catch ( NumberFormatException e ) {
                	e.printStackTrace();
                	TalkLoader.LOGGER.warning( "Loading talk record: Invalid format for data." );
                } catch( TalkValidationException e ) {
                	e.printStackTrace();
                	TalkLoader.LOGGER.warning( "Loading talk record: Talk validation failed." );
                }
            }
        } catch (LoadTalkException e) {
        	e.printStackTrace();
            TalkLoader.LOGGER.log(Level.WARNING, "There where a problem while loading the file " + pathToFile , e);
            throw e;
        } finally {
			if ( br != null )
				br.close();
		}
        return talks;
	}
}