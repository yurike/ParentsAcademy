package com.deitykids.pacademy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.deitykids.pacademy.Main;
import com.deitykids.pacademy.R;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 *
 * Created by Yuri K on 02.05.2014.
 */
public class DashBoardFragment extends Fragment
{
    private TextView labelText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View contentView = inflater.inflate(R.layout.fragment_sample, container, false);
        labelText = ((TextView) contentView.findViewById(R.id.label_text));

        Parse.initialize(this.getActivity(), "WJMwgRglIhf4V5RkaN6RZAEDRcFPCGahjhC1g4UK", "YVkFR3KLHPGG2ltB2gYo3UnCXcZkdDq4Jz76zC2h");
        getAdminFeed();

        String label = "лет " + Main.getInstance().getYears();
        labelText.setText(label);
        return contentView;
    }

    private void getAdminFeed()
    {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("AdminFeed");

        // TODO implement
    }
}
