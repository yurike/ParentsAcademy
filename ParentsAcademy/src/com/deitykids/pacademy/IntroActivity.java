package com.deitykids.pacademy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Yuri K on 02.05.2014.
 */
public class IntroActivity extends Activity
{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        Button btnEnter = (Button) findViewById(R.id.button);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });
    }
}