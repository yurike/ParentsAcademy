package com.deitykids.pacademy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.deitykids.pacademy.Main;
import com.deitykids.pacademy.R;

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

//        Bundle bundle = getArguments();
//      String label = bundle.getString("label");
        final int days = Main.getInstance().getDays();
        String label = "лет " + days/365 + "";
        labelText.setText(label);
        return contentView;
    }
}
