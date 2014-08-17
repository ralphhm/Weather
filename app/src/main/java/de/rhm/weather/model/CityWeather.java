package de.rhm.weather.model;

import com.google.gson.annotations.SerializedName;

public class CityWeather {

    @SerializedName("name")
    public final String cityName = null;

    @SerializedName("main")
    public final MainWeatherInfo weather = null;

    public static class MainWeatherInfo {
        public final Float temp = null;
    }
}
