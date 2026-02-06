package com.ninjacrm.generic.fileutilities;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtilities {
	public String readAllDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/credential.properties");
		Properties ps = new Properties();
		ps.load(fis);
		String value = ps.getProperty(key);
		return value;
	}
}
