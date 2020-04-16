package com.lab.test;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.Label;


public class Screen extends JFrame implements ActionListener, MouseListener
{
	private JButton b1, b2;
	private Label label1;
	private JTextField field;
	private String name;
	private JPanel Pan;
		
	//Constructor
	Screen(String Title)
	{
		super(Title);
		setSize(300, 300);
		setLayout (new FlowLayout() ); 
		
		//Create, add panel
		Pan = new JPanel();
		add(Pan);
		
		//Creates, add, make the buttons
		b1 = new JButton("Helloes");
		add(b1);
		b1.addActionListener(this);
		
		//Creates, add, make the buttons
		b2 = new JButton("Hello somebody");
		add(b2);
		b2.addActionListener(this); 
		
		//Create and Add label
		label1 = new Label("Enter your name: ");
		add( label1 );
		
		//Text field
		field = new JTextField();
		field.setPreferredSize( new Dimension( 100, 100) );
		add(field);
		field.addActionListener(this);
		
		setVisible(true); //Makes the frame visible
	}
   
	@Override
   	public void actionPerformed(ActionEvent event)
   	{	
      	if( event.getSource() == b1)
      	{
      		Random ran = new Random();
      		int r = ran.nextInt( 5 ) +1;
      		
      		switch (r) 
      		{
      		case 1:
      			JOptionPane.showMessageDialog(this, "Guten Tag");
      			break;
      		case 2:
      			JOptionPane.showMessageDialog(this, "Buenos Dias");
      			break;
      		case 3:
      			JOptionPane.showMessageDialog(this, "Oi");
      			break;
      		case 4:
      			JOptionPane.showMessageDialog(this, "Hello!");
      			break;
      		case 5:
      			JOptionPane.showMessageDialog(this, "Salut!");
      			break;
      		}
   		}
      	else if( event.getSource() == b2)
      	{
      		JOptionPane.showMessageDialog(this, "Hello "+ name);
      	}
      	else if(event.getSource() == field)
      	{
      		name = field.getText();
      		field.selectAll();
      	}
      	else if( event.getSource() == label1)
      	{
      		
      	}
 	
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}