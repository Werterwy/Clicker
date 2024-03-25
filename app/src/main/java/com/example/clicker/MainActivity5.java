package com.example.clicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    @Override
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
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}