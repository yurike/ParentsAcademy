package com.deitykids.pacademy;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

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


    public void writeAge (String key, Long value)
    {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putLong(key, value);
        editor.commit();
    }




    private SharedPreferences getPrefs()
    {
        if (prefs_ == null)
            prefs_ = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        return prefs_;
    }
}
