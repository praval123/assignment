package com.functions.rentbooks;

/**
 * Calculation of rent as per the story one
 * @author Praval Agrawal
 *
 */
public class RentCalculationStoryOne{

	/**
	 * Use to calculate the rent.
	 */
	
	public double calRent(int noOfBooks,int noOfdays)
	{
		System.out.println(noOfBooks);
		System.out.println(noOfdays);
		double rent=noOfBooks*noOfdays*1;
		return rent;
	}


}
