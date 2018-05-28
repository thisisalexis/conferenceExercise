package ve.com.thisisalexis.java.conference.utils;

public class StringUtil {
	
	public static boolean doesStringHasNumericValues(String value) {
		return value.matches(".*\\d+.*");
	}
	
}
