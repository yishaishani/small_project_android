package com.example.yishaishani.project_finel;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.yishaishani.project_finel.MainActivity.flag;

public class Check_ID extends AppCompatActivity {

    public static int id;
    public static String str;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__id);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_check__id);
        rl.setBackgroundColor((int)(0xFFBBCCAA * Math.random()));

    final MediaPlayer kapaim = MediaPlayer.create(this, R.raw.second_k);
        Button ButtonHomeID = (Button) this.findViewById(R.id.ButtonHomeID);
        ButtonHomeID.setOnClickListener(new View.OnClickListener() {

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

    public void insertID(View v1) {
        TextView textView = (TextView) findViewById(R.id.insertID);
        id = Integer.parseInt(textView.getText().toString());

        showID(v1);
    }

    public void showID(View v)
    {
        TextView textView = (TextView) findViewById(R.id.answerID);
        str = String.valueOf("your ID is: " + id + "" + cal(id));
        textView.setText(str);
        flag = true;

    }




    public static int cal(int ID)  //this function make calculation of the last number of full id.
    {
        boolean flag = true;	  //bool parameter for value of the numbers.
        int digitID, temp, sum=0;
        while (ID > 0)	         //this loop brings the numbers one by one. (right to left)
        {
            digitID = ID % 10;
            ID /= 10;
            if (flag)	        //bool parameter, use for calculation.
            {
                temp = digitID * 2;
                flag = false;
            }
            else
            {
                temp = digitID * 1;
                flag = true;
            }
            sum += (temp % 10) + (temp / 10); //summary of all the numbers.
        }

        sum = 10 - ( sum % 10);		//get the units digit.

        if(sum == 10)
            sum = 0;
        return sum;			//sand the answer back.
    }




}
