package com.example.projektas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenReminderCreationWindow(View view) {
        Intent intent = new Intent("android.intent.action.NewReminderActivity");
        startActivity(intent);
    }

    public void OpenAllReminderWindow(View view) {
        Intent intent = new Intent("android.intent.action.AllRemindersActivity");
       startActivity(intent);
    }

    public void OpenSettingsWindow(View view) {
        Intent intent = new Intent("android.intent.action.SettingsActivity");
        startActivity(intent);
    }

}
