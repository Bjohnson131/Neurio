package neurIO;

/**
 * @author Brice Johnson
 * @version 0.01
 * @category Main
 **/
/**
 * Global
 * ===
 * Holds common values and functions that are used throughout the API
 **/
public class Global {
	public static String[] args;
	
	public static String rept(String toRepeat, int repeatTimes) {
		String toReturn = "";
		for(int i = 0; i < repeatTimes; i++) {
			toReturn += toRepeat;
		}
		return toReturn;
	}
}
