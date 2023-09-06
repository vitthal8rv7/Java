package com.learn.java.exception.handling.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class ExceptionHandlingService {

	public void tryCatchDemo() {
		try {
			System.out.println("In Try Block.");
			System.out.println("Exception: "+(10/0));
		} catch(Exception e) {
			System.out.println("In Catch Block.");
			System.out.println("Exception Message: "+ e.getMessage());
			System.out.println("Exception Cause: "+ e.getCause());
		}
		
		
	}

	public void tryMultiLevelCatchDemo() {
		try {
			System.out.println("In Try Block.");
			System.out.println("Exception: "+(10/0));
		} catch(ArithmeticException e) {
			System.out.println("In Catch Block.");
			System.out.println("ArithmeticException Message: "+ e.getMessage());
			System.out.println("ArithmeticException Cause: "+ e.getCause());
		} catch(Exception e) {
			System.out.println("In Catch Block.");
			System.out.println("Common Exception Message: "+ e.getMessage());
			System.out.println("Common Exception Cause: "+ e.getCause());
		}		
	}

	public void tryMultipleCatchDemo() {
		try {
			System.out.println("In Try Block.");
			System.out.println("Exception: "+(10/0));
		} catch(ArithmeticException | NullPointerException e) {
			System.out.println("In Multiple Catch Block.");
			System.out.println("Exception Message: "+ e.getMessage());
			System.out.println("Exception Cause: "+ e.getCause());
		}		
	}

	public void tryCatchFinallyDemo() {
		FileInputStream fis = null;
		try {
			System.out.println("In Try Block.");
			fis = new FileInputStream("/no-file");
			System.out.println("Exception: "+(10/0));
		} catch(FileNotFoundException e) {
			System.out.println("In Catch Block.");
			System.out.println("Exception Message: "+ e.getMessage());
			System.out.println("Exception Cause: "+ e.getCause());
		} finally {
			System.out.println("In Finally Block.");
			try {
				if(null != fis)
					fis.close();
			} catch(Exception e) {
				System.out.println("In Catch Block.");
				System.out.println("Exception Message: "+ e.getMessage());
				System.out.println("Exception Cause: "+ e.getCause());
			}
		}	
	}

	public void tryFinallyDemo() {
		FileInputStream fis = null;
		try {
			System.out.println("In Try Block.");
		} finally {
			System.out.println("In Finally Block.");
			try {
				if(null != fis)
					fis.close();
			} catch(Exception e) {
				System.out.println("In Catch Block.");
				System.out.println("Exception Message: "+ e.getMessage());
				System.out.println("Exception Cause: "+ e.getCause());
			}
		}	
	}

	public void tryWithResourcesDemo() {
		
		try(FileInputStream fis = new FileInputStream("/no-file")) {
			System.out.println("In Try Block.");
			System.out.println("Exception: "+(10/0));
		} catch (FileNotFoundException e) {
			System.out.println("In File Not Found Catch Block.");
			System.out.println("Exception Message: "+ e.getMessage());
			System.out.println("Exception Cause: "+ e.getCause());
		} catch (IOException e) {
			System.out.println("In Catch Block.");
			System.out.println("Exception Message: "+ e.getMessage());
			System.out.println("Exception Cause: "+ e.getCause());
		}		
	}

	public void throwsDemo() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("/no-file");
	}

	public void throwDemo() {
		try {
			FileInputStream fis = new FileInputStream("/no-file");
		} catch (FileNotFoundException e) {
			throw new CustomFileNotFoundException("FileNotFoundException");
		}		
	}

}
