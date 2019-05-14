package com.example.projektas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE = "reminders.db";
    private static final String TABLE = "reminder";
    private static final String ID = "ID";
    private static final String TEXT = "Remind_text";
    private static final String TIME = "Time";

    public Database (Context context){
        super (context, DATABASE, null, 1);
       // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="Create table " + TABLE + "("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TEXT+" TEXT, "+TIME+" TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="DROP TABLE IF EXISTS "+ TABLE;
        db.execSQL(query);
    }

    public long addRemind(ReminderModel reminderModel){
        SQLiteDatabase database =this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEXT,reminderModel.getText());
        values.put(TIME, reminderModel.getDate());

        long idValue = database.insert(TABLE,null,values);
        database.close();
        return idValue;
    }

    public ReminderModel getReminder(int id){
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.query(TABLE,new String[] {ID,TEXT, TIME},ID + "=?",new String[]{String.valueOf(id)},null,null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }

        ReminderModel record = new ReminderModel(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

        cursor.close();
        database.close();
        return record;
    }

    public ArrayList<ReminderModel> getAll(){
        ArrayList<ReminderModel> arrayList = new ArrayList<>();

        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "Select * from "+TABLE + " ORDER BY " + TIME;
        Cursor cursor = database.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                ReminderModel reminderModel = new ReminderModel(Integer.parseInt(cursor.getString(0)), cursor.getString(1),cursor.getString(2));
                arrayList.add(reminderModel);
            } while(cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return arrayList;
    }

    public void deleteRowById(ReminderModel model){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE,ID + "=?",new String[]{String.valueOf(model.getId())});
        database.close();
    }

//    public void setInfo(int time, int checked){
//        if(false) {
//            deleteAllFromSettings();
//        }
//        SQLiteDatabase database =this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put("checked",time);
//        values.put("time",checked);
//
//        database.insert("settings",null,values);
//        database.close();
//    }
//
//    private void deleteAllFromSettings(){
//        SQLiteDatabase database = this.getWritableDatabase();
//        String query = "delete from settings";
//        database.execSQL(query);
//        database.close();
//    }
//
//    public Pair<String,Integer> getInfoData(){
//        SQLiteDatabase database = this.getReadableDatabase();
//        String selectQuery = "Select * from settings";
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        Pair<String,Integer> info = new Pair<>(null,null);
//        if(cursor.moveToFirst()){
//            do {
//                 info = new Pair<>(cursor.getString(0), Integer.parseInt(cursor.getString(1)));
//            } while(cursor.moveToNext());
//        }
//        cursor.close();
//        database.close();
//        return info;
//    }
//
//    private boolean ifDatabaseIsEmpy(){
//       SQLiteDatabase database = this.getReadableDatabase();
//        Cursor mCursor =  database.rawQuery("SELECT * FROM setttings",null);
//
//        if (mCursor.moveToFirst())
//        {
//           database.close();
//           return false;
//
//        } else
//        {
//            database.close();
//          return true;
//        }
//    }
}

