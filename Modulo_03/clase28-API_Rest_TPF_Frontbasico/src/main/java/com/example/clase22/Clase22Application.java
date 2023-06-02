package com.example.clase22;

import com.example.clase22.bd.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase22Application {

	public static void main(String[] args) throws Exception {
		BD.crearTablas();
		SpringApplication.run(Clase22Application.class, args);
	}

}
