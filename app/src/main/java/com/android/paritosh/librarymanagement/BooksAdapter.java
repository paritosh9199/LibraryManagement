package com.android.paritosh.librarymanagement;

/**
 * Created by PARITOSH on 11/10/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class BooksAdapter extends ArrayAdapter<BooksKeeper> {
    public BooksAdapter(Context context, int resource, List<BooksKeeper> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            //convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }
        /*
        TextView messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.nameTextView);
        */

        BooksKeeper message = getItem(position);



        /*
            messageTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            //messageTextView.setText(message.getText());
         */
        //authorTextView.setText(message.getName());

        return convertView;
    }
}
