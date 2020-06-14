package com.example.project2;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends secondActivity {
    SearchView mySearch;
    ListView myListView;
    ListView Mysearch;
    ArrayAdapter<Vehicle> adapter;
    ArrayAdapter<Vehicle> Searchadapter;
    private Vehicle Vehicle;
    final ArrayList<Vehicle> vehicleArrayList = super.getMethod();
    List<Vehicle> filtered;
    ArrayList<Vehicle> filteredModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mySearch = (SearchView)findViewById(R.id.searchView);
        myListView =(ListView)findViewById(R.id.search_list);
        Mysearch = (ListView)findViewById(R.id.filtered_list);

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,vehicleArrayList);
        myListView.setAdapter(adapter);



        mySearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filteredModelList = filter(newText);
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        Searchadapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,filteredModelList);
        Mysearch.setAdapter(Searchadapter);


        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent searchIntent = new Intent(getBaseContext(),detailsActivity.class);
                searchIntent.putExtra("secondaryCategory", vehicleArrayList.get(position).getModel());
                startActivity(searchIntent);
            }
        });

        Mysearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent resultIntent = new Intent(getBaseContext(),detailsActivity.class);
                resultIntent.putExtra("secondaryCategory",filteredModelList.get(position).getModel());
                startActivity(resultIntent);
            }
        });

    }
    public ArrayList<Vehicle> filter(String s){
        ArrayList<Vehicle> filterList = new ArrayList<>();
        if(s!=null){
            s=s.toLowerCase();
            for(Vehicle model:vehicleArrayList){
                final String make = Vehicle.getMake().toLowerCase();
                final String modeltype = Vehicle.getModel().toLowerCase();
                if(make.contains(s)){
                    filterList.add(model);
                }else if(modeltype.contains(s)){
                    filterList.add(model);
                }
            }
        }
        return filterList;
    }
}



