package ve.com.thisisalexis.java.conference.exceptions;

import java.io.FileNotFoundException;

public class ConfigurationFileNotLoadedException extends FileNotFoundException {

	private static final long serialVersionUID = -379705218013222582L;

	public ConfigurationFileNotLoadedException(String message) {
		super( message );
	}
}
