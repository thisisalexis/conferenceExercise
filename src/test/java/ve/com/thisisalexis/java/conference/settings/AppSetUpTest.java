package ve.com.thisisalexis.java.conference.settings;

import org.junit.Assert;
import org.junit.Test;

public class AppSetUpTest {
	@Test
	public void createAppSetUpAndLoadProperties() {
		AppSetUp appSetUp = AppSetUp.getInstance();
		Assert.assertNotNull( "The AppSetUp object could not be created", appSetUp );
		Assert.assertTrue( "The AppSetUp instance was created but the properties file does not load properly", 
				appSetUp.isSetUp() );
		Assert.assertNotNull( "Properties field not set in the AppSetUp instance", appSetUp.getProperties() );
		Assert.assertNotNull( "Morning session start time not set", appSetUp.getSessionMorgingStartTime() );
		Assert.assertNotNull( "Morning session end time not set", appSetUp.getSessionMorgingEndTime() );
		Assert.assertNotNull( "Afternoon session start time not set", appSetUp.getSessionAfternoonStartTime() );
		Assert.assertNotNull( "Afternoon session end time not set", appSetUp.getSessionAfternoonEndTime() );
		Assert.assertTrue( "End time for morning session is before the start time", 
				appSetUp.getSessionMorgingStartTime().isBefore( appSetUp.getSessionMorgingEndTime() ) );
		Assert.assertTrue( "End time for afternoon session is before the start time", 
				appSetUp.getSessionAfternoonStartTime().isBefore( appSetUp.getSessionAfternoonEndTime() ) );
	}
}