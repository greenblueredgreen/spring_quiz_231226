package com.quiz.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;


@RequestMapping("/lesson06/quiz02")
@Controller
public class Lesson06Quiz02Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;
	
	//http://localhost:8080/lesson06/quiz02/add-bookmark-view
	//즐겨찾기 추가화면
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	//즐겨찾기 리스트화면
	//http://localhost:8080/lesson06/quiz02/bookmark-list-view
	@GetMapping("/bookmark-list-view")
	public String BookmarkListView(){
		return "lesson06/bookmarkList";
	}
	
	
	// AJAX요청 - url 중복확인
	@ResponseBody
	@PostMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url){
		
		// db select
		boolean isDuplication = bookmarkBO.isDuplication(url);
		
		// 응답 json
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		return result;
		// json으로 변환되어서 내려진다.
	}
	
	// http://localhost:8080/lesson06/quiz02/delete-bookmark?id=3
	// ajax 요청 - id로 삭제하기
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id){
		
		//db delete
		int rowCount = bookmarkBO.deleteBookmarkById(id);
		
		//응답값 json
		Map<String, Object> result = new HashMap<>();
		if(rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 항목이 존재하지 않습니다.");
		}
		return result;
		//응답 responsebody로 내려진다
	}
}
