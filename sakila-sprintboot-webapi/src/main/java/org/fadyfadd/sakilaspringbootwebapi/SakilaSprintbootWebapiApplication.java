package org.fadyfadd.sakilaspringbootwebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.fadyfadd.sakilaspringbootwebapi")
public class SakilaSprintbootWebapiApplication {

	public static void main(String[] args) {	 
		SpringApplication.run(SakilaSprintbootWebapiApplication.class, args);
	}

}
