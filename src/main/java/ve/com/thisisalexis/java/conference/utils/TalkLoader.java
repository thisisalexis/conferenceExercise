package ve.com.thisisalexis.java.conference.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.exceptions.LoadTalkException;
import ve.com.thisisalexis.java.conference.exceptions.TalkValidationException;
import ve.com.thisisalexis.java.conferences.models.Talk;

public class TalkLoader {
	
	public static final String SEPARATOR = ",";
	public static final Logger LOGGER = Logger.getLogger( TalkLoader.class.getName() );

	private TalkLoader()  {}

	public static List<AbstractTalk> getTalksFromExternalSource(String pathToFile) throws IOException  {
        String sourceFile = pathToFile;
        String line = "";
        List<AbstractTalk> talks = new ArrayList<AbstractTalk>();

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            while ((line = br.readLine()) != null) {
                String[] sessionStringDescriptor = line.split( TalkLoader.SEPARATOR );
                try {
                	TalkLoader.LOGGER.info("Loading talk: " + sessionStringDescriptor[0] + " which duration is " + sessionStringDescriptor[1] );
                	 AbstractTalk talk = new Talk( sessionStringDescriptor[0], Integer.parseInt( sessionStringDescriptor[1] ) );
                	 talks.add( talk );   	 
                } catch ( IndexOutOfBoundsException e ) {
                	e.printStackTrace();
                } catch ( NumberFormatException e ) {
                	e.printStackTrace();
                } catch( TalkValidationException e ) {
                	e.printStackTrace();
                }
            }
        }
        catch (LoadTalkException e) {
            e.printStackTrace();
            TalkLoader.LOGGER.log(Level.WARNING, "There where a problem while loading the file " + pathToFile , e);
            throw e;
        }
        return talks;
	}
}