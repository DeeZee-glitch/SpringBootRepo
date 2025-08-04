package com.example.DemoZain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.example.DemoZain.model.caapp",
		"com.example.DemoZain.model.zain"
})
public class DemoZainApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoZainApplication.class, args);
	}
}