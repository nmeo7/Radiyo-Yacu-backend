package com.futureglories.RadiyoYacu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.futureglories.RadiyoYacu.model.Audio;
import com.futureglories.RadiyoYacu.repository.AudioRepository;
import com.futureglories.RadiyoYacu.service.StorageService;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RadiyoYacuApplication implements CommandLineRunner {

	@Autowired
	private AudioRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(RadiyoYacuApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
  
	  repository.deleteAll();
  
	  // save a couple of customers
	  repository.save(new Audio("Alice"));
	  repository.save(new Audio("Bob"));
  
	  // fetch all customers
	  System.out.println("Customers found with findAll():");
	  System.out.println("-------------------------------");
	  for (Audio customer : repository.findAll()) {
		System.out.println("**");
		System.out.println(customer);
	  }
	  System.out.println();
  
	  // fetch an individual customer
	  System.out.println("Customer found with findByFirstName('Alice'):");
	  System.out.println("--------------------------------");
	  // System.out.println(repository.findByFirstName("Alice"));
  
	  System.out.println("Customers found with findByLastName('Smith'):");
	  System.out.println("--------------------------------");
	  // for (Audio customer : repository.findByLastName("Smith")) {
		// System.out.println(customer);
	  // }
  
	}

}
