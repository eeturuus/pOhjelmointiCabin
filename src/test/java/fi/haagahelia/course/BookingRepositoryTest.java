package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import fi.haagahelia.course.domain.Booking;
import fi.haagahelia.course.domain.BookingRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookingRepositoryTest {

    @Autowired
    private BookingRepository repository;

    @Test
    public void findByUnameShouldReturnBooking() {
        List<Booking> bookings = repository.findByUname("Eetu");
        
        //Muista ottaa tämä listaus kommentoinnista CabinBookingApplicationistä jotta testi löytää datan ja voi testata sen olemassaolon
        assertThat(bookings.get(0).getComment()).isEqualTo("Mökille loppu toukokuusta yksin, muutamaksi päiväksi");
    }
    
    @Test
    public void createNewBooking() {
    	Booking booking = new Booking("Eetu", "toukokuussa", LocalDate.of(2021, 05, 24), LocalDate.of(2021, 05, 28));
    	repository.save(booking);
    	assertThat(booking.getId()).isNotNull();
    }    

}