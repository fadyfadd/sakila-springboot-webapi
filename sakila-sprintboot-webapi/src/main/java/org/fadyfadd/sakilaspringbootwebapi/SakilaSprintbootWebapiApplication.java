package org.fadyfadd.sakilaspringbootwebapi;

import org.slf4j.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("org.fadyfadd.sakilaspringbootwebapi")													 	
public class SakilaSprintbootWebapiApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory
		      .getLogger(SakilaSprintbootWebapiApplication.class);
	
	public static void main(String[] args) {	 
		SpringApplication.run(SakilaSprintbootWebapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Starting SakilaSprintbootWebapiApplication");
		
	}

}
