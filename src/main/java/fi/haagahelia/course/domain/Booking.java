package fi.haagahelia.course.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.temporal.ChronoUnit;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
   	private String uname;
    private String comment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enddate;
    //private Long daysBetween = ChronoUnit.DAYS.between(date, enddate);


	public Booking() {}
    
    
	public Booking(String uname, String comment, LocalDate date, LocalDate enddate) {
		super();
		this.uname = uname;
		this.comment = comment;
		this.date = date;
		this.enddate = enddate;
		//this.daysBetween = daysBetween;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
    public LocalDate getEnddate() {
		return enddate;
	}
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
//	public Long getDaysBetween() {
//		return daysBetween;
//	}
//
//	public void setDaysBetween(Long daysBetween) {
//		this.daysBetween = daysBetween;
//	}
	
	@Override
	public String toString() {
		return "Booking [id=" + id + ", uname=" + uname + ", comment=" + comment + ", date=" + date  + ", enddate=" + enddate + "]";
	}
}
// ", daysBetween=" + daysBetween + 