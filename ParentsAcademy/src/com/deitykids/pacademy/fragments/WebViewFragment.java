package com.deitykids.pacademy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import com.deitykids.pacademy.R;

/**
 *
 * Created by Yuri K on 02.05.2014.
 */
public class WebViewFragment extends Fragment
{
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View contentView = inflater.inflate(R.layout.webview, container, false);
        webView = ((WebView) contentView.findViewById(R.id.webView));
        webView.loadUrl("http://danilova.ru/trening/sam/");
        Bundle bundle = getArguments();
//        String label = bundle.getString("label");
//        labelText.setText(label);
        return contentView;
    }
}
