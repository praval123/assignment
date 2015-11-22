package com.globalbase.rentbooks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.utility.rentbooks.ReadFile;


/**
 * Used for the initialization and loading of resources.
 * @author Praval Agrawal
 *
 */
public class GlobalBase {
	private static Properties properties;
	private static Logger logger;
	public static HashMap<String, String> booksDtails;
	public static String[] books;
	public ArrayList<String> selectedBooks;
	
	/**
	 *	Used to set logger instance. 
	 */
	private static  void setLoggerInstance()
	{
		logger=LoggerFactory.getLogger("ClassName");

	}
	/**
	 * Used to get logger instance
	 * @return Logger.
	 */
	public static  Logger getLoggerInstance()
	{
		return logger;
	}
	/**
	 * Used to set books details instance.
	 */
	private static  void setBooksDetailsInstance()
	{
		booksDtails=new HashMap<>();
	}
	/**
	 * Used to set properties instance, logger instance, booksdetails instance and all books instance.
	 */
	private  void setGlobalInitVariables() throws IOException
	{
		setPropertiesInstance();
		setLoggerInstance();
		setBooksDetailsInstance();
		setAllBooksInstance();

	}
	/**
	 * Used to load resources and setting of initialization variables..
	 */
	public void loadResources(String propertiesFile,String loggerPropertiesFile) throws IOException
	{
		LoadResources loadResourceObj=new LoadResources();
		setGlobalInitVariables();
		loadResourceObj.loadProperties(propertiesFile);
		loadResourceObj.loadLoggerProperties(getProperties("logLevel"),loggerPropertiesFile);
	}
	/**
	 * Used to get the value of the property.
	 * @return String.
	 */
	public static  String getProperties(String propertyKey)
	{
		return properties.getProperty(propertyKey);
	}

	/**
	 * Used to set the properties instance.
	 * @return Properties.
	 */
	public static  Properties getProperties()
	{
		return properties;
	}
	/**
	 * Used to get the books details.
	 * @return HashMap
	 * @throws IOException
	 */
	public static  HashMap<String, String> getBooksDetails() throws IOException
	{
		booksDtails=ReadFile.getBooksDetails();
		return booksDtails;
	}
	/**
	 * Used  to set the .property file instance.
	 */
	private static  void setPropertiesInstance()
	{
		properties=new Properties();
	}
	/**
	 * Used to set all the books available.
	 */
	private static void setAllBooksInstance() throws IOException
	{

		books=ReadFile.getBooks();
	}

	

}
