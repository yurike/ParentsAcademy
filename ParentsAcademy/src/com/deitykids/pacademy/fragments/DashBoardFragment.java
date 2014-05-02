package com.deitykids.pacademy.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.deitykids.pacademy.Main;
import com.deitykids.pacademy.R;
import com.parse.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yuri K on 02.05.2014.
 */
public class DashBoardFragment extends Fragment {
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.ribbon, container, false);
        listView = ((ListView) contentView.findViewById(R.id.listView));



        Parse.initialize(this.getActivity(), "WJMwgRglIhf4V5RkaN6RZAEDRcFPCGahjhC1g4UK", "YVkFR3KLHPGG2ltB2gYo3UnCXcZkdDq4Jz76zC2h");
        getAdminFeed();

        return contentView;
    }

    private void setContent(String[] values) {
        try {
//            final ArrayList<String> alist = new ArrayList<String>();
//            Collections.addAll(alist, values);

//            values = new String[] { "Android", "iPhone", "WindowsMobile",
//                    "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                    "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
//                    "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
//                    "Android", "iPhone", "WindowsMobile" };

            final ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < values.length; ++i) {
                list.add(values[i]);
            }
            final StableArrayAdapter adapter = new StableArrayAdapter(this.getActivity(),
                    android.R.layout.simple_list_item_1, list);

            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, alist);
            listView.setAdapter(adapter);
        }catch(Exception e){
            Log.e("RecommendApp", "");
        }
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }


    private void getAdminFeed()
    {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("AdminFeed");
        query.setCachePolicy(ParseQuery.CachePolicy.NETWORK_ELSE_CACHE);

        int age = Main.getInstance().getYears();
        query.whereGreaterThan("ageFrom", age-1);
//        query.whereEqualTo("age", age+1);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> appList, ParseException e) {
                if (e == null) {
                    String[] pApps = new String[appList.size()];
                    int i = 0;
                    pApps[i++] = "1st line"; // hack!
                    for (ParseObject app : appList) {

                        try {
                            String txt = " ".concat(app.getString("text"));
                            //Log.d("PW", txt);
                            pApps[i++] = txt;
                        } catch (Exception e1) {
                            Log.e("PW", "Error: " + e1.getMessage());
                        }
                    }
                    setContent(pApps);
                } else {
                    Log.d("RecommendApp", "Error: " + e.getMessage());
                }
            }
        });
    }
}
