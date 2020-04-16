package lab8.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileProcessing {
	
	//Attributes
	private Scanner readFile;
	private String fileName;
	BufferedWriter w;
	
	//Constructors
	FileProcessing(String fileName){
		setFileName(fileName);
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	//Others
	public String fileOpen(){
		
		String s= "";
		try {
			readFile = new Scanner(new File(fileName));
			while(readFile.hasNextLine()) {
				s += readFile.nextLine();
			}
		}
		catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		readFile.close();
		return s;
	}
	
	public boolean fileSearch(){
		
		
		try {
			readFile = new Scanner(new File(fileName));
		}
		catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		
		
		readFile.close();
		return true;
	}
	
	public void fileWrite(String data) {
		try {
			w = new BufferedWriter (new FileWriter(fileName, true));
			w.append(data);
			w.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
}