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

	// 판매자 추가하는 화면 
	// get인지 post인지 명확히 해주는 것이 좋다. 
	//http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")    //ResponseBody가 없다. 
	public String addSellerView() {
		//파라미터 없음 
		
		//templates의 lesson04의 addSeller.html로 이동한다. (view의 경로)
		return "lesson04/addSeller"; //jsp로 반환(이동)
	}
	
	
	
	//판매자 DB에 저장 => 성공화면! 으로 이동
	//http://localhost:8080/lesson04/quiz01/add-seller
	//POST 방식 (GET요청으로 받을 수 없다.)
	//postmapping은 직접 이 링크로 접근이 불가능하다.
	//add-seller(jsp)로 맵핑을 해야한다.
	//action="/lesson04/quiz01/add-seller"
	@PostMapping("/add-seller")
	public String addSeller(
			//addSeller.html의 name= 과 똑같아야한다. 
			@RequestParam("nickname") String nickname,
			//nickname 만 null값 불가라서 nickname만 필수파람 지정을 해준다.
			
			@RequestParam(value="profileImage", required = false) String profileImage,
			// 나머지는 null값 허용이라 이런식으로 설정해준다.
			@RequestParam(value="temperature", defaultValue="36.5") double temperature
			//이거는 null값 허용 및 기본값 36.5도 설정해놓은 것
			) {
		
		
		//DB insert
		sellerBO.addSeller(nickname, profileImage, temperature);
		
		// 성공 화면으로 이동
		return "lesson04/afterAddSeller"; 
		// 이제는 html로 이동!
		//afterAddSeller jsp로 이동
	}
	
	
	
	// 방금 가입한 판매자 1명의 화면 (끝 - view)
	//http://localhost:8080/lesson04/quiz01/seller-info-view
	//http://localhost:8080/lesson04/quiz01/seller-info-view?id=1
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			@RequestParam(value="id", required=false) Integer id,
			Model model   //model은 springframework.ui로 import
			) {
		
		Seller seller= null;
		
		// DB SELECT
		// 데이터 조회
		if(id==null) {
			seller = sellerBO.getLatestSeller(); //input이 없는 함수 
		} else {
			seller = sellerBO.getSellerById(id); 
			//id를 파라미터로 받은 함수 
			//id에 해당하는 걸 조회
		}
		

		// MODEL에 데이터 담기 
		// model로 접근하기 위한 방법이다.
		model.addAttribute("seller", seller);    //위의 seller변수를 "seller"에 넣는다.
		model.addAttribute("title", "판매자 정보"); // "판매자 정보를 "title" 에 넣는다.
		
		
		
		// 응답화면
		// 화면에 뿌리기!
		return "lesson04/sellerInfo";
		
		
		
		// 방금 가입한 판매자 1명의 화면 (끝 - view)
		//http://localhost:8080/lesson04/quiz01/seller-info-view
		//@GetMapping("/seller-info-view")
		//public String sellerInfoView(Model model){
		
		//데이터 조회
		//Seller seller = sellerBO.getLatestSeller();
		
		// model에 데이터 담기
		// model.addAttribute("seller", seller);
		// model.addAttrivute("title", "판매자 정보");
		
		// 화면에 뿌리기!
		//		return "lesson04/sellerInfo";
		// }
		
		
		}
	
	//http://localhost:8080/lesson04/quiz01/seller-info-view?id=1
	public String addSeller1(Model model,
			@RequestParam(value = "id", required=false) Integer id) {
		
		// 데이터 조회
		Seller seller = null;
		
		if (id == null) {
			sellerBO.getLatestSeller();  //원래 하던 것처럼 데이터 조회
		} else{
			sellerBO.getSellerById(id); // id에 해당하는 걸로 데이터 조회
		}
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		return "lesson04/sellerInfo";
	
	}
}
