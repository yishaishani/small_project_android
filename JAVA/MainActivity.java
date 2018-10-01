package com.example.yishaishani.project_finel;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

import static com.example.yishaishani.project_finel.Check_ID.str;
import static com.example.yishaishani.project_finel.Gimatria.strName;
import static com.example.yishaishani.project_finel.Zodiac.datestr;


public class MainActivity extends AppCompatActivity {
    /* flag for the details, after the user insert details,
     * the main page check the flag and show the details. */

    public static boolean flag = false;
    public static boolean flag2 = false;
    public static int countForSentence = 0;
    public static boolean flag4 = false;
    TextView textViewHome;
    TextView textViewHome1;
    TextView tvUsername;
    /* String for sentence */
    public static final int lengthOfStringSentenc = 5;
    public static String[] senstr = new String[lengthOfStringSentenc];

    private static int RESULT_LOAD_IMAGE = 0;

    public static ImageView imageView;
    public static String picturePath;
    public static Cursor cursor;
    public static Uri selectedImage;
    public static String[] filePathColumn = {MediaStore.Images.Media.DATA};
    public static boolean flag5 = false;

    public static int hour;

    /*flag for wellcome alert*/
    public static boolean flag6 = false;

    Button buttonLoadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = (TextView) findViewById(R.id.chengeSen);
        senstr[0] = "hallo world";
        senstr[1] = "good morning";
        senstr[2] = "nice day";
        senstr[3] = "good afternoon";
        senstr[4] = "nice to see you";
        if (countForSentence > 4)
            countForSentence = 0;
        else {
            t.setText(senstr[countForSentence]);
        }

        if (flag5) {
            imageView = (ImageView) findViewById(R.id.mainPicture);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
        if (hour <= 10 && hour >= 6) {                          //between 6:00 to 10:59.
            ToastThrower.throwToast(this, "בוקר טוב!");
        } else if (hour <= 16 && hour >= 11) {                    //between 11:00 to 16:59.
            ToastThrower.throwToast(this, "צהרים טובים!");
        } else if (currentTime() <= 20 && currentTime() >= 17) { //between 17:00 to 20:59.
            ToastThrower.throwToast(this, "ערב טוב!");
        } else if (currentTime() <= 5 && currentTime() >= 21) {   //between 21:00 to 5:59.
            ToastThrower.throwToast(this, "לילה טוב!");
        }

        buttonLoadImage = (Button) findViewById(R.id.getImage);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        /*next to line set background color to the pages*/
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
        rl.setBackgroundColor((int) (0xFFBBCCAA * Math.random()));
        /* next lines take care of the viewarea od user details,
          if the user fill the details, he will see them in the main page */
        if (flag) {
            textViewHome = (TextView) findViewById(R.id.userID);
            textViewHome.setText(str);
        }
        if (flag2) {
            textViewHome1 = (TextView) findViewById(R.id.userZodiac);
            textViewHome1.setText(datestr);
        }
        if (flag4) {
            tvUsername = (TextView) findViewById(R.id.userName);
            String strMainName = String.valueOf(strName.getText().toString());
            tvUsername.setText(strMainName);

        }
        showWellcomeMessage();
    }


    /* this 3 functions move to other page*/
    public void move_Gim(View view) {
        Intent intent = new Intent(this, Gimatria.class);
        startActivity(intent);
        countForSentence++;
    }

    public void move_Zod(View view) {
        Intent intent = new Intent(this, Zodiac.class);
        startActivity(intent);
        countForSentence++;
    }

    public void move_Che(View view) {
        Intent intent = new Intent(this, Check_ID.class);
        startActivity(intent);
        countForSentence++;
    }

    /* this method get the picture from galery and insert
     * the picture to the imageView on the MainActivity */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            selectedImage = data.getData();

            cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();

            imageView = (ImageView) findViewById(R.id.mainPicture);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            buttonLoadImage.setText("change picture");
            flag5 = true;

        }


    }

    /*this function get the current time for the toast  in the main page*/
    public int currentTime() {
        Calendar rightNow = Calendar.getInstance();
        hour = rightNow.get(Calendar.HOUR_OF_DAY);
        return hour;
    }


    private void showWellcomeMessage() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);

        dialogBuilder.setMessage("           wellcome!" + "\n" + "we hope you enjoy our app");
        dialogBuilder.setPositiveButton("continue", null);
        if (flag6) {
        } else{
            dialogBuilder.show();
            flag6 = true;
        }
    }
}