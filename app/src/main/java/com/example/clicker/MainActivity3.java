package com.example.clicker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class MainActivity3 extends AppCompatActivity /*implements View.OnClickListener */{
    TextView mainTextView;
    TextView iterator;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter<String> mArrayAdapter;
    TreeSet<String> ListNames = new TreeSet<>();

    Button ok_btn, cnc_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        mainTextView = findViewById(R.id.main_text);
        iterator = findViewById(R.id.main_iterator);
        mainTextView.setText("Set in Java");
        iterator.setText("");
        mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        mainEditText = findViewById(R.id.main_edittext);

        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        mainListView.setAdapter(mArrayAdapter);

        ok_btn = findViewById(R.id.ok_btn);
        cnc_btn = findViewById(R.id.cnc_btn);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = mArrayAdapter.getItem(position);
                mainTextView.setText(selectedItem + " is learning Android development!");
            }
        });

        //  удаления элемент из списка значение
        mainListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick (AdapterView<?> parent, View view, int position, long id) {
                // Удаляем значение и обновляем ListView
                String itemList = mArrayAdapter.getItem(position);
                ListNames.remove(itemList);
                len--;
                refreshListView();
                return true;
            }

        });


        ok_btn.setOnClickListener(oclBtn);
        cnc_btn.setOnClickListener(oclBtn);*/
    }
  /*  int len = 0;
    private boolean isDuplicate(String value) {
        // Проверяем, есть ли значение в списке
        if (ListNames.contains(value)) {
            return true; // Значение является дубликатом
        } else {
            return false; // Значение не является дубликатом
        }
    }

    public void onClick(View v) {
        String enteredText = mainEditText.getText().toString();
        if (!enteredText.isEmpty()) {
            if (isDuplicate(enteredText)) {
                // Введено дублирующееся значение
                mainTextView.setText("Введен дубликат: " + enteredText);
            } else {
                ListNames.add(enteredText);
                len++;
                refreshListView();
            }
        }
    }
    public void showIter(String iter){
        iterator.setText(iter);
    }
    private void refreshListView() {
        mArrayAdapter.clear();
        //  добавления номера к каждому значению списка
        //Iterator<String> iterator = ListNames.iterator();
        int index = 1;
        String i = "";
        while (index <= len) {
            i += String.valueOf(index) + ".\n\n";
            index++;
        }
        showIter(i);
        mArrayAdapter.addAll(ListNames);
        mArrayAdapter.notifyDataSetChanged();
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.ok_btn) {
                mainTextView.setText("Нажата кнопка ОК");
                showOkToast();
            } else if (v.getId() == R.id.cnc_btn) {
                mainTextView.setText("Нажата кнопка Cancel");
                showCncToast();
            }
        }
    };

    private void showOkToast() {
        Toast.makeText(getApplicationContext(), "Нажата кнопка ОК", Toast.LENGTH_LONG).show();
    }

    private void showCncToast() {
        Toast.makeText(getApplicationContext(), "Нажата кнопка Отмена", Toast.LENGTH_LONG).show();
    }*/
}