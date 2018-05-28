package ve.com.thisisalexis.java.conference.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ve.com.thisisalexis.java.conference.abstracts.AbstractTalk;
import ve.com.thisisalexis.java.conference.exceptions.TalkValidationException;
import ve.com.thisisalexis.java.conferences.models.Talk;

public class TalkLoader {
	
	public static final String SEPARATOR = ",";
	private List<AbstractTalk> talks = new ArrayList<AbstractTalk>();

	public TalkLoader( String pathToFile ) {
		this.talks = TalkLoader.getTalksFromExternalSource(pathToFile);
	}
	
	public List<AbstractTalk> getTalks() {
		return talks;
	}

	public void setTalks(List<AbstractTalk> talks) {
		this.talks = talks;
	}
	
	public static List<AbstractTalk> getTalksFromExternalSource( String pathToFile ) {
        String sourceFile = pathToFile; // "/Users/mkyong/csv/country.csv";
        String line = "";
        List<AbstractTalk> talks = new ArrayList<AbstractTalk>();

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            while ((line = br.readLine()) != null) {
                String[] sessionStringDescriptor = line.split( TalkLoader.SEPARATOR );
                try {
                	 System.out.println("Session [description= " + sessionStringDescriptor[0] + " , duration=" + sessionStringDescriptor[1] + "]");
                	 AbstractTalk talk = new Talk( sessionStringDescriptor[0], Integer.parseInt( sessionStringDescriptor[1] ) );
                	 talks.add( talk );   	 
                } catch ( IndexOutOfBoundsException e ) {
                	e.printStackTrace();
                } catch ( NumberFormatException e ) {
                	e.printStackTrace();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (TalkValidationException e) {
        	e.printStackTrace();
        } catch ( IllegalArgumentException e ) {
        	e.printStackTrace();
        }
        return talks;
	}

}
