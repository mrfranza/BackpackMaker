package com.mrfranza.backpack30;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class weekArrayAdapter extends ArrayAdapter<dayofweek> {

    private Context context;
    private List<dayofweek> rentalProperties;

    //constructor, call on creation
    public weekArrayAdapter(Context context, int resource, ArrayList<dayofweek> objects) {
        super(context, resource, objects);

        this.context = context;
        this.rentalProperties = objects;
    }

    //called when rendering the list
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the property we are displaying
        dayofweek property = rentalProperties.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        @SuppressLint({"InflateParams", "ViewHolder"}) View view = inflater.inflate(R.layout.list_item_franz, null);

        TextView description = view.findViewById(R.id.dayWeekName);
        ImageView image = view.findViewById(R.id.image);

        //set address and description
        String completeAddress = property.getDayName();

        //display trimmed excerpt for description

        String descriptionTrim = property.getDayName();
        description.setText(descriptionTrim);

        /*get the image associated with this property
        int imageID = context.getResources().getIdentifier(property.getImage(), "drawable", context.getPackageName());

        image.setImageResource(imageID);*/

        return view;
    }
}
