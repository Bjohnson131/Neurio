package neurIO.engine;

public class UUID {
	
	private static long currentUUID = 0L;
	
	public static synchronized long getUUID() {
		return currentUUID++;
	}

}
