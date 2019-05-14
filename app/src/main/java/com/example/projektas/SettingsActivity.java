package com.example.projektas;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;
import android.widget.CheckBox;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends Activity {

 //   private Database database;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
//        database = new Database(this);
//        Pair<String, Integer> pair = database.getInfoData();
//        if(pair.second == 1){
//            CheckBox checkBox = findViewById(R.id.checkBox2);
//            checkBox.setChecked(!checkBox.isChecked());
//       }
    }

    public void checkBoxClicked(View v){
        CheckBox checkBox = (CheckBox)v;
        TextView textView = findViewById(R.id.textView10);
        EditText editText = findViewById(R.id.editText4);
        if(checkBox.isChecked()){
            textView.setVisibility(View.VISIBLE);
            editText.setVisibility(View.VISIBLE);
        }else {
            textView.setVisibility(View.GONE);
            editText.setVisibility(View.GONE);
        }
    }

    public void backToHome(View v){
        this.finish();
    }

    public void saveTimeInfo(View view) {
//        EditText a = findViewById(R.id.editText4);
//        CheckBox checkBox = findViewById(R.id.checkBox2);
//        String text = a.getText().toString();
//        Pair<String, Integer> pair;
//        if(checkBox.isChecked()) {
//            pair = new Pair<>(text,1);
//        }else {
//            pair = new Pair<>(text,0);
//        }
//        database.setInfo(Integer.parseInt(pair.first), pair.second);
    }
}
