package com.captions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;

@SpringBootApplication
public class CaptionsGeneratorApplication {

	public static void main(String[] args) {
		DataManager instance = DataManager.getInstance();
		SpringApplication.run(CaptionsGeneratorApplication.class, args);
	}

}
