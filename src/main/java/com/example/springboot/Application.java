package com.example.springboot;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		PhoneNumberCheck phoneNumberCheck = new PhoneNumberCheck();
		int number = 8733;
		//Can use the Scanner to take inputs from user
		//Scanner myObj = Integer.parseInt(myObj.nextLine());  Used Parse Int to take integer 
		//int number = myObj.nextLine();  // Read user input
		// number = scanner.input

		String[] validwords = { "apple", "arm", "sum", "moon", "used", "truck", "tree", "trend", "try", "true" };
		//Can use the Scanner to take inputs for valid words from  user
		//validWords = scanner.input
		List<String> finalValidWords = phoneNumberCheck.getMatchingWords(Arrays.asList(validwords) , String.valueOf(number));
		System.out.println("Final Words:" + finalValidWords);

		//finalValidWords = phoneNumberCheck.getMatchingWords(new LinkedList<>(Arrays.asList("tree", "tree")), "8733");
		//System.out.println("Final Words:" + finalValidWords);
	}


}
