package com.example.yishaishani.project_finel;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.yishaishani.project_finel.MainActivity.flag4;


public class Gimatria extends AppCompatActivity {
    public static TextView strName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gimatria);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_gimatria);
        rl.setBackgroundColor((int)(0xFFBBCCAA * Math.random()));
        final MediaPlayer kapaim = MediaPlayer.create(this, R.raw.second_k);
        Button BhomeID = (Button) this.findViewById(R.id.BhomeGimatria);
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
    public static int CaclGim(String StrName)
    {
        int sum = 0;

        for (int i = 0 ;i<StrName.length(); i++)
        {
            sum += ( 2 + getSum(StrName.charAt(i)));
        }

        return sum;
    }

    public static int getSum(char tav)
    {

        if (tav==' ')
            return -2;
        if (tav == 'א')
            return -1;
        else if(tav >= 'א' && tav <= 'ט')
        {
            return  tav -= 'א' + 1;
        }
        else if(tav >= 'י' && tav <= 'צ')
        {
            switch(tav)
            {
                case 'י':
                    return 10 - 2;
                case 'ך':
                    return 20 - 2;
                case 'כ':
                    return 20 - 2;
                case 'ל':
                    return 30 - 2;
                case 'ם':
                    return 40 - 2;
                case 'מ':
                    return 40 - 2;
                case 'ן':
                    return 50 - 2;
                case 'נ':
                    return 50 - 2;
                case 'ס':
                    return 60 - 2;
                case 'ע':
                    return 70 - 2;
                case 'ף':
                    return 80 - 2;
                case 'פ':
                    return 80 - 2;
                case 'ץ':
                    return 90 - 2;
                case 'צ':
                    return 90 - 2;
            }

        }
        else if(tav >= 'ק' && tav <= 'ת')
        {
            return  (tav -= 'ק'- 1)* 100 - 2;
        }


        return -1;
    }


    public void Result(View V) {
        strName =  (TextView) findViewById(R.id.GetName);
        TextView textView = (TextView) findViewById(R.id.result);
        //ToastThrower.throwToast(this , String.valueOf(strName.getText().toString()));

        String str = String.valueOf(CaclGim(String.valueOf(strName.getText().toString())));
        textView.setText(str);
        flag4 = true;
    }

}
