package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/lesson06/quiz02")
@Controller
public class Lesson06Quiz02Controller {
	
	//http://localhost:8080/lesson06/quiz02/add-bookmark-view
	//즐겨찾기 추가화면
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	//즐겨찾기 리스트화면
	@GetMapping("/bookmark-list-view")
	public String BookmarkListView(){
		return "lesson06/bookmarkList";
	}
	
	@ResponseBody
	@PostMapping("/delete-bookmark-list")
	public String deleteBookmarkList() {
		return "";
	}
	
}
