package com.deitykids.pacademy.fragments;

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

    private void setContent(String[] value) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, value);
        listView.setAdapter(adapter);
    }

    private static int NOT_RESTRICTED = 100;

    private void getAdminFeed() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("AdminFeed");
        query.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> appList, ParseException e) {
                if (e == null) {
                    int age = Main.getInstance().getYears();
                    String[] pApps = new String[appList.size()];
                    int i = 0;
                    for (ParseObject app : appList) {

                        try {
                            int ageFrom = app.getNumber("ageFrom").intValue();
                            int ageTo = app.getNumber("ageTo").intValue();
                            if ((ageFrom == NOT_RESTRICTED || age >= ageFrom)  && (ageTo == NOT_RESTRICTED || age <= ageTo)) {
                                pApps[i++] = new String(app.getString("text"));
                            }
                        } catch (Exception e1) {
                            Log.d("RecommendApp", "Error: " + e1.getMessage());
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
