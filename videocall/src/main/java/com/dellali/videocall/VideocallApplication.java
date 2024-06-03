package com.dellali.videocall;

import com.dellali.videocall.user.User;
import com.dellali.videocall.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideocallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLinRunner(
			UserService service
	){
		return args ->{
			service.register(User.builder()
							.username("oussama00")
							.email("oussama@gmail.com")
							.password("AAA")
					.build());

			service.register(User.builder()
					.username("oussama11")
					.email("oussama11@gmail.com")
					.password("BBB")
					.build());

			service.register(User.builder()
					.username("oussama22")
					.email("oussama22@gmail.com")
					.password("CCC")
					.build());
		};
	}



}
