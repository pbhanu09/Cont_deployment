package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader
{
	static String filePath = System.getProperty("user.dir")+ "\\config.properties";
	
	public static String propertyFileReader(String Key) throws IOException
	{
		
		FileInputStream fileread = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(fileread);
		return prop.getProperty(Key);
		
	}
}
