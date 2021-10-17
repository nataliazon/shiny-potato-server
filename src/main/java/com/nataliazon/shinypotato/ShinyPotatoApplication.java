package com.nataliazon.shinypotato;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ShinyPotatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShinyPotatoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PlayerRepository userRepository) {
		return args -> {
			Stream.of("Gertrude", "Henrietta", "Travis", "Agnes", "Juliet").forEach(name -> {
				Player player = new Player(name, name.toLowerCase() + "@domain.com");
				userRepository.save(player);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}
}
