
package com.deitykids.pacademy;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.deitykids.pacademy.adapters.ViewPagerAdapter;

public class MainActivity extends SherlockFragmentActivity
        implements ViewPager.OnPageChangeListener, ActionBar.TabListener
{
    private String[] locations;
    private ViewPager pager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locations = getResources().getStringArray(R.array.locations);
        pager = ((ViewPager) findViewById(R.id.pager));
        configureViewPager();
        configureActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater();
        return true;
    }

    private void configureViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), locations);
        pager.setAdapter(viewPagerAdapter);
        pager.setOnPageChangeListener(this);
    }

    private void configureActionBar() {
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (String location: locations) {
            ActionBar.Tab tab = getSupportActionBar().newTab();
            tab.setText(location);
            tab.setTabListener(this);
            getSupportActionBar().addTab(tab);
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    public void onPageSelected(int position) {
        ActionBar.Tab tab = getSupportActionBar().getTabAt(position);
        getSupportActionBar().selectTab(tab);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        int position = tab.getPosition();
        pager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

}
