package de.rhm.weather;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import de.rhm.weather.model.WeatherInfoGroup;

@Rest(rootUrl = "http://api.openweathermap.org", converters = {GsonHttpMessageConverter.class})
public interface OpenWeatherMapClient {

    @Get("/data/2.5/group?id={ids}&units=metric")
    WeatherInfoGroup getGroup(String ids);

}
