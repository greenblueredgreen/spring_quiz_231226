package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

//jpa 레파지토리 라이브러리 상속받음
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{

	//save메소드 생략되어 있음
	// <entity이름, Integer>
	public CompanyEntity findById(int id);
}
