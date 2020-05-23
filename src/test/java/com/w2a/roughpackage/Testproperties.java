package com.w2a.roughpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Testproperties {
	
	public static void main(String[] args) throws IOException {
		
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		System.out.println(System.getProperty("user.dir"));
		System.out.println(config.getProperty("browser"));
	}

}
