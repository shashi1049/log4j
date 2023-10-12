package com.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.log4j.general.App;

@SpringBootApplication
public class Log4jProjectApplication {
	private static final Logger LOG = LogManager.getLogger(Log4jProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Log4jProjectApplication.class, args);
		LOG.info("Application Started!");
		LOG.info("Now call API");
	}

}
