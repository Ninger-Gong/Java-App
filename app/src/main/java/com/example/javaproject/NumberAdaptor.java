package com.example.javaproject;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NumberAdaptor extends ArrayAdapter {

    int mLayoutID;
    List<Number> mNumbers;
    Context mContext;

    MediaPlayer mediaPlayer;


    public NumberAdaptor(@NonNull Context context, int resource, @NonNull List objects) {
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
        Number currentNumber = mNumbers.get(position);

        //Set the attributed of list_view_number_item views
        ImageView iconImageView = (ImageView) currentListViewItem.findViewById(R.id.category_image_view);
        int i = mContext.getResources().getIdentifier(
                currentNumber.getIconFileName(), "drawable",
                mContext.getPackageName());

        //Setting the icon
        iconImageView.setImageResource(i);

        TextView categoryTextView = (TextView) currentListViewItem.findViewById(R.id.category_text_view);
        categoryTextView.setText(currentNumber.getMaoriTranslation());



        return currentListViewItem;
    }
    }

