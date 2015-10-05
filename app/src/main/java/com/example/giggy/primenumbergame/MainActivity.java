package com.example.giggy.primenumbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.*;
import android.widget.*;
import java.util.*;
public class MainActivity extends AppCompatActivity {
    private int number=0;
    private int score=0;
    private boolean answer;
    Random rn = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayRandomNumber();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickPrime(View view){
        answer = true;
        verifyAnswer();
        displayRandomNumber();
    }

    public void onClickComposite(View view){
        answer = false;
        verifyAnswer();
        displayRandomNumber();
    }

    private void verifyAnswer() {
        if (!(isPrime(number) ^ answer)) {
            score++;
            Toast.makeText(this, "Congratulations! You are correct!", Toast.LENGTH_SHORT).show();
            displayScore();
        } else {
            score = score - 5;
            Toast.makeText(this, "You are wrong!", Toast.LENGTH_SHORT).show();
            displayScore();
        }
        Toast.makeText(this, "Prev. Number was: " + number, Toast.LENGTH_SHORT).show();
    }

    private boolean isPrime(int value){
        int i;
        for(i = 2; i < 10; i++){
            if(value%i == 0){
                return false;
            }
        }
        return true;
    }

    private void displayRandomNumber(){
        number = rn.nextInt(998) + 2;
        TextView randnum = (TextView) findViewById(R.id.textViewNumber);
        randnum.setText(""+number);
    }

    private void displayScore(){
        TextView scoring = (TextView) findViewById(R.id.scoretextView);
        scoring.setText("Your score is: " + score);
    }
}
