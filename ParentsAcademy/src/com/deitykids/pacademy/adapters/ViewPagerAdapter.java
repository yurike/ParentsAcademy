package com.deitykids.pacademy.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.deitykids.pacademy.fragments.*;

/**
 *  Created by Yuri K on 02.05.2014.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter
{
    private String[] locations;

    public ViewPagerAdapter(FragmentManager fm, String[] locations)
    {
        super(fm);
        this.locations = locations;
    }

    public int getCount() {
        return locations.length;
    }

    public Fragment getItem(int position)
    {
        Fragment fragment;// = (position == 0) ? new DashBoardFragment() : new SampleFragment()  ;
        switch (position) {
            case 0 :
                fragment = new DashBoardFragment();
                break;
            case 1 :
                fragment = new WebinarWebViewFragment();
                break;
            case 2 :
                fragment = new ForumWebViewFragment();
                break;
            case 4 :
                fragment = new QuestionFragment();
                break;
            default:
                fragment = new SampleFragment()  ;
        }
        Bundle bundle = new Bundle();
        bundle.putString("label", locations[position]);
        fragment.setArguments(bundle);
        return fragment;
    }
}
