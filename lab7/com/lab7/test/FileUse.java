package com.lab7.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.*;

public class FileUse {
	
	private File f;
	private String name, data;
	private Scanner txtRead;
	
	FileUse(String name) {
		this.name = name;
	}
	
	//open file
	private void fileOpen() {
		f = new File(name);
		try {
			txtRead = new Scanner(f);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
	    }
	}
	
	private void fileClose() {
		txtRead.close();
	}
	
	//read from ile
	public String fileRead(){
		fileOpen();
		data = txtRead.nextLine();
		fileClose();
		return data;
	}
	
	//write to file
	public void fileWrite(String data) {
		fileOpen();
		try {
			BufferedWriter w = new BufferedWriter (new FileWriter(name, true));
			w.append(data);
			w.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		fileClose();
	}
}
