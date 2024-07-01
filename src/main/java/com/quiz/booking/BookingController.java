package com.quiz.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	
	@Autowired
	BookingBO bookingBO;
	
	//http://localhost:8080/booking/booking-list-view
	//list view
	@GetMapping("/booking-list-view")
	public String bookingListView() {
		return "booking/bookingList";
	}
	
	public List<Booking> bringBookingList(Model model){
		
		return bookingBO.getBooingList();
	}
	
	//예약페이지 뷰
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	//예약확인 페이지뷰
	@GetMapping("check-booking-view")
	public String chckBookingView() {
		return "booking/chickBooking";
	}
}
