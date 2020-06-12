package com.example.project2;

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

public class secondActivity extends AppCompatActivity {

    private static final String TAG = "secondActivity";
    final ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary2);


        ListView categoryListView = (ListView) findViewById(R.id.product_list_view);

        Intent thisIntent = getIntent();
        String message = thisIntent.getStringExtra("selectedCategory");
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        Hatchback bmw = new Hatchback("BMW", "Hatchback", "x1", 2012, 1500, 24000);
        Hatchback bmw3 = new Hatchback("BMW", "Hatchback", "x1", 2012, 1500, 24000);



        vehicleArrayList.add(bmw);
        vehicleArrayList.add(bmw3);

        ArrayList<Vehicle> displayedList = new ArrayList<Vehicle>();

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
                listIntent.putExtra("secondaryCategory", vehicleArrayList.get(position).getModel());
                startActivity(listIntent);
            }
        });



    }
    public ArrayList<Vehicle> getMethod(){
        return vehicleArrayList;
    }


}
