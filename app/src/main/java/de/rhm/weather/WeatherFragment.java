package de.rhm.weather;

import android.app.Fragment;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import java.text.NumberFormat;
import java.util.List;

import de.rhm.weather.model.CityWeather;

@EFragment(R.layout.fragment_weather)
public class WeatherFragment extends Fragment {

    private static final String CITY_IDS = "2950159,2988507,5368361";
    private final NumberFormat mNumberFormat = NumberFormat.getNumberInstance();

    @RestService
    protected OpenWeatherMapClient mWeatherClient;

    @ViewById(R.id.test)
    protected TextView tvCityTemp;

    @AfterViews
    protected void init() {
        fetchWeatherDataAsync();
    }

    @Background
    protected void fetchWeatherDataAsync() {
        updateView(mWeatherClient.getGroup(CITY_IDS).list);
    }

    @UiThread
    protected void updateView(List<CityWeather> cityWeatherList) {
        for (CityWeather weather : cityWeatherList) {
            tvCityTemp.append(weather.cityName + ": " + mNumberFormat.format(weather.weather.temp) + " °C \n");
        }
    }

}
