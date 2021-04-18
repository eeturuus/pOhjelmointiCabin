package fi.haagahelia.course.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
   	private String uname;
    private String comment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
    
    public Booking() {}
    
    
	public Booking(String uname, String comment, LocalDate date) {
		super();
		this.uname = uname;
		this.comment = comment;
		this.date = date;
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
	@Override
	public String toString() {
		return "Booking [id=" + id + ", uname=" + uname + ", comment=" + comment + ", date=" + date + "]";
	}
}
