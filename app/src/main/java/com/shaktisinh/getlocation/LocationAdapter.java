package com.shaktisinh.getlocation;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MyViewHolder> {

    private List<MyLocation> locations;

    LocationAdapter(List<MyLocation> locations) {
        this.locations = locations;
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyLocation location = locations.get(position);

        holder.latlong.setText(Html.fromHtml("Lat:<font color='#009688'>" + location.getLatitude() + "</font> Long:<font color='#009688'>" + location.getLongitude() + "</font>"));

        holder.timestamp.setText(location.getTimeStamp());

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView latlong, timestamp;

        MyViewHolder(View view) {
            super(view);
            latlong = (TextView) view.findViewById(R.id.tvLatLong);
            timestamp = (TextView) view.findViewById(R.id.tvTimeStamp);
        }
    }
}
