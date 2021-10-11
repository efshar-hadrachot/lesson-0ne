package com.example.lessonone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;


public class PrintData extends Activity implements View.OnClickListener {

    private Bundle userData ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_data);
        ((FloatingActionButton)findViewById(R.id.killAppWithStyle)).setOnClickListener(this);
        setUserDataContiner();

    }

    @Override
    protected void onStart() {
        super.onStart();
        unPackDataFromBundleToContainer(); //בדרך כלל נבחר לקרוא לפונקציה מאחזרת מידע, עם קידומת get השמות הכתובים להמחשה
    }

    private void setUserDataContiner(){
        userData = getIntent().getExtras();
    }
    private void unPackDataFromBundleToContainer(){
        String firstName = userData.getString("First name");
        int civilId = userData.getInt("ID-Civil");
        String sirName = userData.getString("Sir name");
        String jobDescription = userData.getString("Job:");
        String rank = userData.getString("Rank");
        String fullName = firstName + " " + sirName;
        System.out.print(fullName);
        System.out.println(rank);
        System.out.println(jobDescription);
        System.out.println(civilId);
    }

    private void runSecondAction(){
        Intent someMoreAction = new Intent(this, PrintMoreData.class);
        someMoreAction.putExtra("color","BLUE");
        startActivity(someMoreAction);
    }

    @Override
    protected void onDestroy() {
        System.out.println("BYE BYE ");
        super.onDestroy();
        System.out.println("BYE");
        finish();
    }

    @Override
    public void onClick(View view) {
        runSecondAction();
    }
}