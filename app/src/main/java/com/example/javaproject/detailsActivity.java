package com.example.javaproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class detailsActivity extends secondaryActivity {
    private static final String TAG = "detailsActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        ArrayList<Vehicle> vechicleArrayList = super.getMethod();



        Intent thisIntent = getIntent();
        String vehicleModel = thisIntent.getStringExtra("vehicleModel");
        String vehicleMake = thisIntent.getStringExtra("vehicleMake");
        String vehicleEngineSize = thisIntent.getStringExtra("vehicleEngine");
        String vehicleYear = thisIntent.getStringExtra("vehicleYear");
        String vehiclePrice = thisIntent.getStringExtra("vehiclePrice");
        int vehicleVistedTimes = thisIntent.getIntExtra("vehicleVisitedTimes",0);

        String productName = getProductName(vehicleMake,vehicleModel);
        TextView productNameTextView = findViewById(R.id.Product_name);
        productNameTextView.setText(productName);

        String picture1 = getPictureName(vehicleModel).get(0);
        String picture2 = getPictureName(vehicleModel).get(1);
        String picture3 = getPictureName(vehicleModel).get(2);
        ImageView pictrueView1 = findViewById(R.id.detailView1);
        ImageView pictrueView2 = findViewById(R.id.detailView2);
        ImageView pictrueView3 = findViewById(R.id.detailView3);
        TextView carPrice = findViewById(R.id.product_price);
        TextView carYear = findViewById(R.id.product_year);
        TextView carType = findViewById(R.id.product_type);
        TextView carEngingSize = findViewById(R.id.product_engine_size);


        carPrice.setText("$" + vehiclePrice );
        carYear.setText(vehicleYear);
        carType.setText(vehicleMake);
        carEngingSize.setText(vehicleEngineSize + "cc");



        int i = this.getResources().getIdentifier(
                picture1, "drawable",
                this.getPackageName());
        int j = this.getResources().getIdentifier(
                picture2, "drawable",
                this.getPackageName());
        int k = this.getResources().getIdentifier(
                picture3, "drawable",
                this.getPackageName());


        pictrueView1.setImageResource(i);
        pictrueView2.setImageResource(j);
        pictrueView3.setImageResource(k);




        String fileName = vehicleModel + "_description.txt";

        TextView description = (TextView) findViewById(R.id.product_description);
        String vehicleDescription = "";
        try{
            InputStream fIn = getAssets().open(fileName);
            int size = fIn.available();
            byte[] buffer = new byte[size];
            fIn.read(buffer);
            fIn.close();
            vehicleDescription = new String(buffer);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        description.setText(vehicleDescription);




    }
    private ArrayList<String> getPictureName(String message) {
        ArrayList<String> pictureName = new ArrayList<String>();
        String picture1 = message + "_1";
        String picture2 = message + "_2";
        String picture3 = message + "_3";
        pictureName.add(picture1);
        pictureName.add(picture2);
        pictureName.add(picture3);
        return pictureName;
    }

    private String getProductName(String make, String model){
        String name = make + " " + model.toUpperCase();
        return name;
    }
}
