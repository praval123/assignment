package com.utility.rentbooks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.functions.rentbooks.RentCalculationStoryOne;
import com.functions.rentbooks.RentCalculationStoryThree;
import com.functions.rentbooks.RentCalculationStoryTwo;
import com.globalbase.rentbooks.GlobalBase;

/**
 * Used to cal the rent.
 * @author Praval Agrawal
 *
 */
public class CommonUtility extends GlobalBase{

	/**
	 * Calculate the rent for all stories.
	 * @param name
	 */
	public int noOfBooks;
	public int noOfDays;
	public void calRent(final String name) 
	{
		final JFrame storyFrame=new JFrame(name);	
		storyFrame.setSize(400,500);  
		storyFrame.setLayout(null);  
		storyFrame.setVisible(true);
		final JList<String> booksList=new JList<>(books);
		storyFrame.add(booksList);
		booksList.setLayoutOrientation(JList.VERTICAL_WRAP);
		booksList.setVisibleRowCount(-1);
		booksList.setBounds(60, 30, 250, 100);
		booksList.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int[] no=booksList.getSelectedIndices();
				int noOfBooks=no.length;
				setNoOfBooks(noOfBooks);
				System.out.println(noOfBooks);
				selectedBooks=null;
				selectedBooks=(ArrayList<String>) booksList.getSelectedValuesList();
			}
		});
		JLabel label=new JLabel("Enter Days");
		storyFrame.add(label);
		label.setBounds(60, 150, 70, 40);
		final JTextField textField=new JTextField(20);
		storyFrame.add(textField);
		textField.setBounds(125, 160, 30, 20);
		textField.setEditable(true);
		JButton calRent=new JButton("Cal Rent");
		storyFrame.add(calRent);
		calRent.setBounds(130,250,100, 40);
		calRent.addActionListener(new ActionListener() {
			double rent;
			@Override
			public void actionPerformed(ActionEvent e) {

				if(noOfBooks==0)
				{
					JOptionPane.showMessageDialog(storyFrame, "Please select atleast one book.", "Error Window", JOptionPane.ERROR_MESSAGE);
				}
				else if(textField.getText().equals(null)||textField.getText().equals(""))
				{

					JOptionPane.showMessageDialog(storyFrame, "Please put the rented days.", "Error Window", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try
					{
						noOfDays=Integer.parseInt(textField.getText());
						if(noOfDays==0)
						{
							JOptionPane.showMessageDialog(storyFrame, "No of days can't be Zero, Please Check.", "Error Window", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							if(name.contains("One"))
							{
								rent=new RentCalculationStoryOne().calRent(noOfBooks,noOfDays);
							}
							else if(name.contains("Two"))
							{

								rent=new RentCalculationStoryTwo().calRent(noOfDays,selectedBooks);
							}
							else if(name.contains("Three"))
							{
								rent=new RentCalculationStoryThree().calRent(noOfDays,selectedBooks);
							}
							JOptionPane.showMessageDialog(storyFrame, "Total rent for "+noOfBooks+" books for "+noOfDays+" days is "+rent+"/rs.", "Calculated Rent", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					catch(NumberFormatException noFormatExp)
					{
						JOptionPane.showMessageDialog(storyFrame, "Please put the correct no of days.", "Error Window", JOptionPane.ERROR_MESSAGE);
					}
				}	
			}
		});
	}
	void setNoOfBooks(int a)
	{
		noOfBooks=a;
	}
}
