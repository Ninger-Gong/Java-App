package com.example.javaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class secondaryActivity extends MainActivity {

    private static final String TAG = "secondaryActivity";
//    private final ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary2);

        ListView categoryListView = (ListView) findViewById(R.id.product_list_view);

        Intent thisIntent = getIntent();
        String message = thisIntent.getStringExtra("selectedCategory");
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


            final ArrayList<Vehicle> displayedList = new ArrayList<Vehicle>();

            for (int i = 0; i < vehicleArrayList.size(); i++) {
                String currentVehicle = vehicleArrayList.get(i).getType().toString();
                String mess = message;
               if (currentVehicle.equals(message)) {
                    displayedList.add(vehicleArrayList.get(i));
               }
            }




        categoryListAdaptor adaptor = new categoryListAdaptor(this, R.layout.list_activity_layout, displayedList);
        categoryListView.setAdapter(adaptor);


        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent listIntent = new Intent(getBaseContext(),detailsActivity.class);
                displayedList.get(position).setVistedTims();
                listIntent.putExtra("vehicleVisitedTimes",displayedList.get(position).getVistedTims());
                listIntent.putExtra("vehicleModel", displayedList.get(position).getModel());
                listIntent.putExtra("vehicleMake",displayedList.get(position).getMake());
                listIntent.putExtra("vehiclePrice",displayedList.get(position).getPrice());
                listIntent.putExtra("vehicleEngine",displayedList.get(position).getEngineSize());
                listIntent.putExtra("vehicleYear",displayedList.get(position).getYear());



                startActivity(listIntent);
            }
        });
    }

    public ArrayList<Vehicle> getMethod(){
        return vehicleArrayList;
    }
}
