package com.example.springboot;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		PhoneNumberCheck phoneNumberCheck = new PhoneNumberCheck();
		int number = 8734;
		//numer = scanner.input

		String[] validwords = { "apple", "arm", "sun", "moon", "used", "truck", "tree", "treh", "train", "try", "true" };
		//validWords = scanner.input
		List<String> finalValidWords = phoneNumberCheck.getMatchingWords(Arrays.asList(validwords) , String.valueOf(number));
		System.out.println("Final Words:" + finalValidWords);

		finalValidWords = phoneNumberCheck.getMatchingWords(new LinkedList<>(Arrays.asList("tree", "tree")), "8733");
		System.out.println("Final Words:" + finalValidWords);
	}


}
