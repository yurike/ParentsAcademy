package com.deitykids.pacademy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yuri K on 02.05.2014.
 */
public class IntroActivity extends Activity
{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);

        Button btnEnter = (Button) findViewById(R.id.button);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                intent.putExtra("Year", datePicker.getYear());
                intent.putExtra("Month", datePicker.getMonth());
                intent.putExtra("Day", datePicker.getDayOfMonth());

                Date date = new Date(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());

                final long dateDiff = Main.getDateDiff(new Date(), date, TimeUnit.DAYS);
                Main.getInstance().writeDays(dateDiff);
                Log.d("PW", "dates diff " + dateDiff);
                Log.d("PW", "year " + datePicker.getYear());

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
                String formatedDate = sdf.format(date);
                Log.d("PW", "" + formatedDate);

                intent.putExtra("Date", date);

                startActivity(intent);
            }
        });



    }
}