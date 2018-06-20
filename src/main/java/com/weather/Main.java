package com.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.weather")
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Logging.logger.debug("Application started");
    }
}
