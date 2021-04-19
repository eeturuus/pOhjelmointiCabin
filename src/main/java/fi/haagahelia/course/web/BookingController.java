package fi.haagahelia.course.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.course.domain.Booking;
import fi.haagahelia.course.domain.BookingRepository;
import fi.haagahelia.course.domain.User;
import fi.haagahelia.course.domain.UserRepository;

@Controller
public class BookingController {
	
	@Autowired
	private BookingRepository repository;
	
	@Autowired
	private UserRepository urepository;
	
//	@Autowired
//	private DateRepository drepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
//	@RequestMapping("/bookinglist")
//	public String results(Model model) {
//	UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    String username = user.getUsername();
//    User userNow = urepository.findByUsername(username);
//	model.addAttribute("bookinglist", repository.findByUname(userNow));
//	return "booking";
//}
	
    @RequestMapping(value= {"/bookinglist"})
    public String bookList(Model model) {
    	System.out.println("OLLAAN BOOKINGLIST ENDPOINTISSA");
        model.addAttribute("bookings", repository.findAll());
        return "bookinglist";
    }
  
    // RESTful service to get all books
    @RequestMapping(value="/bookings", method = RequestMethod.GET)
    public @ResponseBody List<Booking> bookingListRest() {
    	return (List<Booking>) repository.findAll();
    }
    
    // RESTful service to get book by id
    @RequestMapping(value="/booking/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Booking> findBookingRest(@PathVariable("id") Long bookingId) {
		return repository.findById(bookingId);
	}
    
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("booking", new Booking());
//    	model.addAttribute("categories", drepository.findAll());
        return "addbooking";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Booking booking) {
        repository.save(booking);
        return "redirect:bookinglist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String delete(@PathVariable("id") Long bookingId, Model model) {
    	repository.deleteById(bookingId);
        return "redirect:../bookinglist"; //redirect:bookinglist
    }
    
    @RequestMapping(value="/modify/{id}", method=RequestMethod.GET)
	public String modifyBooking(@PathVariable("id") Long bookingId, Model model) {
		Optional<Booking> booking = repository.findById(bookingId);
		model.addAttribute("booking", booking);
//		model.addAttribute("categories", drepository.findAll());
		System.out.println("OLLAAN MODIFYBOOKING METODISSA");
		System.out.println(booking);
    	return "modifybooking";
	}
}
