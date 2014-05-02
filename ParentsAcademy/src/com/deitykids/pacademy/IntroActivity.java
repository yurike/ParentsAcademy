package com.deitykids.pacademy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 * Created by Yuri K on 02.05.2014.
 */
public class IntroActivity extends Activity
{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        datePicker.setCalendarViewShown(false);

        Button btnEnter = (Button) findViewById(R.id.button);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(IntroActivity.this, MainActivity.class);

                LocalDate birthdate = new LocalDate (datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                LocalDate now = new LocalDate();
                Days nm_days = Days.daysBetween(birthdate, now);

                Main.getInstance().writeDays(nm_days.getDays());

                Log.d("PW", "year " + datePicker.getYear());
                Log.d("PW", "diffInDays " + nm_days.getDays());

                startActivity(intent);
            }
        });



    }
}