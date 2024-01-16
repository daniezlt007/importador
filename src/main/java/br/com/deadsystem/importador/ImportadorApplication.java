package br.com.deadsystem.importador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImportadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImportadorApplication.class, args);
		System.setProperty("java.awt.headless", "false");
	}

}
