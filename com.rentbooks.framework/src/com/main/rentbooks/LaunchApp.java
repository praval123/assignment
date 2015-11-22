package com.main.rentbooks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.globalbase.rentbooks.GlobalBase;
import com.utility.rentbooks.CommonUtility;

/**
 * Used to launch the app.
 * @author Praval Agrawal
 * 
 *
 */
public class LaunchApp {
	static int noOfBooks;
	static int noOfDays;
	/**
	 * Launching the app.
	 */
	public static void main(String[] args) throws IOException {
		
		new GlobalBase().loadResources(".."+File.separator+"properties"+File.separator+"propfile.properties", ".."+File.separator+"properties"+File.separator+"log4j.properties");
		GlobalBase.getLoggerInstance().info("Starting the application.");
		final JFrame storiesFrame=new JFrame("Rent Books");
		String[] stories=new String[3];
		stories[0]="Story1";
		stories[1]="Story2";
		stories[2]="Story3";
		storiesFrame.setSize(300,150);
		storiesFrame.setLayout(null);  
		storiesFrame.setVisible(true);
		
		JLabel label=new JLabel("Pick Story");
		storiesFrame.add(label);
		label.setBounds(60, 30, 60, 40);
		final JComboBox<String> storiesComboBox=new JComboBox<>(stories);
		storiesFrame.add(storiesComboBox);
		storiesComboBox.setBounds(120,40,60, 20);
		storiesComboBox.setSelectedIndex(-1);
		
		storiesComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (storiesComboBox.getSelectedIndex() != -1) {                     

					int selectedStory=storiesComboBox.getSelectedIndex();  
					if(selectedStory==0)
					{
						new CommonUtility().calRent("StoryOne");
						
					}
											
					else if(selectedStory==1)
					{
						new CommonUtility().calRent("StoryTwo");
						
					}
					else if(selectedStory==2)
					{
						new CommonUtility().calRent("StoryThree");
						
					}
				} 
				

			}
		} );
		
		storiesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
