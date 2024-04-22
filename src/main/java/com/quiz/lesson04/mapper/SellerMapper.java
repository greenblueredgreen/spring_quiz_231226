package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson04.domain.Seller;

@Mapper
public interface SellerMapper {
	
	// 쿼리문인 insert로 바꿔준다. 
	public void insertSeller(
			// 파라미터 여러 개이므로 map으로!
			@Param("nickname") String nickname, 
			@Param("profileImage") String profileImage, 
			@Param("temperature") double temperature);
	
	//get을 select로 바꿔준다. 
	public Seller selectLatestSeller();
	
	public Seller selectSellerById(int id);
}
