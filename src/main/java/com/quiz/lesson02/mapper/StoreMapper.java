package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Store;

//어노테이션 먼저 하기
@Mapper
public interface StoreMapper {
	
	//input : bo로부터 받아옴 x
	//output : bo에게 줌 List<Store>
	//쿼리문과 가까워졌기 때문에 select로
	
	public List<Store> selectStoreList();
	
}
