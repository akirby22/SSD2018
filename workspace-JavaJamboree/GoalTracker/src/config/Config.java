package config;

public class Config {
	
	private static int idCount = 0;
	
	public static int getIDCount() {
		int temp = idCount;
		idCount++;
		return temp;
	}

}
