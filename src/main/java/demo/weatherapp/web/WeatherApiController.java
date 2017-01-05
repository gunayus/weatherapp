package demo.weatherapp.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.weatherapp.ows.Weather;
import demo.weatherapp.ows.WeatherForecast;
import demo.weatherapp.ows.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherApiController {

	private final WeatherService weatherService;

	public WeatherApiController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@RequestMapping("/now/{country}/{city}")
	public Weather getWeather(@PathVariable("country") String country,
			@PathVariable String city) {
		return this.weatherService.getWeather(country, city);
	}

	@RequestMapping("/weekly/{country}/{city}")
	public WeatherForecast getWeatherForecast(@PathVariable String country,
			@PathVariable String city) {
		return this.weatherService.getWeatherForecast(country, city);
	}

}
