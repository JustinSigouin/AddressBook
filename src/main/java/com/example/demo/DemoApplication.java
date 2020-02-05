package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(AddressBookRepository repository) {
//		return (args) -> {
//			// save a few book
//			AddressBook book = new AddressBook();
//			book.addBuddy(new BuddyInfo("ab", "bba"));
//			book.addBuddy(new BuddyInfo("abdsf", "bbasdfs"));
//			repository.save(book);
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (AddressBook customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			log.info("");
//		};
//	}

}
