package com.example.projektas;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllRemindersActivity extends Activity {
    private ListView listView;
    private CustomAdapter customAdapter;
    private Database database;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_reminds);
        database = new Database(this);
        customAdapter = new CustomAdapter(this,database.getAll());
        listView = findViewById(R.id.listView);
        listView.setAdapter(customAdapter);
    }

    public void BackToHome(View view) {
        this.finish();
    }

    private void deleteAll(){
        Database database = new Database(this);
        ArrayList<ReminderModel> data = database.getAll();
        for(int i = 0; i < data.size();i++){
            database.deleteRowById(new ReminderModel(data.get(i).getId(),data.get(i).getText(),data.get(i).getDate()));
        }
    }

    public void deleteAllReminds(View view){
        deleteAll();
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }
}
