package com.example.hwhong.sqlitewithasynctask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by hwhong on 9/13/16.
 */
public class Task extends AsyncTask<String, Void, String> {

    Context ctx;

    public Task(Context context) {
        ctx = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {

        String string = strings[0];
        SQLiteHelper helper = new SQLiteHelper(ctx);

        if(string.equals("add_info")) {

            String name = strings[1];
            String employer = strings[2];

            SQLiteDatabase database = helper.getWritableDatabase();
            helper.addInformation(database, name, employer);

            return "A row of data is inserted";

        }


        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String string) {
        Toast.makeText(ctx, string, Toast.LENGTH_SHORT).show();
    }
}
