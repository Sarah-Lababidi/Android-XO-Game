package com.saralababidi.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player = 1;
    int countPlayer1 = 0;
    int countPlayer2 = 0;
    TextView tv1;
    TextView tv2;
    Button b00;
    Button b01;
    Button b02;
    Button b10;
    Button b11;
    Button b12;
    Button b20;
    Button b21;
    Button b22;
    String[][] bValues;

    public void clickFunction(View view){
        Button p = (Button)findViewById(view.getId());
        if(p.getText().toString().isEmpty() && player==1){
            p.setText("X");
            player = 2;
        } else {
            if(p.getText().toString().isEmpty()){
                p.setText("O");
                player = 1;
            }
        }
        setButtonValues();
        checkWinner();
    }
    public void setButtonValues (){
        bValues[0][0] = b00.getText().toString();
        bValues[0][1] = b01.getText().toString();
        bValues[0][2] = b02.getText().toString();
        bValues[1][0] = b10.getText().toString();
        bValues[1][1] = b11.getText().toString();
        bValues[1][2] = b12.getText().toString();
        bValues[2][0] = b20.getText().toString();
        bValues[2][1] = b21.getText().toString();
        bValues[2][2] = b22.getText().toString();
    }
    public void checkWinner(){
        if(bValues[0][0]== bValues[0][1] && bValues[0][1]== bValues[0][2] && !bValues[0][0].isEmpty()){
            checkPlayer(bValues[0][0]);
            resetGame();
        } else if(bValues[1][0]== bValues[1][1] && bValues[1][1]== bValues[1][2] && !bValues[1][0].isEmpty()){
            checkPlayer(bValues[1][0]);
            resetGame();
        } else if(bValues[2][0]== bValues[2][1] && bValues[2][1]== bValues[2][2] && !bValues[2][0].isEmpty()){
            checkPlayer(bValues[2][0]);
            resetGame();
        } else if(bValues[0][0]== bValues[1][0] && bValues[1][0]== bValues[2][0] && !bValues[0][0].isEmpty()){
            checkPlayer(bValues[0][0]);
            resetGame();
        } else if(bValues[0][1]== bValues[1][1] && bValues[1][1]== bValues[2][1] && !bValues[0][1].isEmpty()){
            checkPlayer(bValues[0][1]);
            resetGame();
        } else if(bValues[0][2]== bValues[1][2] && bValues[1][2]== bValues[2][2] && !bValues[0][2].isEmpty()){
            checkPlayer(bValues[0][2]);
            resetGame();
        } else if(bValues[0][0]== bValues[1][1] && bValues[1][1]== bValues[2][2] && !bValues[0][0].isEmpty()){
            checkPlayer(bValues[0][0]);
            resetGame();
        } else if(bValues[0][2]== bValues[1][1] && bValues[1][1]== bValues[2][0] && !bValues[0][2].isEmpty()){
            checkPlayer(bValues[0][2]);
            resetGame();
        } else if(!bValues[0][0].isEmpty() && !bValues[0][1].isEmpty() && !bValues[0][2].isEmpty() &&
                  !bValues[1][0].isEmpty() && !bValues[1][1].isEmpty() && !bValues[1][2].isEmpty() &&
                  !bValues[2][0].isEmpty() && !bValues[2][1].isEmpty() && !bValues[2][2].isEmpty()){
            makeToast("It is a DRAW!!");
            resetGame();
        }
    }
    public void checkPlayer(String letter){
        if(letter == "X"){
            countPlayer1++;
            tv1.setText("Player1: "+countPlayer1);
            makeToast("Player 1 is the WINNER!!");
        } else {
            countPlayer2++;
            tv2.setText("Player2: "+countPlayer2);
            makeToast("Player 2 is the WINNER!!");
        }
    }
    public void makeToast(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
    public void resetGame(){
        player = 1;
        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");
        setButtonValues();
    }
    public void reset(View view){
        countPlayer1 = 0;
        countPlayer2 = 0;
        tv1.setText("Player1: "+countPlayer1);
        tv2.setText("Player2: "+countPlayer2);
        resetGame();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         b00 = (Button)findViewById(R.id.button_00);
         b01 = (Button)findViewById(R.id.button_01);
         b02 = (Button)findViewById(R.id.button_02);
         b10 = (Button)findViewById(R.id.button_10);
         b11 = (Button)findViewById(R.id.button_11);
         b12 = (Button)findViewById(R.id.button_12);
         b20 = (Button)findViewById(R.id.button_20);
         b21 = (Button)findViewById(R.id.button_21);
         b22 = (Button)findViewById(R.id.button_22);
         bValues = new String[3][3];

        tv1 = (TextView)findViewById(R.id.textView_p1);
        tv2 = (TextView)findViewById(R.id.textView_p2);
    }
}