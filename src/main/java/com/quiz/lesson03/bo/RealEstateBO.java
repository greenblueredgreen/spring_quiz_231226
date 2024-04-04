package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateMapper realEstateMapper;
	
	// input : id
	//output : RealEstate
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	//input :rentPrice
	//output : List<RealEstate
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
	
	//input : area, price
	// output : List<RealEstate>
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
		return realEstateMapper.selectRealEstateListByAreaPrice(area, price);
	}
	
	
	//input:RealEstate
	//output : int
	
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	
	// input: id, type, price (controller로부터 넘어온다.)
	// output: int(성공한 행의 개수)
	public int updataRealEstateById(int id, String type, int price) {
		return realEstateMapper.updataRealEstateById(id, type, price);
	}
}
