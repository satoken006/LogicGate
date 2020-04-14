package com.example.logicgate;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogicgateApplication {

	public static void main(String[] args) {
//		SpringApplication.run(LogicgateApplication.class, args);

		Gate gate1 = new Gate(GateProperty.OR);
		gate1.setInputs(new boolean[]{true, false});



		System.out.println(gate1.getOutput());
	}

}
