package com.example.hwhong.sqlitewithasynctask;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hwhong on 9/13/16.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "employee_table.db";

    //create table employee_table(name text, employer text);
    private static final String QUERY = "create table " + Data.Employee.TABLE_NAME +
            "(" + Data.Employee.NAME + " text," + Data.Employee.EMPLOYER + " text);" ;


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addInformation(SQLiteDatabase db, String name, String employer) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Data.Employee.NAME, name);
        contentValues.put(Data.Employee.EMPLOYER, employer);

        //adds one query of data into the database / one row insertion
        db.insert(Data.Employee.TABLE_NAME, null, contentValues);
    }

}
