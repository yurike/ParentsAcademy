package com.deitykids.pacademy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.deitykids.pacademy.Main;
import com.deitykids.pacademy.R;

/**
 *
 * Created by Yuri K on 02.05.2014.
 */
public class ForumWebViewFragment extends Fragment
{
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View contentView = inflater.inflate(R.layout.webview, container, false);
        webView = ((WebView) contentView.findViewById(R.id.webView));
        final int years = Main.getInstance().getYears();
        if (years <= 1) {
            webView.loadUrl("http://forum.littleone.ru/forumdisplay.php?f=14");
        } else if (years <= 3) {
            webView.loadUrl("http://forum.littleone.ru/forumdisplay.php?f=19");
        } else {
            webView.loadUrl("http://forum.littleone.ru/forumdisplay.php?f=37");
        }
        return contentView;
    }
}
