package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button mainBtn, decrementBtn, resetBtn, transition_calc;

    EditText nameChange;
    long score = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mainText = findViewById(R.id.mainText);
        mainBtn = findViewById(R.id.main_btn);
        decrementBtn = findViewById(R.id.decrement_btn);
        resetBtn = findViewById(R.id.reset_btn);
        transition_calc = findViewById(R.id.transition_calc);
        nameChange = findViewById(R.id.edit_name);


        transition_calc.setOnClickListener(v->{
            Intent intent = new Intent(this, MainActivity2.class);

            String temp=nameChange.getText().toString();
            intent.putExtra("Hello", temp);
            startActivity(intent);
        });
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });

        decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_calculator) {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_list1) {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_list2) {
            Intent intent = new Intent(this, MainActivity4.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.action_main){
            Intent intent = new Intent(this, MainActivity5.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private void updateScoreText() {
        String quantityString = getResources().getString(R.string.button_clicks);
        String formattedString = String.format(quantityString, score);
        mainText.setText(formattedString);
    }

    private void increment() {
        score++;
        updateScoreText();
    }

    private void decrement() {
        if (score > 0) {
            score--;
            updateScoreText();
        }
    }

    private void reset() {
        score = 0;
        updateScoreText();
    }
}