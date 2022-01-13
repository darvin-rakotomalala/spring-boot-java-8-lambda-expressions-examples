package com.poc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poc.example1.ExampleI1;
import com.poc.example10.Book;
import com.poc.example11.LambdaExample11;
import com.poc.example2.ExampleI2;
import com.poc.example3.ExampleI3;
import com.poc.example4.ExampleI4;
import com.poc.example5.ExampleI5;
import com.poc.example5.Test;
import com.poc.example6.InnerInterface1;
import com.poc.example6.InnerInterface2;
import com.poc.example7.NormalExample;
import com.poc.example8.Employee;
import com.poc.example8.Interface8;

@SpringBootApplication
public class SpringBootJava8LambdaExpressionsExamplesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJava8LambdaExpressionsExamplesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("================================================================");
		System.out.println("1- Example hello world");
		ExampleI1 i1 = () -> System.out.println("hello world!");
		i1.m();

		System.out.println("================================================================");
		System.out.println("2- Example carré du nombre");
		ExampleI2 i2 = (i) -> i * i;
		System.out.println(i2.squareOfNumber(10));

		System.out.println("================================================================");
		System.out.println("3- Example somme de deux nombres");
		ExampleI3 i3 = (n1, n2) -> System.out.println("Sum of n1 and n2 is = " + (n1 + n2));
		i3.summOfTwoNumber(20, 30);

		System.out.println("================================================================");
		System.out.println("4- Example instruction return");
		ExampleI4 i4 = (i) -> {
			return i * i;
		};
		System.out.println(i4.m1(10));

		System.out.println("================================================================");
		System.out.println("5- Example implémentation et une interface fonctionnelle");
		ExampleI5 i5 = new Test();
		i5.m1();

		ExampleI5 i5a = () -> System.out.println("hello world");
		i5a.m1();

		System.out.println("================================================================");
		System.out.println("6- Example définition de l'interface fonctionnelle en tant que classe interne");
		InnerInterface1 innerInterface1 = (a, b) -> System.out.println(a * b);
		innerInterface1.m1(20, 30);

		InnerInterface2 innerInterface2 = (String str) -> System.out.println(str.toUpperCase());
		innerInterface2.m2("Darvin");

		System.out.println("================================================================");
		System.out.println("7- Example en utilisant l'interface Runnable");
		NormalExample example = new NormalExample();
		Thread thread1 = new Thread(example);
		thread1.start();

		// même opération en utilisant lambda
		Runnable runnable = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("with lambda expression " + i);
			}
		};
		Thread threadLambda = new Thread(runnable);
		threadLambda.start();

		System.out.println("================================================================");
		System.out.println("8- Example opération avec lambda");
		Employee employee = new Employee();
		Interface8 interface8 = (name1) -> name1.equals(employee.getEmpName());
		System.out.println(interface8.returnName("ram"));

		System.out.println("================================================================");
		System.out.println("9- Example lambda avec ArrayList");
		List<String> arrayListObj = new ArrayList<String>();
		arrayListObj.add("ram");
		arrayListObj.add("mohan");
		arrayListObj.add("sohan");

		// Using enhanced for loop
		for (String strObj : arrayListObj) {
			System.out.println("Using enhanced for loop " + strObj);
		}

		// Using java 8 lambda
		arrayListObj.forEach((str) -> System.out.println("Using lambda expression " + str));

		System.out.println("================================================================");
		System.out.println("10- Example lambda expression comprator");
		// creating a list type of book
		List<Book> listOfBook = new ArrayList<Book>();
		// creating Book using argumented constructor
		Book b1 = new Book(2, "five point someone");
		Book b2 = new Book(4, "godan");
		Book b3 = new Book(6, "devdash");
		Book b4 = new Book(1, "lolita");

		// adding book into list
		listOfBook.add(b1);
		listOfBook.add(b2);
		listOfBook.add(b3);
		listOfBook.add(b4);

		// sorting book object on basis of name
		System.out.println("Sorting book object on basis of name");
		Collections.sort(listOfBook, (book1, book2) -> {
			return book1.bookName.compareTo(book2.bookName);
		});

		// iterating using for-each loop
		for (Book book : listOfBook) {
			System.out.println("bookId is  " + book.bookId + " " + "bookName is  " + book.bookName);
		}

		// sorting book object on basis of id
		System.out.println("sorting book object on basis of id");
		Collections.sort(listOfBook, (book1, book2) -> {
			return book1.bookId - book2.bookId;
		});

		// iterating using for-each loop
		for (Book book : listOfBook) {
			System.out.println("bookId is  " + book.bookId + " " + "bookName is  " + book.bookName);
		}

		System.out.println("================================================================");
		System.out.println("11- Example lambda expression iteration avec Thread");
		Thread thread = new Thread(() -> LambdaExample11.m1());
		thread.start();

		System.out.println("================================================================");
		System.out.println("12- Example lambda expression avec HashMap");
		Map<Integer, String> hashMapObj = new HashMap<>();
		hashMapObj.put(2, "ram");
		hashMapObj.put(5, "mohan");
		hashMapObj.put(3, "sohan");
		hashMapObj.put(9, "rohit");

		hashMapObj.forEach((key, value) -> {
			System.out.println("Key is : " + key + "   Value is : " + value);
		});
	}

}
