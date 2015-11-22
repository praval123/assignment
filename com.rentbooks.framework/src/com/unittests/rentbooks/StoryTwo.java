package com.unittests.rentbooks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.functions.rentbooks.RentCalculationStoryTwo;
import com.globalbase.rentbooks.GlobalBase;

/**
 * Unit test for story two
 * @author Praval Agrawal
 *
 */
@RunWith(Parameterized.class)
public class StoryTwo {
	
	int counter;
	int noOfDays;
	ArrayList<String> selectedBooks;
	/**
	 * Used to set the parameters.
	 * @param noOfDays
	 * @param counter
	 * @param selectedBooks
	 * @throws IOException
	 */
	public StoryTwo(int noOfDays, 
		      int counter,ArrayList<String> selectedBooks) throws IOException {
		      this.noOfDays = noOfDays;
		      
		      this.counter=counter;
		      GlobalBase.booksDtails=GlobalBase.getBooksDetails();
		      this.selectedBooks=selectedBooks;
		   }
	
	@Parameterized.Parameters
	   public static Collection<Object[]> primeNumbers() {
	      return Arrays.asList(new Object[][] {
	         { 30,0,new ArrayList<>(Arrays.asList("All The Day Idle", "As 'twere to-night", "Ad Amicos")) },
	         {  40,1,new ArrayList<>(Arrays.asList("The Penguin Book of Hindu Names", "According to the Mighty Working")) },
	         {  50,2,new ArrayList<>(Arrays.asList("A Bruised Reed Shall He Not Break", "A Death in the Desert", "A Poor Stick")) },
	         
	      });
	   }
	double[] expArray={180.0,180.0,300.0};
	/**
	 * Unit testing test.
	 */
	@Test
	public void test1()
	{
		boolean flag=false;
		double actRent=new RentCalculationStoryTwo().calRent(noOfDays,selectedBooks);
		if(actRent==expArray[counter])
		{
			flag=true;
		}
		Assert.assertTrue(flag);
	}
	
	
}
