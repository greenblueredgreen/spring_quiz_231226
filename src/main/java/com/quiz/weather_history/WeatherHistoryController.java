package com.quiz.weather_history;

import org.springframework.web.bind.annotation.GetMapping;

public class WeatherHistoryController {
	
	@GetMapping("/weather_history")
	public String weather() {
		return "/weather_history/weatherList";
	}
}
