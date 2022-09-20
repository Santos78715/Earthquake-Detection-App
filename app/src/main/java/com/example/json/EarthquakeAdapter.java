package com.example.json;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    String primaryLocation;
    String locationOffset;
    private static final String LOCATION_SEPARATOR = " of ";
    public EarthquakeAdapter(@NonNull Activity context, ArrayList<Earthquake> resource) {
        super(context, 0,resource);
    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View viewlist = convertView;
        if(viewlist == null){
            viewlist = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_second, parent, false);
        }

        Earthquake earthquake = getItem(position);


        TextView textView = (TextView) viewlist.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMagnitude(earthquake.getMagnitude());
        textView.setText(formattedMagnitude);

        String originalLocation = earthquake.getLocation();
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView primaryLocationView = (TextView) viewlist.findViewById(R.id.Primarylocation);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) viewlist.findViewById(R.id.locationoffset);
        locationOffsetView.setText(locationOffset);

        Date  date = new Date(earthquake.getTime());
        TextView date1 = (TextView) viewlist.findViewById(R.id.time);
        String formattedDate = formatDate(date);
        date1.setText(formattedDate);


        TextView textView2 = (TextView) viewlist.findViewById(R.id.date);
        String formattedtime = formatTime(date);
        textView2.setText(formattedtime);

        return viewlist;
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }


}
