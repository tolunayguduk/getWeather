package com.tolunayguduk.hava_durumu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Calendar;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String,Object> sonuc;
    ImageView img;
    TextView il,isi,desc,pazartesiDate,saliDate,carsambaDate,persembeDate,cumaDate,cumartesiDate,pazarDate;
    ImageView pazartesiIcon,saliIcon,carsambaIcon,persembeIcon,cumaIcon,cumartesiIcon,pazarIcon;
    TextView pazartesiMin,saliMin,carsambaMin,persembeMin,cumaMin,cumartesiMin,pazarMin;
    TextView pazartesiMax,saliMax,carsambaMax,persembeMax,cumaMax,cumartesiMax,pazarMax;
    String sehir="";
    HashMap map;
    HashMap day1,day2,day3,day4,day5,day6,day7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        sehir = intent.getStringExtra("sehir");

        Calendar now = Calendar.getInstance();
        int a = now.get(Calendar.AM_PM);
        if(a==0){
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.layout);
            constraintLayout.setBackground(getDrawable(R.drawable.day));
        }else {
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.layout);
            constraintLayout.setBackground(getDrawable(R.drawable.night));
        }
        //**********************************************************
        initComponent();
        //**********************************************************
        JsonParse jsonParse = new JsonParse();
        new JsonParse().execute();//jsonParse AsynTask metodumuzu çalıştırdık.

    }
    private void initComponent() {
        img = findViewById(R.id.img);
        il = findViewById(R.id.il);
        isi = findViewById(R.id.sicaklik);
        desc =findViewById(R.id.desc);

        pazartesiDate=findViewById(R.id.pazartesiDate);
        saliDate=findViewById(R.id.saliDate);
        carsambaDate=findViewById(R.id.carsambaDate);
        persembeDate=findViewById(R.id.persembeDate);
        cumaDate=findViewById(R.id.cumaDate);
        cumartesiDate=findViewById(R.id.cumartesiDate);
        pazarDate=findViewById(R.id.pazarDate);

        pazartesiIcon=findViewById(R.id.pazartesiIcon);
        saliIcon=findViewById(R.id.saliIcon);
        carsambaIcon=findViewById(R.id.carsambaIcon);
        persembeIcon=findViewById(R.id.persembeIcon);
        cumaIcon=findViewById(R.id.cumaIcon);
        cumartesiIcon=findViewById(R.id.cumartesiIcon);
        pazarIcon=findViewById(R.id.pazarIcon);

        pazartesiMin=findViewById(R.id.pazartesiMin);
        saliMin=findViewById(R.id.saliMin);
        carsambaMin=findViewById(R.id.carsambaMin);
        persembeMin=findViewById(R.id.persembeMin);
        cumaMin=findViewById(R.id.cumaMin);
        cumartesiMin=findViewById(R.id.cumartesiMin);
        pazarMin=findViewById(R.id.pazarMin);


        pazartesiMax=findViewById(R.id.pazartesiMax);
        saliMax=findViewById(R.id.saliMax);
        carsambaMax=findViewById(R.id.carsambaMax);
        persembeMax=findViewById(R.id.persembeMax);
        cumaMax=findViewById(R.id.cumaMax);
        cumartesiMax=findViewById(R.id.cumartesiMax);
        pazarMax=findViewById(R.id.pazarMax);
    }
    protected class JsonParse extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            getWeatherWeek getWeatherWeek = new getWeatherWeek();
            sonuc = getWeatherWeek.weather(sehir);

            day1= (HashMap) sonuc.get("pazartesi");
            day2= (HashMap) sonuc.get("sali");
            day3= (HashMap) sonuc.get("carsamba");
            day4= (HashMap) sonuc.get("persembe");
            day5= (HashMap) sonuc.get("cuma");
            day6= (HashMap) sonuc.get("cumartesi");
            day7= (HashMap) sonuc.get("pazar");

            getWeatherDaily getWeather = new getWeatherDaily();
            map = getWeather.weather(sehir);

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            img.setImageBitmap((Bitmap) map.get("bitImage"));
            isi.setText(String.valueOf(map.get("result_temp")) + "℃");
            il.setText(map.get("result_city")+" ("+ map.get("result_main") +")");
            desc.setText(map.get("desc").toString());

            pazartesiDate.setText(getDateFromTimeMilis.time(System.currentTimeMillis()));
            int max = (int) Double.parseDouble(day1.get("max").toString());
            max = max-270;
            int min = (int) Double.parseDouble(day1.get("min").toString());
            min = min-270;
            pazartesiMax.setText(String.valueOf(max));
            pazartesiMin.setText(String.valueOf(min));
            pazartesiIcon.setImageBitmap((Bitmap) day1.get("icon"));

            saliDate.setText(getDateFromTimeMilis.time(System.currentTimeMillis()+86400000));
            max = (int) Double.parseDouble(day2.get("max").toString());
            max = max-270;
            min = (int) Double.parseDouble(day2.get("min").toString());
            min = min-270;
            saliMax.setText(String.valueOf(max));
            saliMin.setText(String.valueOf(min));
            saliIcon.setImageBitmap((Bitmap) day2.get("icon"));

            carsambaDate.setText(getDateFromTimeMilis.time(System.currentTimeMillis()+2*86400000));
            max = (int) Double.parseDouble(day3.get("max").toString());
            max = max-270;
            min = (int) Double.parseDouble(day3.get("min").toString());
            min = min-270;
            carsambaMax.setText(String.valueOf(max));
            carsambaMin.setText(String.valueOf(min));
            carsambaIcon.setImageBitmap((Bitmap) day3.get("icon"));

            persembeDate.setText(getDateFromTimeMilis.time(System.currentTimeMillis()+3*86400000));
            max = (int) Double.parseDouble(day4.get("max").toString());
            max = max-270;
            min = (int) Double.parseDouble(day4.get("min").toString());
            min = min-270;
            persembeMax.setText(String.valueOf(max));
            persembeMin.setText(String.valueOf(min));
            persembeIcon.setImageBitmap((Bitmap) day4.get("icon"));

            cumaDate.setText(getDateFromTimeMilis.time(System.currentTimeMillis()+4*86400000));
            max = (int) Double.parseDouble(day5.get("max").toString());
            max = max-270;
            min = (int) Double.parseDouble(day5.get("min").toString());
            min = min-270;
            cumaMax.setText(String.valueOf(max));
            cumaMin.setText(String.valueOf(min));
            cumaIcon.setImageBitmap((Bitmap) day5.get("icon"));

            cumartesiDate.setText(getDateFromTimeMilis.time(System.currentTimeMillis()+5*86400000));
            max = (int) Double.parseDouble(day6.get("max").toString());
            max = max-270;
            min = (int) Double.parseDouble(day6.get("min").toString());
            min = min-270;
            cumartesiMax.setText(String.valueOf(max));
            cumartesiMin.setText(String.valueOf(min));
            cumartesiIcon.setImageBitmap((Bitmap) day6.get("icon"));

            pazarDate.setText(getDateFromTimeMilis.time(System.currentTimeMillis()+6*86400000));
            max = (int) Double.parseDouble(day7.get("max").toString());
            max = max-270;
            min = (int) Double.parseDouble(day7.get("min").toString());
            min = min-270;
            pazarMax.setText(String.valueOf(max));
            pazarMin.setText(String.valueOf(min));
            pazarIcon.setImageBitmap((Bitmap) day7.get("icon"));

            super.onPostExecute(aVoid);
        }
    }
}
