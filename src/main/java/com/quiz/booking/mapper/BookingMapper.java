package com.quiz.booking.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {

	//예약 리스트 select해서 가져오기
	public List<Booking> selectBookingList();
	
	//예약 페이지 삽입
	public void insertBooking(
			@Param("name") String name, 
			@Param("date") LocalDate date,
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	
	// input : name, phoneNumber
	// output : List<Booking>
	public List<Booking> selectBookingListByNamePhoneNumber(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
}
