package com.deitykids.pacademy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.deitykids.pacademy.R;

/**
 *
 * Created by Yuri K on 02.05.2014.
 */
public class FeedBackFragment extends Fragment
{
    private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View contentView = inflater.inflate(R.layout.feedback, container, false);
        editText = ((EditText) contentView.findViewById(R.id.editText));

//        Bundle bundle = getArguments();
//        String label = bundle.getString("label");

        editText.setText("Feedback");
        return contentView;
    }
}
