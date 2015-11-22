package com.unittests.rentbooks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.functions.rentbooks.RentCalculationStoryThree;
import com.globalbase.rentbooks.GlobalBase;
/**
 * Unit testing class of story three.
 * @author Praval Agrawal
 *
 */

@RunWith(Parameterized.class)

public class StoryThree {
	
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
	public StoryThree(int noOfDays, 
		      int counter,ArrayList<String> selectedBooks) throws IOException {
		
		      this.noOfDays = noOfDays;
		      this.counter=counter;
		      GlobalBase.booksDtails=GlobalBase.getBooksDetails();
		      this.selectedBooks=selectedBooks;
		   }
	@Parameterized.Parameters
	   public static Collection<Object[]> primeNumbers() {
	      return Arrays.asList(new Object[][] {
	         { 1,0,new ArrayList<>(Arrays.asList("One Hundred Names")) },
	         { 15,1,new ArrayList<>(Arrays.asList("101 Inspiring Stories")) },
	         { 15,2,new ArrayList<>(Arrays.asList("101 Inspiring Stories","According To Gunter")) },
	         {  2,3,new ArrayList<>(Arrays.asList("America For Me")) },
	         {  10,4,new ArrayList<>(Arrays.asList("And He Said, Fight On")) },
	         {  50,5,new ArrayList<>(Arrays.asList("101 Inspiring Stories", "A man was drawing near to me", "As 'twere to-night")) },
	         
	      });
	   }
	double[] expArray={2.0,21.5,66.5,4.5,15.0,299.0};
	/**
	 * Unit testing test.
	 */
	@Test
	public void test1()
	{
		boolean flag=false;
		double actRent=new RentCalculationStoryThree().calRent(noOfDays,selectedBooks);
		if(actRent==expArray[counter])
		{
			flag=true;
		}
		Assert.assertTrue(flag);
	}
	
	
}
