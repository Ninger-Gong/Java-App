package com.example.javaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    protected ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();
    private ArrayList<Vehicle> temporaryList = new ArrayList<Vehicle>();
    private ArrayList<Vehicle> mostViewedVehciles = new ArrayList<Vehicle>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getVehicle();

        final List<Number> numbersList = DataProvider.getNumbers();

        NumberAdaptor itemsAdapter = new NumberAdaptor(this,
                R.layout.category_list_view_item,
                numbersList);
        ListView listView = (ListView) findViewById(R.id.category_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),secondaryActivity.class);
                intent.putExtra("selectedCategory", numbersList.get(position).getMaoriTranslation());
                startActivity(intent);
            }
        });





        List<Integer> viewedTimes = new ArrayList<Integer>();
        for(Vehicle v : vehicleArrayList){
             viewedTimes.add(v.getVistedTims());
        }


        Collections.sort(viewedTimes,Collections.reverseOrder());




        for(int i = 0; i< vehicleArrayList.size(); i++){
            if(viewedTimes.get(i) == vehicleArrayList.get(i).getVistedTims())
            temporaryList.add(vehicleArrayList.get(i));
        }

        for(int i = 0; i<=4; i++){
            mostViewedVehciles.add(temporaryList.get(i));
        }


        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdaptor mostViewedAdaptor = new RecyclerViewAdaptor(this,mostViewedVehciles);
        recyclerView.setAdapter(mostViewedAdaptor);




        // Search Button setting
        ImageView SearchBtn = (ImageView) findViewById(R.id.search_button);
        SearchBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }


    protected void getVehicle(){
        Vehicle bmwX1 = new Vehicle("BMW", "Station Wagon", "x1", "2020", "1499", "59,950");
        Vehicle toyotaHighlander = new Vehicle("Tyota", "Station Wagon", "highlander", "2019", "3456", "48,990");
        Vehicle benzC220 = new Vehicle("Mercedes", "Sedan", "c220d", "2019", "1950", "68,650");
        Vehicle lexusIs300h = new Vehicle("Lexus", "Sedan", "is300h", "2020", "2500", "66,990");
        Vehicle hondaHRV = new Vehicle("Honda", "Station Wagon", "h_rv", "2019", "1800", "27,990");
        Vehicle hondaCivic = new Vehicle("Honda", "Sedan", "civic", "2018", "1500", "33,900");
        Vehicle mazdaCX30 = new Vehicle("Mazda", "Station Wagon", "cx30", "2020", "2500", "44,500");
        Vehicle toyotaCamry = new Vehicle("Toyota", "Sedan", "camry", "2018", "2500", "35,000");
        Vehicle suzukiSwift = new Vehicle("Suzuki", "Hatchback", "swift", "2020", "1300", "22,000");
        Vehicle audiTT = new Vehicle("Audi", "Convertible", "tt", "2019", "2000", "87,900");
        Vehicle bmw320 = new Vehicle("BMW", "Sedan", "i320", "2019", "2000", "72,500");
        Vehicle bmwx5 = new Vehicle("BMW", "Station Wagon", "x5", "2019", "3000", "109,500");
        Vehicle benzGLC = new Vehicle("Mercedes", "Station Wagon", "glc63s", "2019", "4000", "144,500");
        Vehicle miniCooper = new Vehicle("MINI", "Convertible", "cooper", "2017", "2000", "38,990");
        Vehicle mazdaMX5 = new Vehicle("Mazda", "Convertible", "mx5", "2020", "2000", "55,000");
        Vehicle toyotaAqua = new Vehicle("Toyota", "Hatchback", "aqua", "2017", "1500", "13,900");
        Vehicle fordFocus = new Vehicle("Ford", "Hatchback", "focus", "2019", "1500", "23,900");
        Vehicle hondaOdyssey = new Vehicle("Honda", "MPV", "odyssey", "2018", "2400", "42,800");
        Vehicle toyotaAlphard = new Vehicle("Toyota", "MPV", "alphard", "2017", "2500", "79,500");

        //        final ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();


        vehicleArrayList.add(bmwX1);
        vehicleArrayList.add(bmwx5);
        vehicleArrayList.add(benzC220);
        vehicleArrayList.add(benzGLC);
        vehicleArrayList.add(hondaCivic);
        vehicleArrayList.add(hondaHRV);
        vehicleArrayList.add(toyotaAlphard);
        vehicleArrayList.add(toyotaAqua);
        vehicleArrayList.add(toyotaCamry);
        vehicleArrayList.add(toyotaHighlander);
        vehicleArrayList.add(suzukiSwift);
        vehicleArrayList.add(audiTT);
        vehicleArrayList.add(lexusIs300h);
        vehicleArrayList.add(mazdaMX5);
        vehicleArrayList.add(mazdaCX30);
        vehicleArrayList.add(miniCooper);
        vehicleArrayList.add(bmw320);
        vehicleArrayList.add(fordFocus);
        vehicleArrayList.add(hondaOdyssey);


}
    public void showNumbersActivity(View v){
        Intent numbersIntent = new Intent(this, Numberctivity2.class);
        startActivity(numbersIntent);
    }
    
    public void openSearchActivity(View view) {
        Intent intent= new Intent(this,SearchActivity.class);
        startActivity(intent);
    }


}
