package com.quiz.weather_history;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.domain.Member;
import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller

public class WeatherHistoryController {
	
	@Autowired
	WeatherHistoryBO weatherHistoryBO;
	
	//날씨 목록 화면 
	//http://localhost:8080/weather-history/weather-list-view
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		
		// select db
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherhistoryList();
		
		//model 에 담기
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		//화면에 뿌리기 
		return "weather_history/weatherList";
	}
	
	
	//http://localhost:8080/weather-history/add-weather-view
	//날씨 추가 화면 view(보내는 기능 없음)
	//보내는 것이 아니라 화면만 보여지는 것이다.
	//화면
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	//실제 기능 구현
	//파라미터 전송해주는 것
	//날씨 실제로 추가 해주는 기능(db에 insert등...)
	//insert기능은 무조건 post이다.
	@PostMapping("/add-weather")
	public String addWeather(
			@ModelAttribute
			WeatherHistory weatherHistory,
			Model model) {

		weatherHistoryBO.addWeatherHistory(weatherHistory);
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "weather_history/weaterList";
	}
	
}
