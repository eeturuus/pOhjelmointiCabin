package fi.haagahelia.course.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import fi.haagahelia.course.domain.Booking;


@RepositoryRestResource
public interface BookingRepository extends CrudRepository<Booking, Long>{

	
	List<Booking> findById(long Id);

	List<Booking> findByDate(LocalDate date);
	
	List<Booking> findByUname(@Param("uname")String uname);
	
}
