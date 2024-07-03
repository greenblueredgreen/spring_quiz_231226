package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	
	@Autowired
	BookingMapper bookingMapper;
	
	public List<Booking> getBooingList(){
		return bookingMapper.selectBookingList();
	}
	
	public void addBooking(String name, LocalDate date,
			int day, int headcount, String phoneNumber) {
		
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	
	
	// input : name
	// output :Booking(최신) or null 
	public Booking getLatestBookingByNamePhoneNumber(String name, String phoneNumber) {
		//List가 비어있을 경우 : [] null 아님
		//있을 때 : [booking1, booking2]
		List<Booking> bookingList = bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber);
		//if (bookingList.isEmpty()) {
		//	return null;
		//}else {
		//	return bookingList.get(bookingList.size()-1);
		//}
		//삼항연산자 사용
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size()-1);
	}
}
