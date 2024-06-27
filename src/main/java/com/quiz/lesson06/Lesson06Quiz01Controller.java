package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {
	
	@Autowired
	BookmarkBO bookmarkBO;

	//추가화면
	//http://localhost:8080/lesson06/quiz01/add-website-view
	@GetMapping("/add-website-view")
	public String addWebSiteView() {
		return "lesson06/addWebSite";
	}
	
	//목록화면
	//http://localhost:8080/lesson06/quiz01/list-website-view
	@GetMapping("/list-website-view")
	public String listWebSiteView(Model model) {
		
		//db select => List<Bookmark>
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		// 노란색 줄은 객체가 사용하지 않고있다는 뜻
		
		// model 에 담기
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "lesson06/listWebSite";
	}
	
	//AJAX가 하는 요청
	//즐겨찾기 추가하는 로직
	@ResponseBody //필수
	@PostMapping("/add-website")
	public String addWebSite(
			@RequestParam("name") String name,
			@RequestParam("url") String url
			) {
		
		//db insert
		bookmarkBO.addBookmark(name, url);
		
		// ajax응답
		// "성공"
		return "성공"; //ajax로 돌아간다.
	}
}
