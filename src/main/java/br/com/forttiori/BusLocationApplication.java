package br.com.forttiori;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BusLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusLocationApplication.class, args);
	}

}
