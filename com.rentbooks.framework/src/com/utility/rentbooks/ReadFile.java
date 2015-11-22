package com.utility.rentbooks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.globalbase.rentbooks.GlobalBase;

/**
 * Used to read the resources file.
 * @author Praval Agrawal
 *
 */
public class ReadFile extends GlobalBase{
	

	/**
	 * Gives the books details.
	 * @return HasMap<String, String>
	 * @throws IOException
	 */
	public static HashMap<String, String> getBooksDetails() throws IOException
	{
		BufferedReader br = null;
		String bookFile=".."+File.separator+"Resources"+File.separator+"BooksDetails.txt";
		HashMap<String, String> booksDetails=new HashMap<String,String>();
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(bookFile));

			while ((sCurrentLine = br.readLine()) != null) {
				String[] books=sCurrentLine.split("\\|");
				booksDetails.put(books[0], books[1]);
			}

		}
		catch (FileNotFoundException e) {

			getLoggerInstance().error("File not found at location: "+bookFile);
			throw new FileNotFoundException("File not found at location: "+bookFile);
		}
		catch (IOException e) {

			getLoggerInstance().error("Failed to read the file: "+bookFile);
			throw new IOException("Failed to read the file: "+bookFile);
		}

		finally {

			if (br != null)br.close();

		}
		return booksDetails;
	}

	/**
	 * Used to get the book names.
	 * @return String[]
	 * @throws IOException
	 */
	public static String[] getBooks() throws IOException
	{

		HashMap<String, String> booksDetails=GlobalBase.getBooksDetails(); 

		Iterator<Entry<String, String>> entries = booksDetails.entrySet().iterator();
		String[] books=new String[booksDetails.entrySet().size()];
		int i=0;
		while (entries.hasNext()) {
			Entry<String, String> entry = entries.next();
			books[i]=entry.getKey();
			i++;
		}
		return books;
	}
		
}
