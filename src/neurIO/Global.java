package neurIO;

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
