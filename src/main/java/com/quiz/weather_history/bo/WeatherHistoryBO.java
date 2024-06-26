package com.quiz.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO{
	
	@Autowired 
	WeatherHistoryMapper weatherHistoryMapper;
	
	//input :x
	//output : List<WeatherHistory>
		
	//select
	public List<WeatherHistory> getWeatherhistoryList() {
		return weatherHistoryMapper.selectWeatherhistoryList();
	}
	
	//insert 
	// return x
	public void addWeatherHistory(
			String date,
			String weather,
			String microDust,
			double temperatures,
			double precipitation,
			double windSpeed
			) {
		
		//void이기 때문에 호출만 하고 끝난다.
		weatherHistoryMapper.insertWeatherHistory(
				date, 
				weather, 
				microDust, 
				temperatures, 
				precipitation, 
				windSpeed);
	}
}
