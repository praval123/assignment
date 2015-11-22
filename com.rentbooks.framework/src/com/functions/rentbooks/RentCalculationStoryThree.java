package com.functions.rentbooks;

import java.util.ArrayList;

import com.globalbase.rentbooks.GlobalBase;
import com.utility.rentbooks.CommonUtility;

/**
 * Calculate the rent of books as per story three.
 * @author Praval Agrawal
 *
 */
public class RentCalculationStoryThree extends CommonUtility{

	
	public double calRent(int noOfDays,ArrayList<String> selectedBooks) {
		
		double rent = 0;
		
		for(String bookName:selectedBooks)
		{
			System.out.println(selectedBooks);
			String bookType=GlobalBase.booksDtails.get(bookName);
			switch (bookType) {
			case "Regular":
				if(noOfDays<2)
				{
					rent=rent+2;
				}
				else
				{
					rent=rent+((noOfDays-2)*1.5)+2;	
				}
				break;
			case "Fiction":
				rent=rent+noOfDays*3;
				break;
			case "Novels":
				if(noOfDays<3)
				{
					rent=rent+4.5;
				}
				else
				{
					rent=rent+noOfDays*1.5;
				}
				break;
			default:
				break;
			}
		}
		return rent;
	}

}
