package com.deitykids.pacademy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.deitykids.pacademy.Main;
import com.deitykids.pacademy.R;
import org.joda.time.LocalDate;

/**
 * Created by Yuri K on 02.05.2014.
 */
public class DiaryFragment extends Fragment {

    private Button button;
    private EditText editText;
    private TextView textView;
    private LocalDate now;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.diary, container, false);

        editText = ((EditText) contentView.findViewById(R.id.editText));
        button = (Button) contentView.findViewById(R.id.button);
        textView = (TextView) contentView.findViewById(R.id.textView2);
        final FragmentActivity activity = this.getActivity();
        final int age = Main.getInstance().getYears();
        now = new LocalDate();

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        textView.append("\n\n\n");
                        textView.append(now.toString() + ", возраст " + age + ": ");
                        textView.append(editText.getText());
                        editText.setText("");
                    }
                }
        );
//        Bundle bundle = getArguments();
//        String label = bundle.getString("label");

        return contentView;
    }
}
