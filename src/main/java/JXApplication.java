package main.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"main.java.com.*"})
public class JXApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JXApplication.class, args);
	}
	
}




















