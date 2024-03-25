package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView mainText;

    Button Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8,
            Btn9, Btn0, Plus, Minus, Division, Mult, AnsBtn, resetBtn, home_activity, poinBtn;
    String operator = "";

    private int clickCount = 0;

    private static final int MAX_CLICKS = 7;

    double num1 = 0, num2 = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mainText = findViewById(R.id.textView);
        home_activity = findViewById(R.id.home_activity);
        Btn1 = findViewById(R.id.button);
        Btn2 = findViewById(R.id.button2);
        Btn3 = findViewById(R.id.button3);
        Btn4 = findViewById(R.id.button4);
        Btn5 = findViewById(R.id.button5);
        Btn6 = findViewById(R.id.button6);
        Btn7 = findViewById(R.id.button7);
        Btn8 = findViewById(R.id.button8);
        Btn9 = findViewById(R.id.button9);
        Btn0 = findViewById(R.id.button0);
        Plus = findViewById(R.id.Plus);

        Minus = findViewById(R.id.Minus);
        Division = findViewById(R.id.Division);
        Mult = findViewById(R.id.multiply);
        AnsBtn = findViewById(R.id.AnsBtn);
        resetBtn = findViewById(R.id.reset_btn);
        poinBtn = findViewById(R.id.point_btn);

        Bundle arguments = getIntent().getExtras();
        if(arguments != null){
            String name = arguments.get("Hello").toString();
            mainText.setText(name);
        }



        home_activity.setOnClickListener(v -> finish());
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToTextView("1");
            }
        });


        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToTextView("2");
            }
        });

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToTextView("3");
            }
        });

        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToTextView("4");
            }
        });

        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToTextView("5");
            }
        });

        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToTextView("6");
            }
        });

        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToTextView("7");
            }
        });

        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToTextView("8");
            }
        });

        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToTextView("9");
            }
        });

        Btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToTextView("0");
            }
        });
        poinBtn.setOnClickListener(new View.OnClickListener(){
                @Override
        public void onClick(View v) {
            appendToTextView(".");
        }
        });

        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount = 0;
                performOperation("+");
            }
        });

        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount = 0;
                performOperation("-");
            }
        });

        Mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount = 0;
                performOperation("*");
            }
        });

        Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount = 0;
                performOperation("/");
            }
        });

        AnsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount = 0;
                calculate();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount = 0;
                reset();
            }
        });
    }

    private void appendToTextView(String text) {
        if (clickCount >= MAX_CLICKS) {
            Toast.makeText(this, "Вы превысили ограничение на количество нажатий", Toast.LENGTH_SHORT).show();
            return;
        }
        String currentText = mainText.getText().toString();
        mainText.setText(currentText + text);
        clickCount++;
    }

    private void performOperation(String op) {
        clickCount = 0;
        operator = op;
        String currentText = mainText.getText().toString();
        num1 = Double.parseDouble(currentText);
        mainText.setText("");
    }

    private void calculate() {

        clickCount = 0;
        String currentText = mainText.getText().toString();
        num2 = Double.parseDouble(currentText);
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    mainText.setText("Ошибка: деление на ноль");
                    return;
                }
                break;
        }
       /* String res = String.valueOf((result));
        String[] r = res.split("\\.");
        if("0" == r[1]){
            mainText.setText(r[0]);
        }else {
            mainText.setText(String.valueOf(result));
        }*/
        String res = String.valueOf(result);
        int decimalIndex = res.indexOf(".");
        if (decimalIndex != -1) {
            // Найдена десятичная точка, значит число нецелое
            mainText.setText(res);
        } else {
            // Десятичная точка не найдена, значит число целое
            mainText.setText(res);
        }

    }

    private void reset() {
        mainText.setText("");
        operator = "";
        num1 = 0;
        num2 = 0;
        clickCount = 0;
    }
}
