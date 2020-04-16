package com.lab7.test;

import java.io.File;
public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String label;
		
		FileUse getText = new FileUse("test.txt");
		label = getText.fileRead();
		
		Screen s = new Screen("Lab7", label);
		getText.fileWrite(s.getLabelData());
		
	}
}
