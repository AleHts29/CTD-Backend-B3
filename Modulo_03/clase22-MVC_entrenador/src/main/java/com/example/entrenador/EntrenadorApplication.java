package com.example.entrenador;

import com.example.entrenador.dao.BDH2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntrenadorApplication {

	public static void main(String[] args) {
		BDH2.cargarBD();
		SpringApplication.run(EntrenadorApplication.class, args);
	}

}
