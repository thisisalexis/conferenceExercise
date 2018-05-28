package ve.com.thisisalexis.java.conference.settings;

/***
 * A class which implements the singleton pattern in order to make all
 * necessary setup to properl config the conference object and all of its 
 * @author abravo
 * @since 2018-05-27
 */
public class AppSetUp {
	
	private static AppSetUp instance = new AppSetUp();
	
	private AppSetUp() {}
	
	public static AppSetUp getInstance() {
		return AppSetUp.instance;
	}

}