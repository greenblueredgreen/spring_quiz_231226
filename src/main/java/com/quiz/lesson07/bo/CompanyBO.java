package com.quiz.lesson07.bo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	
	@Autowired
	private CompanyRepository companyRepository;

	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {
		//input : 4개 파라미터
		//output : CompanyEntity
		//CompanyEntity company = 
//				CompanyEntity.builder()
//				.name(name)
//				.business(business)
//				.scale(scale)
//				.headcount(headcount)
//				.createdAt(LocalDateTime.now())
//				.build();
		//return companyRepository.save(company); //save가 리턴해준다. 
		return companyRepository.save(
				CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.createdAt(LocalDateTime.now())
				.build());
	}
	
	public CompanyEntity updateCompany(int id, String scale, int headcount) {
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		if(company != null) {
			company = company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build();
			
			company = companyRepository.save(company);
		}
		return company;
	}
}
