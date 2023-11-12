package com.smiple.crud.mytest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
 
@EnableAsync
@EnableCaching
@SpringBootApplication(scanBasePackages="com.smiple.crud.mytest")
public class Application implements ApplicationRunner {
    
    final static Logger logger = LoggerFactory.getLogger(Application.class);
    
    public static void main( String[] args ){
        SpringApplication app = new SpringApplication(Application.class);
//        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }
 
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Start Simple CRUD");
        
    }
}