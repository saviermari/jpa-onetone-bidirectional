package com.smari.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Simple CRUD operations demo for OneToOne Bidirectional relationship. This does not cover unit teting and Exception Handling.
 * @author smari
 */
@SpringBootApplication
public class JpaOnetoneBidirectionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaOnetoneBidirectionalApplication.class, args);
	}

}
