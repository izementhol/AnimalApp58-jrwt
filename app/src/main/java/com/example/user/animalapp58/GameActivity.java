package com.example.user.animalapp58;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4;
    ImageView questionImageView;
    ImageButton volumnImageButton;
    MediaPlayer mediaPlayer;//เล่นไฟล์เสียง
    int questionCount = 1;//เก็บข้อคำถาม
    ArrayList<Integer> qID = new ArrayList<Integer>();//ตัวแปร qID ไว้ array สุ่มคำถาม
    String answer;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Intial view
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        questionImageView = findViewById(R.id.imvQuestion);
        volumnImageButton = findViewById(R.id.imbVolumn);

        //แสดงคำถาม

        for (int i=1;i<=questionCount;i++) {
            qID.add(i);
        }
        Collections.shuffle(qID); //กำหนดให้สุ่มคำถาม
        setQuestion(qID.remove(0));
    }//end oncreate Method

    private void setQuestion(int qID)  { // กำหนดข้อคำถามและเฉลยในแต่ละข้อ
        if (qID == 1) {
            answer = "นก";
            questionImageView.setImageResource(R.drawable.bird);
            mediaPlayer = MediaPlayer.create(this,R.raw.bird);

            ArrayList<String> choice = new ArrayList<String>(); // กำหนดการ random choice
            choice.add("นก");
            choice.add("แมว");
            choice.add("สิงโต");
            choice.add("ช้าง");
            Collections.shuffle(choice); // กำหนดให้สุ่มคำตอบ
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));
    }}
    public void playSound(View view) {
        mediaPlayer.start();
    } //end playSound Method
}
