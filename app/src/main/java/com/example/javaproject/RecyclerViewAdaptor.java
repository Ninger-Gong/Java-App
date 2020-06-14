package com.example.javaproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder> {

    private ArrayList<Vehicle> mostViewedVehciles = new ArrayList<Vehicle>();
    private Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_layout,parent,
                false);
        return new ViewHolder(view);
    }


    public RecyclerViewAdaptor(Context mContext, ArrayList<Vehicle> mostViewedVehciles) {
        this.mostViewedVehciles = mostViewedVehciles;
        this.mContext = mContext;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        final Vehicle currentVehicle = mostViewedVehciles.get(position);
        String imageFile = getImageName(currentVehicle);

        final int i = this.mContext.getResources().getIdentifier(imageFile, "drawable",
                mContext.getPackageName());

        holder.vehicleImage.setImageResource(i);


        holder.name.setText(currentVehicle.getMake() + " " + currentVehicle.getModel());

        holder.vehicleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,detailsActivity.class);
                intent.putExtra("vehicleVisitedTimes",currentVehicle.getVistedTims());
                intent.putExtra("vehicleModel", currentVehicle.getModel());
                intent.putExtra("vehicleMake",currentVehicle.getMake());
                intent.putExtra("vehiclePrice",currentVehicle.getPrice());
                intent.putExtra("vehicleEngine",currentVehicle.getEngineSize());
                intent.putExtra("vehicleYear",currentVehicle.getYear());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mostViewedVehciles.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
            CircleImageView vehicleImage;
            TextView name;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                vehicleImage = itemView.findViewById(R.id.most_viewed_image);
                name = itemView.findViewById(R.id.most_viewed_name);
            }
        }
    private String getImageName(Vehicle currentVehcile ){
        String currentMode = currentVehcile.getModel();
        String fileName = currentMode + "_1";
        return fileName;
    }
}
