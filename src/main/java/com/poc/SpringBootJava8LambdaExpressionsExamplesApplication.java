package com.poc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poc.example1.ExampleI1;
import com.poc.example2.ExampleI2;
import com.poc.example3.ExampleI3;
import com.poc.example4.ExampleI4;
import com.poc.example5.ExampleI5;
import com.poc.example5.Test;
import com.poc.example6.InnerInterface1;
import com.poc.example6.InnerInterface2;

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
		InnerInterface1 innerInterface1 = (a, b) -> System.out.println(a *b);
		innerInterface1.m1(20, 30);
		
		InnerInterface2 innerInterface2 = (String str) -> System.out.println(str.toUpperCase());
		innerInterface2.m2("Darvin");
		
		
	}

}
