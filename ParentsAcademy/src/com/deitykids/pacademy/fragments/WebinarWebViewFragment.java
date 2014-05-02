package com.deitykids.pacademy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import com.deitykids.pacademy.Main;
import com.deitykids.pacademy.R;

/**
 *
 * Created by Yuri K on 02.05.2014.
 */
public class WebinarWebViewFragment extends Fragment
{
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View contentView = inflater.inflate(R.layout.webview, container, false);
        webView = ((WebView) contentView.findViewById(R.id.webView));
        final int years = Main.getInstance().getYears();
        if (years < 2) {
            webView.loadUrl("http://danilova.ru/trening/sam/");
        } else {
            webView.loadUrl("http://danilova.ru/shkola_dvuhletki/");
        }
        return contentView;
    }
}
