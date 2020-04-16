package com.lab7.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class Screen extends JFrame implements ActionListener {
	
	//Button1 checks if the text in field1 starts with the letter in field1
	//Button2 checks if the text in field1 has the word written in field3
	private JButton button1 , button2;
	//Label is used to show the contents of a file
	private Label l1, l2, l3, label;
	//File input will be used to input data into a file.
	private JTextField field1,field2, field3, fileInput;
	private String text, letter, word, labelData ;
	
	
	
	Screen(String title, String labelD){
		super(title);
		setSize(250,300);
		setLayout ( new FlowLayout() );
		
		this.labelData = labelD;

		//Create and Add label				
		initializeLabel("Add text: ", l1);
		initializeLabel("Element to search in text: ", l2);
		initializeLabel("Word to search in text: ", l3);
		initializeLabel(labelData, label);
		
		//Text fields
		initializeTextField(field1);
		initializeTextField(field2);
		initializeTextField(field3);
		initializeTextField(fileInput);
		
		//Create, add, make button
		button1 = new JButton("Check letter");
		add(button1);
		button1.addActionListener(this);

		//Create, add, make button
		button2 = new JButton("Check word");
		add(button2);
		button2.addActionListener(this);
		
		setVisible(true); //Makes the frame visible
	}
	
	public String getLabelData() {
		return labelData;
	}
	
	public void initializeTextField(JTextField initField)
	{
		initField = new JTextField();
		initField.setPreferredSize( new Dimension( 100, 20) );
		add(initField);
		initField.addActionListener(this);
	}
	public void initializeLabel(String text, Label initLabel)
	{	
		initLabel = new Label(text);
		add(initLabel);
	}
	private void check()
	{
		if ( text.startsWith(letter) )
			showMessageDialog(this, "The text does start with the letter " + letter);
		else
			showMessageDialog(this, "The text does not start with the letter " + letter);		
	}
	
	private void checkIn()
	{
		word = word.trim();
		text = text.trim();
		letter = letter.trim();
		
		int l = text.length(),i;
		int count=0;
		
		for(i= 0 ; i<l ; i++)
			if(text.charAt(i) == ' ')
				count++;
		
		if(count == 0)
		{
			showMessageDialog(this," You don't have a sentence");
			return;
		}
		
		if (word.contains(" "))
			showMessageDialog(this," There is more than one word");
		else 
		{
			if ( text.contains(word) )
				showMessageDialog(this, word + " is in the text");
			else
				showMessageDialog(this, word + " is not in the text");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
		word = field3.getText();
		text = field1.getText();
		letter = field2.getText();
		labelData = fileInput.getText();
		
		
		if (arg0.getSource() == button1 )
		{
			check();
		}
		else if (arg0.getSource() == button2 )
		{
			checkIn();
		}
		else if (arg0.getSource() == field1)
		{
			text = field1.getText();
			field1.selectAll();
		}
		else if (arg0.getSource() == field2)
		{
			letter = field2.getText();
			field2.selectAll();
		}
		else if (arg0.getSource() == field3)
		{
			word = field3.getText();
			field3.selectAll();
		}
		else if (arg0.getSource() == fileInput)
		{
			labelData = fileInput.getText();
			fileInput.selectAll();
		}
		
	}
}