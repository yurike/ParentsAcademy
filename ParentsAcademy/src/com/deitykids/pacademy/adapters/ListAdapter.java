package com.deitykids.pacademy.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by shoo on 5/2/14.
 */
public class ListAdapter extends BaseAdapter {

    private final String[] data;
    private final LayoutInflater inflater;

    public ListAdapter(Activity a, String[] data) {
        this.data = data;
        inflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return data[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return null;// createViewFromResource(position, convertView, parent, mResource);
    }

//    private View createViewFromResource(int position, View convertView, ViewGroup parent,
//                                        int resource) {
//        View view;
//        TextView text;
//
//        if (convertView == null) {
//            view = inflater.inflate(resource, parent, false);
//        } else {
//            view = convertView;
//        }
//
//        try {
//            if (mFieldId == 0) {
//                // If no custom field is assigned, assume the whole resource is a TextView
//                text = (TextView) view;
//            } else {
//                // Otherwise, find the TextView field within the layout
//                text = (TextView) view.findViewById(mFieldId);
//            }
//        } catch (ClassCastException e) {
//            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
//            throw new IllegalStateException(
//                    "ArrayAdapter requires the resource ID to be a TextView", e);
//        }
//
//        String value = data[position];
//
//        text.setText(value);
//
//        return view;
//    }


}
