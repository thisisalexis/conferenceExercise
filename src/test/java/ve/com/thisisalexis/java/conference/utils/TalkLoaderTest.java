package ve.com.thisisalexis.java.conference.utils;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ve.com.thisisalexis.java.conferences.models.Talk;


public class TalkLoaderTest {
	
	private String pathToFile = "src/test/resources/TalkLoaderTest.csv";
	
	@Test
	public void createTalkObjects() throws IOException {
		int expectedTalksInFile = 19;
		String pathToFile =  this.pathToFile;
		List<Talk> talks = TalkLoader.getTalksFromExternalSource(pathToFile);
		Assert.assertTrue( "Talks' list has not been loaded. " + talks.size() + " out of " 
		+ expectedTalksInFile + " were loaded", talks.size() == expectedTalksInFile );
	}
	
	@Test( expected = IOException.class )
	public void loadWrongFileTest() throws IOException {
		String pathToFile =  "this/is/a/wrong/path/to/file.txt";
		TalkLoader.getTalksFromExternalSource(pathToFile);
	}
	
}