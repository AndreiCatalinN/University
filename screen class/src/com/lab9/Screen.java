package com.lab9;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
public class Screen extends JFrame implements ActionListener {
	//Attributes
	private JTextField inFName, inSName, inCity;
	private JButton save, showAll, delete;
	private JTextArea shAll;
	ArrayList <Person> persons;

	//Constructor
	public Screen(String Title) {
		super(Title);
		setSize(350,350);
		setLayout ( new FlowLayout() );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		persons = new ArrayList<Person>();
		
		
		inFName = createTextField();
		inSName = createTextField();
		inCity = createTextField();
		
		save = createButton("Save");
		showAll = createButton("Show All");
		delete = createButton("Delete");
		
		shAll = new JTextArea("People added are: \n");
		add(shAll);
		shAll.setPreferredSize( new Dimension( 200,200) );
		
		setVisible(true);
	}
	
	//Functions to initialize components(button, text field)
	private JTextField createTextField() {
		JTextField b = new JTextField();
		b.setPreferredSize( new Dimension( 100, 20) );
		add(b);
		b.addActionListener(this);
		return b;
	}
	
	private JButton createButton(String bName){
		JButton b = new JButton(bName);
		add(b);
		b.addActionListener(this);
		return b;
	}
	
	//Action listener
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if (arg0.getSource() == save )
		{
			//Gets data from text fields
			String fName = inFName.getText();
			String sName = inSName.getText();
			String city = inCity.getText();
			Person p = new Person(fName, sName, city);	
			
			persons.add(p);
			JOptionPane.showMessageDialog(this, 
					"Saved person " + persons);
		}
		else if (arg0.getSource() == showAll )
		{
			shAll.setText("People added are: \n");
			//Prints the array
			for(int i = 0;i< persons.size();i++)
				shAll.append(persons.get(i).toString());	
		}
		else if (arg0.getSource() == delete )
			persons.clear();
	}
}