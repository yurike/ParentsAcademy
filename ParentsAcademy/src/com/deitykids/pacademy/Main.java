package com.deitykids.pacademy;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *  Created by Yuri K on 02.05.2014.
 */
public class Main extends Application
{
    private SharedPreferences prefs_ = null;

    private static Main _instance = null;

    public static Main getInstance() {
        return _instance;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        _instance = this;
    }


    public void writeDays (int value)
    {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putInt("Days", value);
        editor.commit();
    }

    public int getDays ()
    {
        return getPrefs().getInt("Days", 0);
    }

    public int getYears ()
    {
        int years = getPrefs().getInt("Days", 0) / 365;
        return  years;
    }




    private SharedPreferences getPrefs()
    {
        if (prefs_ == null)
            prefs_ = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        return prefs_;
    }


    /**
     * Get a diff between two dates
     * @param date1 the oldest date
     * @param date2 the newest date
     * @param timeUnit the unit in which you want the diff
     * @return the diff value, in the provided unit
     */
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
}
