package com.unittests.rentbooks;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.functions.rentbooks.RentCalculationStoryOne;
/**
 * Unit testing class of story one.
 * @author Praval Agrawal
 *
 */
@RunWith(Parameterized.class)
public class StoryOne {
	
	int counter;
	int noOfDays;
	int noOfBooks;
	
	/**
	 * Used to set the parameters.
	 * @param noOfDays
	 * @param noOfBooks
	 * @param counter
	 */
	public StoryOne(int noOfDays, 
		      int noOfBooks,int counter) {
		      this.noOfDays = noOfDays;
		      this.noOfBooks = noOfBooks;
		      this.counter=counter;
		   }
	@Parameterized.Parameters
	   public static Collection<Object[]> primeNumbers() {
	      return Arrays.asList(new Object[][] {
	         { 2, 3,0 },
	         { 6, 4,1 },
	         { 19, 5,2 },
	         { 22, 7,3 },
	         { 23, 30,4 }
	      });
	   }
	double[] expArray={6.0,24.0,95.0,154.0,690.0};
	
	/**
	 * Unit testing test.
	 */
	@Test
	public void UnitTest()
	{
		boolean flag=false;
		double actRent=new RentCalculationStoryOne().calRent(noOfBooks,noOfDays);
		if(actRent==expArray[counter])
		{
			flag=true;
		}
		Assert.assertTrue(flag);
	}
	
	
}
