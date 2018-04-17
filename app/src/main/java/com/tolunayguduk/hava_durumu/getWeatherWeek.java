package com.tolunayguduk.hava_durumu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

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

public class getWeatherWeek {
    HashMap<String,Object> pazartesi = new HashMap<>();
    HashMap<String,Object> sali = new HashMap<>();
    HashMap<String,Object> carsamba = new HashMap<>();
    HashMap<String,Object> persembe = new HashMap<>();
    HashMap<String,Object> cuma = new HashMap<>();
    HashMap<String,Object> cumartesi = new HashMap<>();
    HashMap<String,Object> pazar = new HashMap<>();
    HashMap<String,Object> all = new HashMap<>();


    public HashMap<String,Object> weather(String sehir){
        String result = "";
        try {
            URL weather_url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q="+ sehir +"&appid=5519df78a91952f50079565124888a76");//Url'mizi
            BufferedReader bufferedReader = null;
            bufferedReader = new BufferedReader(new InputStreamReader(weather_url.openStream()));//url'yi okuyacak bufferReader'a gönderdik
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {//satırları tek tek aldık ve ekledik
                result += line;
            }
            bufferedReader.close();

            JSONObject jsonObject = new JSONObject(result);//string ifadeye çevirdik
            JSONArray jsonArray = jsonObject.getJSONArray("list");//şimdi jsona bakarsanız weather isimli bir dizi var o diziyi aldık
            JSONObject jsonObject_list = jsonArray.getJSONObject(0);//ilk indexi aldık
            JSONObject jsonObject_temp = jsonObject_list.getJSONObject("temp");
            JSONArray jsonArray_weather = jsonObject_list.getJSONArray("weather");
            JSONObject jsonObject_weather = jsonArray_weather.getJSONObject(0);

            pazartesi.put("max",jsonObject_temp.getDouble("max"));
            pazartesi.put("min",jsonObject_temp.getDouble("min"));
            pazartesi.put("time",jsonObject_list.getLong("dt"));

            URL icon_url = new URL("http://download.spinetix.com/content/widgets/icons/weather/" + jsonObject_weather.getString("icon") + ".png");//resimda saklıyor api adresimiz
            Bitmap bitImage = BitmapFactory.decodeStream(icon_url.openConnection().getInputStream());//Android'de image olarak kullanamadığımız için bitmap formatına çevirdik
            pazartesi.put("icon",bitImage);

            JSONObject jsonObject1 = new JSONObject(result);//string ifadeye çevirdik
            JSONArray jsonArray1 = jsonObject1.getJSONArray("list");//şimdi jsona bakarsanız weather isimli bir dizi var o diziyi aldık
            JSONObject jsonObject_list1 = jsonArray1.getJSONObject(1);//ilk indexi aldık
            JSONObject jsonObject_temp1 = jsonObject_list1.getJSONObject("temp");
            JSONArray jsonArray_weather1 = jsonObject_list1.getJSONArray("weather");
            JSONObject jsonObject_weather1 = jsonArray_weather1.getJSONObject(0);

            sali.put("max",jsonObject_temp1.getString("max"));
            sali.put("min",jsonObject_temp1.getString("min"));
            sali.put("time",jsonObject_list1.getLong("dt"));

            icon_url = new URL("http://download.spinetix.com/content/widgets/icons/weather/" + jsonObject_weather1.getString("icon") + ".png");//resimda saklıyor api adresimiz
            bitImage = BitmapFactory.decodeStream(icon_url.openConnection().getInputStream());//Android'de image olarak kullanamadığımız için bitmap formatına çevirdik
            sali.put("icon",bitImage);

            JSONObject jsonObject2 = new JSONObject(result);//string ifadeye çevirdik
            JSONArray jsonArray2 = jsonObject2.getJSONArray("list");//şimdi jsona bakarsanız weather isimli bir dizi var o diziyi aldık
            JSONObject jsonObject_list2 = jsonArray2.getJSONObject(2);//ilk indexi aldık
            JSONObject jsonObject_temp2 = jsonObject_list2.getJSONObject("temp");
            JSONArray jsonArray_weather2 = jsonObject_list2.getJSONArray("weather");
            JSONObject jsonObject_weather2 = jsonArray_weather2.getJSONObject(0);

            carsamba.put("max",jsonObject_temp2.getString("max"));
            carsamba.put("min",jsonObject_temp2.getString("min"));
            carsamba.put("time",jsonObject_list2.getLong("dt"));

            icon_url = new URL("http://download.spinetix.com/content/widgets/icons/weather/" + jsonObject_weather2.getString("icon") + ".png");//resimda saklıyor api adresimiz
            bitImage = BitmapFactory.decodeStream(icon_url.openConnection().getInputStream());//Android'de image olarak kullanamadığımız için bitmap formatına çevirdik
            carsamba.put("icon",bitImage);

            JSONObject jsonObject3 = new JSONObject(result);//string ifadeye çevirdik
            JSONArray jsonArray3 = jsonObject3.getJSONArray("list");//şimdi jsona bakarsanız weather isimli bir dizi var o diziyi aldık
            JSONObject jsonObject_list3 = jsonArray3.getJSONObject(3);//ilk indexi aldık
            JSONObject jsonObject_temp3 = jsonObject_list3.getJSONObject("temp");
            JSONArray jsonArray_weather3 = jsonObject_list3.getJSONArray("weather");
            JSONObject jsonObject_weather3 = jsonArray_weather3.getJSONObject(0);

            persembe.put("max",jsonObject_temp3.getString("max"));
            persembe.put("min",jsonObject_temp3.getString("min"));
            persembe.put("time",jsonObject_list3.getLong("dt"));
            icon_url = new URL("http://download.spinetix.com/content/widgets/icons/weather/" + jsonObject_weather3.getString("icon") + ".png");//resimda saklıyor api adresimiz
            bitImage = BitmapFactory.decodeStream(icon_url.openConnection().getInputStream());//Android'de image olarak kullanamadığımız için bitmap formatına çevirdik
            persembe.put("icon",bitImage);

            JSONObject jsonObject4 = new JSONObject(result);//string ifadeye çevirdik
            JSONArray jsonArray4 = jsonObject4.getJSONArray("list");//şimdi jsona bakarsanız weather isimli bir dizi var o diziyi aldık
            JSONObject jsonObject_list4 = jsonArray4.getJSONObject(4);//ilk indexi aldık
            JSONObject jsonObject_temp4 = jsonObject_list4.getJSONObject("temp");
            JSONArray jsonArray_weather4 = jsonObject_list4.getJSONArray("weather");
            JSONObject jsonObject_weather4 = jsonArray_weather4.getJSONObject(0);

            cuma.put("max",jsonObject_temp4.getString("max"));
            cuma.put("min",jsonObject_temp4.getString("min"));
            cuma.put("time",jsonObject_list4.getLong("dt"));

            icon_url = new URL("http://download.spinetix.com/content/widgets/icons/weather/" + jsonObject_weather4.getString("icon") + ".png");//resimda saklıyor api adresimiz
            bitImage = BitmapFactory.decodeStream(icon_url.openConnection().getInputStream());//Android'de image olarak kullanamadığımız için bitmap formatına çevirdik
            cuma.put("icon",bitImage);

            JSONObject jsonObject5 = new JSONObject(result);//string ifadeye çevirdik
            JSONArray jsonArray5 = jsonObject5.getJSONArray("list");//şimdi jsona bakarsanız weather isimli bir dizi var o diziyi aldık
            JSONObject jsonObject_list5 = jsonArray5.getJSONObject(5);//ilk indexi aldık
            JSONObject jsonObject_temp5 = jsonObject_list5.getJSONObject("temp");
            JSONArray jsonArray_weather5 = jsonObject_list5.getJSONArray("weather");
            JSONObject jsonObject_weather5 = jsonArray_weather5.getJSONObject(0);

            cumartesi.put("max",jsonObject_temp5.getString("max"));
            cumartesi.put("min",jsonObject_temp5.getString("min"));
            cumartesi.put("time",jsonObject_list5.getLong("dt"));
            icon_url = new URL("http://download.spinetix.com/content/widgets/icons/weather/" + jsonObject_weather5.getString("icon") + ".png");//resimda saklıyor api adresimiz
            bitImage = BitmapFactory.decodeStream(icon_url.openConnection().getInputStream());//Android'de image olarak kullanamadığımız için bitmap formatına çevirdik
            cumartesi.put("icon",bitImage);

            JSONObject jsonObject6 = new JSONObject(result);//string ifadeye çevirdik
            JSONArray jsonArray6 = jsonObject6.getJSONArray("list");//şimdi jsona bakarsanız weather isimli bir dizi var o diziyi aldık
            JSONObject jsonObject_list6 = jsonArray6.getJSONObject(6);//ilk indexi aldık
            JSONObject jsonObject_temp6 = jsonObject_list6.getJSONObject("temp");
            JSONArray jsonArray_weather6 = jsonObject_list6.getJSONArray("weather");
            JSONObject jsonObject_weather6 = jsonArray_weather6.getJSONObject(0);

            pazar.put("max",jsonObject_temp6.getString("max"));
            pazar.put("min",jsonObject_temp6.getString("min"));
            pazar.put("time",jsonObject_list6.getLong("dt"));
            icon_url = new URL("http://download.spinetix.com/content/widgets/icons/weather/" + jsonObject_weather6.getString("icon") + ".png");//resimda saklıyor api adresimiz
            bitImage = BitmapFactory.decodeStream(icon_url.openConnection().getInputStream());//Android'de image olarak kullanamadığımız için bitmap formatına çevirdik
            pazar.put("icon",bitImage);










            all.put("pazartesi",pazartesi);
            all.put("sali",sali);
            all.put("carsamba",carsamba);
            all.put("persembe",persembe);
            all.put("cuma",cuma);
            all.put("cumartesi",cumartesi);
            all.put("pazar",pazar);



        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  all;
    }
}
