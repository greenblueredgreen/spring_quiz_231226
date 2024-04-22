package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller  //RestController로 하면 "lesson04/addSeller"이 글자가 그래도 출력된다.
public class Lesson04Quiz01Controller {
	
	//bo객체 만들기
	@Autowired
	private SellerBO sellerBO;
	
	
	// 판매자 추가 jsp 만들기
	//http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller"; //jsp로 반환(이동)
	}
	
	

	//http://localhost:8080/lesson04/quiz01/add-seller
	//post방식
	//add-seller(jsp)로 맵핑을 해야한다.
	//action="/lesson04/quiz01/add-seller"
	@PostMapping("/add-seller")
	// postmapping은 직접 이 링크로 접근이 불가능하다.
	// 위에를 통해서 들어가야한다.
	public String addSeller(
			@RequestParam("nickname") String nickname,
			//nickname 만 null값 불가라서 nickname만 필수파람 지정을 해준다.
			@RequestParam(value="profileImage", required = false) String profileImage,
			// 나머지는 null값 허용이라 이런식으로 설정해준다.
			@RequestParam(value="temperature", defaultValue="36.5") double temperature
			//이거는 null값 허용 및 기본값 36.5도 설정해놓은 것
			) {
		
		
		//DB insert
		sellerBO.addSeller(nickname, profileImage, temperature);
		
		// 성공 화면
		return "lesson04/afterAddSeller"; //afterAddSeller jsp로 이동
	}
	
	
	//http://localhost:8080/lesson04/quiz01/seller-info-view
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			@RequestParam(value="id", required=false) Integer id,
			Model model
			) {
		//model은 springframework.ui로 import
		
		Seller seller= null;
		
		// DB SELECT
		if(id==null) {
			seller = sellerBO.getLatestSeller();  //Seller는 domain이다. 
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		// MODEL
		// model로 접근하기 위한 방법이다.
		model.addAttribute("seller", seller);    
		model.addAttribute("title", "판매자 정보");
		
		// 응답화면으로 이동
		return "lesson04/sellerInfo";
	}
}
