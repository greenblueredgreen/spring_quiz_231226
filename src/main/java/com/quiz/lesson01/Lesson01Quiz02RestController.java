package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {
	
	//http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List quiz02_1(){
		//list에 map을 하나씩 각각 넣기 
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map = new HashMap();
		map.put("rate", 15);
		map.put("director", "봉준호");
		map.put("time", 131);
		map.put("title", "기생충");
		list.add(map);
		
		//Map을 하나씩 별도로 만들어야한다.
		//왜냐하면 원래 맵에다가 하면, 넣은 값들이 덮어씌워진다.
		// 따라서 new를 통해서 새 객체를 만들어서 다시 넣어야한다.
		// new를 안하고 값을 넣게되면 원래 map값이 바뀐다. 
		// map을 새로 new해서 만들어서 넣는다.
		Map<String, Object> map1 = new HashMap();
		// map = new HashMap<>();  방식도 가능하다.
		// 어차피 new를 하면 새로 쌓이기 때문이다.
		map1 .put("rate", 0);
		map1 .put("director", "로베르");
		map1 .put("time", 166);
		map1 .put("title", "인생");
		list.add(map1);
		
		Map<String, Object> map2 = new HashMap();
		map2.put("rate", 12);
		map2.put("director", "널린");
		map2.put("time", 147);
		map2.put("title", "인셉션");
		list.add(map2);
		
		Map<String, Object> map3 = new HashMap();
		map3.put("rate", 15);
		map3.put("director", "프린세스 로렌스");
		map3.put("time", 137);
		map3.put("title", "헝거 게임");
		list.add(map3);
		
		return list;
	}
	
	
	
	//http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Data> quiz02_2() {
		// 여러 개면 리스트로 한다.
		
		
		// 이건 map으로 리스트에 하나씩 넣은 방식이다.
//		List<Map<String, String>> list = new ArrayList<>();
//		
//		Map <String, String> map = new HashMap<>();
//		map.put("title", "ㅎㅇㅎㅇ");
//		map.put("user", "marobiana");
//		map.put("content", "잘부탁드림");
//		list.add(map);
//		
//		Map <String, String> map1 = new HashMap<>();
//		map1.put("title", "대박");
//		map1.put("user", "bada");
//		map1.put("content", "제발 금요일");
//		list.add(map1);
//		
//		Map <String, String> map2 = new HashMap<>();
//		map2.put("title", "오늘데이트");
//		map2.put("user", "ㅁㅁㅁ");
//		map2.put("content", "응없어");
//		list.add(map2);
		
		
		//Data 객체가 들어가진다.
		List <Data> list = new ArrayList<>();
		
		Data data = new Data();
		data.setTitle("ㅎㅇㅎㅇ");
		data.setUser("marobiana");
		data.setContent("반갑소");
		list.add(data);
	
		//재활용 하는 것이다. 
		//그러나 new를 하면 스택으로 새로 쌓이게 된다.
		//data = new Data(); 도 가능하다.
		Data data1 = new Data();
		data1.setTitle("...");
		data1.setUser("ma");
		data1.setContent("마");
		list.add(data1);
		
		Data data2 = new Data();
		data2.setContent("뭘보슈");
		data2.setTitle("안반갑");
		data.setUser("불주먹");
		list.add(data2);
		
		return list;
		//따라서 JSON으로 리턴된다.
		// String -> html, map -> json, class -> json
		// list -> json
		
		// @ResponseBody + return String -> 
		// HttpMessageConverter 가 동작을 한 것! => HTML
		// HttpMessageConverter 이게 동작해서 html로 만든 것이다.
		//@ResponseBody + return 객체(map, class, list) => HttpMessageConverter 
		// => jackson lib가 동작! => json
	}
	
	
	
	//http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	
	// 단건이므로 <Data>로만 한다.
	// 여러개면 List<Data<>>이런 식으로 한다.
	public ResponseEntity<Data> quiz02_3(){
		Data data = new Data();
		data.setTitle("가입인사 안드림");
		data.setUser("강낭콩");
		data.setContent("...");
		
		//500 Internal_Service_Error
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);	
	}	
	
	//http://localhost:8080/lesson01/quiz02/4
	@RequestMapping("/4")
	public ResponseEntity<Board> quiz02_4(){
		Board board= new Board();
		board.setTitle("가입인사 안드림");
		board.setUser("강낭콩");
		board.setContent("...");
		
		//500에러로 발생한다. 우리가 만든 에러
		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);
	}	
}
