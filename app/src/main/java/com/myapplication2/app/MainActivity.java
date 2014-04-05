package com.myapplication2.app;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_crash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String crashString = null;
                crashString.length();
            }
        });
    }
}