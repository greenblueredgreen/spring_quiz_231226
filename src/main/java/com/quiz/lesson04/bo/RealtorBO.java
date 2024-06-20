package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.mapper.RealtorMapper;

@Service  //스프링 bean으로 등록
public class RealtorBO {
	
	@Autowired
	RealtorMapper realtorMapper;
	
	// input : Realtor 
	// output : x 
	// 값을 넣는 것이기 때문에 return 안해도 상관없다. 
	public void addRealtor(Realtor realtor) {
		realtorMapper.insertRealtor(realtor);
		//void타입이므로 return 없다. 
	}
	
	// input : id
	// output : Realtor 
	public Realtor getRealtorById(int id) {
		return realtorMapper.selectRealtorById(id);
	}

}
