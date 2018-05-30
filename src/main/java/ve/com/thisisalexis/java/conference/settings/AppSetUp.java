package ve.com.thisisalexis.java.conference.settings;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Properties;

/***
 * A class which implements the singleton pattern in order to make all
 * necessary setup to properl config the conference object and all of its 
 * @author abravo
 * @since 2018-05-27
 */
public class AppSetUp {
	
	private static AppSetUp instance = new AppSetUp();
	private static final String PATH_TO_CONFIG_FILE = "src/main/resources/set-up-app.properties";
	private static final String SESSION_MORNING_START_TIME_PROP_NAME = "sessionmorgingstarttime";
	private static final String SESSION_MORNING_END_TIME_PROP_NAME = "sessionmorgingendtime";
	private static final String SESSION_AFTERNOON_START_TIME_PROP_NAME = "sessionafternoonstarttime";
	private static final String SESSION_AFTERNOON_END_TIME_PROP_NAME = "sessionafternoonendtime";
	
	private Properties properties;
	private Properties defaultProperties;
	private LocalTime sessionMorgingStartTime;
	private LocalTime sessionMorgingEndTime;
	private LocalTime sessionAfternoonStartTime;
	private LocalTime sessionAfternoonEndTime;
	private boolean isSetUp;

	private AppSetUp() {
		this.setSetUp( false );
		this.setDefaultProperties( AppSetUp.createDefaultProperties() );
		this.setProperties( this.getDefaultProperties() );
		this.loadPropertiesFromFile();
	}
	
	private void loadPropertiesFromFile() {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader( AppSetUp.PATH_TO_CONFIG_FILE );
			this.getProperties().load( fileReader );
			this.setInstanceAttributes();
			this.setSetUp( true );
		} catch ( IOException e ) {
			e.printStackTrace();
			System.out.println( "There was a problem while trying to load the config.properties file" );
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static AppSetUp getInstance() {
		return AppSetUp.instance;
	}
	
	public void setInstanceAttributes() {
		this.setSessionMorgingStartTime( this.getLocalTimeForProperty(AppSetUp.SESSION_MORNING_START_TIME_PROP_NAME) );
		this.setSessionMorgingEndTime( this.getLocalTimeForProperty( AppSetUp.SESSION_MORNING_END_TIME_PROP_NAME ) );
		this.setSessionAfternoonStartTime( this.getLocalTimeForProperty( AppSetUp.SESSION_AFTERNOON_START_TIME_PROP_NAME ) );
		this.setSessionAfternoonEndTime( this.getLocalTimeForProperty( AppSetUp.SESSION_AFTERNOON_END_TIME_PROP_NAME ) );
	}
	
	public Properties getProperties() {
		return properties;
	}

	private void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public LocalTime getSessionMorgingStartTime() {
		return sessionMorgingStartTime;
	}

	private void setSessionMorgingStartTime(LocalTime sessionMorgingStartTime) {
		this.sessionMorgingStartTime = sessionMorgingStartTime;
	}

	public LocalTime getSessionMorgingEndTime() {
		return sessionMorgingEndTime;
	}

	private void setSessionMorgingEndTime(LocalTime sessionMorgingEndTime) {
		this.sessionMorgingEndTime = sessionMorgingEndTime;
	}

	public LocalTime getSessionAfternoonStartTime() {
		return sessionAfternoonStartTime;
	}

	private void setSessionAfternoonStartTime(LocalTime sessionAfternoonStartTime) {
		this.sessionAfternoonStartTime = sessionAfternoonStartTime;
	}

	public LocalTime getSessionAfternoonEndTime() {
		return sessionAfternoonEndTime;
	}

	private void setSessionAfternoonEndTime(LocalTime sessionAfternoonEndTime) {
		this.sessionAfternoonEndTime = sessionAfternoonEndTime;
	}
	
	public boolean isSetUp() {
		return isSetUp;
	}

	private void setSetUp(boolean isSetUp) {
		this.isSetUp = isSetUp;
	}
	
	public Properties getDefaultProperties() {
		return defaultProperties;
	}

	private void setDefaultProperties(Properties defaultProperties) {
		this.defaultProperties = defaultProperties;
	}
	
	private static Properties createDefaultProperties() {
		Properties defaultProerties = new Properties();
		defaultProerties.setProperty(AppSetUp.SESSION_MORNING_START_TIME_PROP_NAME, "09:00:00");
		defaultProerties.setProperty(AppSetUp.SESSION_MORNING_END_TIME_PROP_NAME, "12:00:00");
		defaultProerties.setProperty(AppSetUp.SESSION_AFTERNOON_START_TIME_PROP_NAME, "13:00:00");
		defaultProerties.setProperty(AppSetUp.SESSION_AFTERNOON_END_TIME_PROP_NAME, "16:00:00");
		return defaultProerties;
	}
	
	public LocalTime getLocalTimeForProperty(String propertyName) {
		LocalTime localTime = LocalTime.parse( this.properties.getProperty( propertyName ) );
		return localTime;
	}

}