package com.example.javaproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;



public class categoryListAdaptor extends ArrayAdapter {

    int mLayoutID;
    List<Vehicle> mNumbers;
    Context mContext;

    public categoryListAdaptor(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        mLayoutID = resource;
        mContext = context;
        mNumbers = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get a reference to the current ListView item
        View currentListViewItem = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if (currentListViewItem == null) {
            currentListViewItem = LayoutInflater.from(getContext()).inflate(mLayoutID, parent, false);
        }
        //Get the Number object for the current position
        Vehicle currentNumber = mNumbers.get(position);

        TextView modelTextView = (TextView) currentListViewItem.findViewById(R.id.list_text_view);
        modelTextView.setText(currentNumber.getModel());

        TextView engineTextView = (TextView) currentListViewItem.findViewById(R.id.list_engine_size);
        engineTextView.setText(currentNumber.getType());

        TextView priceTextView = (TextView) currentListViewItem.findViewById(R.id.list_price_tag);
        priceTextView.setText(currentNumber.getMake());

        return currentListViewItem;
    }
}
