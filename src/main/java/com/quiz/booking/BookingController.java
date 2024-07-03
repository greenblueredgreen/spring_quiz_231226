package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String bookingListView(Model model) {
		
		//db select 해서 list에 담아서 가져오기
		List<Booking> bookingList = bookingBO.getBooingList();
		
		//model에 담기
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	//http://localhost:8080/booking/make-booking-view
	//예약하기 뷰
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	// insert 및 ajax 요청 post 페이지
	//예약 add - ajax  요청
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("date") LocalDate date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber		
			){
		
		//db 삽입
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		//응답값 AJAX
		Map<String, Object> result= new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	
	//http://localhost:8080/booking/check-booking-view
	//예약확인 페이지뷰
	@GetMapping("/check-booking-view")
	public String chckBookingView() {
		return "booking/checkBooking";
	}
	
	@PostMapping("/select-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber){
		
		//db select
		Booking booking = bookingBO.getLatestBookingByNamePhoneNumber(name, phoneNumber);
		
		// 응답값 => json
		Map<String, Object> result = new HashMap<>();
		if(booking != null) {
			// {"code" : 200, "result" : booking 객체}
			// {"code" : 200, "result" : {"id" : 3, "name" : "강강강"...}}
			result.put("code", 200);
			result.put("result", booking);
		}else {
			//{"code" : 500, "error_message" : "예약 내역이 없습니다."}
			result.put("code", 500);
			result.put("error_message", "예약 내역이 없습니다.");
		}
		return result;
	}
}
