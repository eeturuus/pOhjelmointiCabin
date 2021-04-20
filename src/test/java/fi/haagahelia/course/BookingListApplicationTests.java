package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import fi.haagahelia.course.domain.Booking;
import fi.haagahelia.course.web.BookingController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookingListApplicationTests {

	@Test
	public void contextLoads() {
	}

}
