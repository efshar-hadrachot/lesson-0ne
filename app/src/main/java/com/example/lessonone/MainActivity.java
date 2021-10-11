package com.example.lessonone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.widget.Button;

import com.example.lessonone.ui.login.LoginActivity;

public class MainActivity extends Activity {
    private Intent dataIntent;
    private Intent loginIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineTheIntent();
        defineIntentWithBundle();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.run_print_to_con);
        button.setOnClickListener(msg -> {
            Snackbar.make(msg, "so some work", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            //runPrintToConsoleCommand();
            loginIntent = new Intent(this,LoginActivity.class);
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
        });
    }


    private void defineTheIntent(){
        dataIntent = new Intent(this, PrintData.class);
        dataIntent.putExtra("name","eldad");
        dataIntent.putExtra("age",45);

    }
    private void defineIntentWithBundle(){
        Bundle userInfo = new Bundle();
        userInfo.putString("First Name","Eldad");
        userInfo.putString("Sir Name","Fertouk");
        userInfo.putString("Rank","Major");
        userInfo.putInt("ID-Civil",987456321);
        userInfo.putString("Job:","lamlam");
        Intent fragIntent = new Intent(this, LoginActivity.class);
        fragIntent.putExtras(userInfo);

    }

    protected void runPrintToConsoleCommand(){
        startActivity(dataIntent);
    }

}