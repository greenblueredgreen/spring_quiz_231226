package com.quiz.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {

	public List<Booking> selectBookingList();
	
	// input : name, phoneNumber
	// output : List<Booking>
	public List<Booking> selectBookingListByNamePhoneNumber(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
}
