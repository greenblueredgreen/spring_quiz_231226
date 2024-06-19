package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service //spring bean
public class StoreBO {
	
	
	//DI // BO에 주입하는 방식
	@Autowired
	private StoreMapper storeMapper;
	
	// input : x (컨트롤러부터 요청 받음)
	// output : List<Store> 컨트롤러로 돌려줌
	public List<Store> getStoreList(){
		return storeMapper.selectStoreList();
	}

}
