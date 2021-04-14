package fi.haagahelia.course;


import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Booking;
import fi.haagahelia.course.domain.BookingRepository;
import fi.haagahelia.course.domain.Date;
import fi.haagahelia.course.domain.DateRepository;
import fi.haagahelia.course.domain.User;
import fi.haagahelia.course.domain.UserRepository;


@SpringBootApplication
public class CabinBookingApplication {
	private static final Logger log = LoggerFactory.getLogger(CabinBookingApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CabinBookingApplication.class, args);
	}
	
//	@Override
//	 protected SpringApplicationBuilder configure(SpringApplicationBuilder
//	application) {
//	 return application.sources(BookstoreApplication.class);
//	 }
	
	
	
	@Bean
	public CommandLineRunner bookDemo(BookingRepository repository, UserRepository userRepository) {
		return (args) -> {
			log.info("save a couple of books");
			userRepository.deleteAll();

			
			//repository.deleteAll();
			repository.save(new Booking("Eetu", "Mökille loppu toukokuusta", LocalDate.of(2021, 01, 01)));
			repository.save(new Booking("Testi", "Mökille loppu toukokuusta", LocalDate.of(2021, 01, 01)));
			repository.save(new Booking("Joku", "Mökille loppu toukokuusta", LocalDate.of(2021, 01, 01)));
			
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user@gmail.com");	//lisää email molempiin mahdollisesti
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@gmail.com");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("fetch all books");
			for (Booking book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
