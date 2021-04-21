package fi.haagahelia.course;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.xml.datatype.Duration;

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
	public CommandLineRunner Booking(BookingRepository repository, UserRepository userRepository) {
		return (args) -> {
			log.info("save a couple of books");
			
			userRepository.deleteAll();
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@gmail.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			//repository.deleteAll(); // poistaa kaikki repositoryt jottei joka kerta laita uusia
//			repository.save(new Booking("Eetu", "Mökille loppu toukokuusta yksin, muutamaksi päiväksi", LocalDate.of(2021, 05, 24), LocalDate.of(2021, 05, 28)));
//			repository.save(new Booking("Hanna", "Mökille Juhannuksena", LocalDate.of(2021, 06, 25), LocalDate.of(2021, 06, 27)));
//			repository.save(new Booking("Milla", "Mökille toukokuussa ystävien kanssa", LocalDate.of(2021, 05, 23), LocalDate.of(2021, 05, 25)));
//			repository.save(new Booking("Eetu", "Mökille Juhannuksena", LocalDate.of(2021, 06, 25), LocalDate.of(2021, 06, 27)));
			
			
			
			
			log.info("fetch all books");
			for (Booking book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
