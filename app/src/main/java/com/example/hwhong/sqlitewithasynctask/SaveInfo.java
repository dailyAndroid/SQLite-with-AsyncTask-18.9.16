package com.example.hwhong.sqlitewithasynctask;

import android.opengl.EGLDisplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SaveInfo extends AppCompatActivity {

    private EditText nameET, employerET;
    private Button add_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_info);

        nameET = (EditText) findViewById(R.id.name);
        employerET = (EditText) findViewById(R.id.employer);

        add_info = (Button) findViewById(R.id.add_data);

        add_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameET.getText().toString();
                String employer = employerET.getText().toString();

                Task task = new Task(getApplicationContext());
                task.execute("add_info", name, employer);

                finish();
            }
        });
    }
}
