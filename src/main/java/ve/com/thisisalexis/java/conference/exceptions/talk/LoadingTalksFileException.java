package ve.com.thisisalexis.java.conference.exceptions.talk;

import java.io.IOException;

public class LoadingTalksFileException extends IOException {
	
	private static final long serialVersionUID = 7364250994795587065L;

	public LoadingTalksFileException(String message) {
		super(message);
	}
}
