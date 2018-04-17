package com.tolunayguduk.hava_durumu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by tolunayguduk on 16.04.2018.
 */

public class getWeatherDaily {
    String result_main = "";
    String result_description = "";
    String result_icon = "";
    int result_temp;
    String result_city;
    Bitmap bitImage;
    HashMap<String,Object> map = new HashMap<>();

    public HashMap<String,Object> weather(String sehir){
        String result = "";
        try {
            URL weather_url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + sehir + "&appid=5519df78a91952f50079565124888a76");//Url'mizi
            BufferedReader bufferedReader = null;
            bufferedReader = new BufferedReader(new InputStreamReader(weather_url.openStream()));//url'yi okuyacak bufferReader'a gönderdik
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {//satırları tek tek aldık ve ekledik
                result += line;
            }
            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(result);//string ifadeye çevirdik
            JSONArray jsonArray = jsonObject.getJSONArray("weather");//şimdi jsona bakarsanız weather isimli bir dizi var o diziyi aldık
            JSONObject jsonObject_weather = jsonArray.getJSONObject(0);//ilk indexi aldık
            result_main = jsonObject_weather.getString("main");//ilk indexin main adlı değişkenini çektik
            result_description = jsonObject_weather.getString("description");
            result_icon = jsonObject_weather.getString("icon");
//tek tek işimize yarayacakları aldık

            JSONObject jsonObject_main = jsonObject.getJSONObject("main");//main diye son kısımlarda bir değişken var onuda aldık
            Double temp = jsonObject_main.getDouble("temp");//main'in içinden sıcaklığı aldık

            result_city = jsonObject.getString("name");//en sondaki kısımdan city ismini aldık

            result_temp = (int) (temp - 273);//Kelvin olduğu için Celcius'a çevirdik

            URL icon_url = new URL("http://download.spinetix.com/content/widgets/icons/weather/" + result_icon + ".png");//resimda saklıyor api adresimiz
            bitImage = BitmapFactory.decodeStream(icon_url.openConnection().getInputStream());//Android'de image olarak kullanamadığımız için bitmap formatına çevirdik


            map.put("result_main",result_main);
            map.put("result_description",result_description);
            map.put("result_icon",result_icon);
            map.put("result_city",result_city);
            map.put("result_temp",result_temp);
            map.put("bitImage",bitImage);
            map.put("desc",result_description);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  map;
    }
}
