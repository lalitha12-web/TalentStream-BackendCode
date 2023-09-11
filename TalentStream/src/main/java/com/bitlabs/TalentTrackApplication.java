package com.bitlabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bitlabs.filters.JwtRequestFilter;

@SpringBootApplication
public class TalentTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentTrackApplication.class, args);
	}
	
}
