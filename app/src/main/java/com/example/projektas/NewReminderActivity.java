package com.example.projektas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class NewReminderActivity  extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_reminder);
        updateTextMessage(0);

    }

    public void BackToHome(View view) {
        this.finish();
    }

    public void UpdateDatabase(View view){
        Database database = new Database(this);
        EditText text = findViewById(R.id.editText);
        CalendarView day = findViewById(R.id.calendarView);
        EditText time = findViewById(R.id.editText2);
        String dataFormat = new SimpleDateFormat("yyyy MM dd", Locale.forLanguageTag("lt")).format(day.getDate());
        String normalData = dataFormat + " " + time.getText().toString();
        if(!checkDateOptions(normalData) || ifReminderTextIsEmpty(text.getText().toString())){
            updateTextMessage(1);
        }else {
            database.addRemind(new ReminderModel(0, text.getText().toString(),normalData));
            this.finish();
        }
    }

    private boolean checkDateOptions(String normalData){
        if(normalData.length() == 0){
            return false;
        }else {
            String[] dataArray = normalData.split(" ");
            if(dataArray.length != 4){
                return false;
            }
            String[] timeArray = dataArray[3].split(":");
            if (timeArray.length != 3 || dataArray[3].length() != 8) {
                return false;
            }
            if (timeArray[0].length() != 2 || Integer.parseInt(timeArray[0]) > 23 || Integer.parseInt(timeArray[0]) < 0) {
                return false;
            } else if (timeArray[1].length() != 2 || Integer.parseInt(timeArray[1]) > 59 || Integer.parseInt(timeArray[1]) < 0) {
                return false;
            } else if (timeArray[2].length() != 2 || Integer.parseInt(timeArray[2]) > 59 || Integer.parseInt(timeArray[2]) < 0) {
                return false;
            }
        }
        return true;
    }

    private void updateTextMessage(int scenarioId){
        EditText text = findViewById(R.id.editText3);
        text.setEnabled(false);
        if(scenarioId == 0) {
            text.setVisibility(View.GONE);
        }else {
            text.setVisibility(View.VISIBLE);
        }
    }

    private boolean ifReminderTextIsEmpty(String text) {
        if (text.length() == 0) {
            return true;
        }
        return false;
    }
}
