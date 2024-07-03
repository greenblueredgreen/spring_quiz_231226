package com.quiz.lesson07.bo;

import java.time.LocalDateTime;
import java.util.Optional;

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
	
	//input : id, scale, headcount
	//output : CompanyEntity
	public CompanyEntity updateCompanyById(int id, String scale, int headcount) {
		//기존 데이터 조회
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		if(company != null) {
			//null이 아닐 때만 업데이트 하겠다.
//			company = company.toBuilder()
//					.scale(scale)
//					.headcount(headcount)
//					.build();
//			company = companyRepository.save(company);
			
			company = companyRepository.save(company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build());
		}
		return company;
	}
	
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		//CompanyEntity = s
		companyOptional.ifPresent(s-> companyRepository.delete(s));
	}
}
