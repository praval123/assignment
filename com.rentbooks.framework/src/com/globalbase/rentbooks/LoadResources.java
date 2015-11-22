package com.globalbase.rentbooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

/**
 * Used to load resources.
 * @author Praval Agrawal
 *
 */
public class LoadResources extends GlobalBase{

	/**
	 * Used to load logger properties
	 */
	public void loadLoggerProperties(String logLevel,String loggerFileLocation)
	{
		Properties log4jProperties=new Properties();
		try 
		{
			log4jProperties.load(new FileInputStream(loggerFileLocation));
		} 
		catch (FileNotFoundException e) 
		{
			getLoggerInstance().error("Error : Property file not found at :- "+loggerFileLocation,e);
		} 
		catch (IOException e) 
		{
			getLoggerInstance().error("Error : ",e);
		}
		log4jProperties.setProperty("log4j.rootLogger", logLevel+",logFileAppender,sysOutToConsole");
		PropertyConfigurator.configure(log4jProperties);
	}
	/**
	 * Used to load normal properties.
	 */
	public void loadProperties(String propertiesFile)
	{
		try 
		{
			getProperties().load(new FileInputStream(propertiesFile));
		} 
		catch (IOException e) 
		{
			getLoggerInstance().error("Error while loading UI properties.",e);
		}
	}
}
