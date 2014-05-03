package com.deitykids.pacademy.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.deitykids.pacademy.R;

/**
 *
 * Created by Yuri K on 02.05.2014.
 */
public class QuestionFragment extends Fragment
{
    private EditText editText;
    private Button button;
    private RadioGroup group;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View contentView = inflater.inflate(R.layout.question, container, false);
        editText = ((EditText) contentView.findViewById(R.id.editText));
        button = (Button) contentView.findViewById(R.id.button);
        group = (RadioGroup) contentView.findViewById(R.id.radioGroup);
        final FragmentActivity activity = this.getActivity();

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new AlertDialog.Builder(activity)
                                .setTitle("")
                                .setMessage("Ваше сообщение отправлено")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // continue with delete
                                        editText.setText("");
                                        group.clearCheck();
                                    }
                                })
//                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        // do nothing
//                                    }
//                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }
                }
        );
//        Bundle bundle = getArguments();
//        String label = bundle.getString("label");

        return contentView;
    }
}
