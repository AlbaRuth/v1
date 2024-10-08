package com.lw1.exceptions;

import java.io.FileNotFoundException;

public class FileNotFoundExeption extends FileNotFoundException{
	
	public FileNotFoundExeption(String message){
		super(message);
	}
}
