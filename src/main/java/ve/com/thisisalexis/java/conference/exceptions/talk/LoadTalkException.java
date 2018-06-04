package ve.com.thisisalexis.java.conference.exceptions.talk;

import java.io.IOException;

public class LoadTalkException extends IOException {

	private static final long serialVersionUID = 7358875552601435223L;

	public LoadTalkException() {
		super();
	}
	
	public LoadTalkException( String pathToFile ) {
		super( "There was a problem when loading the talks from the file; please check the file and try to run the program again " + pathToFile );
	}
	
}
