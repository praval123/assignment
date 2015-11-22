package com.functions.rentbooks;

import java.util.ArrayList;

import com.globalbase.rentbooks.GlobalBase;
import com.utility.rentbooks.CommonUtility;

/**
 * Calculate the rent of books as per the story two.
 * @author Praval Agrawal
 *
 */
public class RentCalculationStoryTwo extends CommonUtility {

	/**
	 * Use to calculate the rent.
	 */
	
	public double calRent(int noOfDays,ArrayList<String> selectedBooks) {
		double rent = 0;
		for(String bookName:selectedBooks)
		{
			String bookType=GlobalBase.booksDtails.get(bookName);
			switch (bookType) {
			case "Regular":
				rent=rent+noOfDays*1.5;
				break;
			case "Fiction":
				rent=rent+noOfDays*3;
				break;
			case "Novels":
				rent=rent+noOfDays*1.5;
				break;
			default:
				break;
			}
		}
		return rent;

	}
}
