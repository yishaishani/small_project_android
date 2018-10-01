package com.example.yishaishani.project_finel;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.yishaishani.project_finel.MainActivity.flag2;

// TODO: 20/12/2016 מזלות 
public class Zodiac extends AppCompatActivity {
 public static String datestr;
    public static String str2;
    int day;
    int month;
    int Year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_zodiac);
        rl.setBackgroundColor((int)(0xFFBBCCAA * Math.random()));

        final MediaPlayer kapaim = MediaPlayer.create(this, R.raw.second_k);
        Button BhomeID = (Button) this.findViewById(R.id.BhomeZodiac);
        BhomeID.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v7){
                kapaim.start();
                move_Main(v7);
            }
        });
    }
    public void move_Main(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void CalcZodiac(View view2){
        DatePicker simpleDatePicker = (DatePicker)findViewById(R.id.DatePicker);
        month = simpleDatePicker.getMonth() + 1;
        day = simpleDatePicker.getDayOfMonth();
        Year = simpleDatePicker.getYear();



        if      ((month == 12 && day >= 22 && day <= 31) || (month ==  1 && day >= 1 && day <= 19))
        {
            changeStr("Capricorn");
            changePicture(R.mipmap.decm);
        }
        else if ((month ==  1 && day >= 20 && day <= 31) || (month ==  2 && day >= 1 && day <= 17))
           {
               changeStr("Aquarius");
               changePicture(R.mipmap.january);}
        else if ((month ==  2 && day >= 18 && day <= 29) || (month ==  3 && day >= 1 && day <= 19))
              {
                  changeStr("Pisces");
                  changePicture(R.mipmap.feb);}
        else if ((month ==  3 && day >= 20 && day <= 31) || (month ==  4 && day >= 1 && day <= 19))
        {
            changeStr("Aries");
            changePicture(R.mipmap.march);}
        else if ((month ==  4 && day >= 20 && day <= 30) || (month ==  5 && day >= 1 && day <= 20))
        {
            changeStr("Taurus");
            changePicture(R.mipmap.april);}
        else if ((month ==  5 && day >= 21 && day <= 31) || (month ==  6 && day >= 1 && day <= 20))
           {
               changeStr("Gemini");
               changePicture(R.mipmap.may);}
        else if ((month ==  6 && day >= 21 && day <= 30) || (month ==  7 && day >= 1 && day <= 22))
            {
                changeStr("Cancer");
                changePicture(R.mipmap.june);}
        else if ((month ==  7 && day >= 23 && day <= 31) || (month ==  8 && day >= 1 && day <= 22))
        {
            changeStr("Leo");
            changePicture(R.mipmap.july);}
        else if ((month ==  8 && day >= 23 && day <= 31) || (month ==  9 && day >= 1 && day <= 22))
        {
            changeStr("Virgo");
            changePicture(R.mipmap.augost);}
        else if ((month ==  9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22))
        {
            changeStr("Libra");
            changePicture(R.mipmap.sept);}
        else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21))
        {
            changeStr("Scorpio");
            changePicture(R.mipmap.auct); }
        else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21))
        {
            changeStr("Sagittarius");
            changePicture(R.mipmap.nov); }
        flag2 = true;
    }
     //   TextView textView = (TextView) findViewById(R.id.textView5);
     //   String datestr = String.valueOf("your date of birth is: " + day + "/" + (month+1) + "/" + Year);
     //   textView.setText(datestr);
    public void changeStr(String string){
        TextView textView = (TextView) findViewById(R.id.zodiacResult);
        datestr = String.valueOf("Your zodiac is: " + string);
        textView.setText(datestr);
    }
    public void changePicture(int image){
        ImageView imageView = (ImageView) findViewById(R.id.mainPicture);
        int img = image;
        imageView.setImageResource(img);
    }



}

