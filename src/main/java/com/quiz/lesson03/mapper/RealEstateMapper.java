package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	
	public RealEstate selectRealEstateById(int id);
	
	public	List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);

	//xml로 파라미터를 넘길 때 한 개 밖에 보낼 수 없다!
	// 두 개를 보낼 때는 map으로 묶어서 map으로 보내야한다.
	// 파라미터들을 하나의 Map으로 담아서 보내야한다.
	// @Param 어노테이션을 붙이면 하나의 Map이 된다.
	public List<RealEstate> selectRealEstateListByAreaPrice(
			@Param("area")int area, 
			@Param("price")int price);
	//@Param 안 "area"는 xml #{area}와 연결된다(매핑이 된다.).
}
