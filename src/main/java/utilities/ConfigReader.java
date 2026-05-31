package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

	public ConfigReader() {
		prop = new Properties();
	}

	public Properties initProperties() {
		try (FileInputStream fis = new FileInputStream("./src/test/resources/config.properties")) {
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Config file not found: " + e.getMessage());
		}
		return prop;
	}

	public static String getproperty(String key) {
		return prop.getProperty(key);
	}
}