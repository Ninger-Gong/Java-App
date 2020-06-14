package com.example.javaproject;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends secondaryActivity {
    SearchView mySearch;
    ListView myListView;
    ListView Mysearch;
    ArrayAdapter<Vehicle> adapter;
    ArrayAdapter<Vehicle> Searchadapter;
    final ArrayList<Vehicle> vehicleArrayList = super.getMethod();
    List<Vehicle> ListVeh;
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
                return false;
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



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item,menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searview = (SearchView) searchItem.getActionView();
        final ArrayList<Vehicle> filterList = new ArrayList<>();
        searview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Reset SearchView
                searview.clearFocus();
                searview.setQuery("", false);
                searview.setIconified(true);
                searchItem.collapseActionView();

                if(query != null){
                    query=query.toLowerCase();
                    for(int i=0;i<vehicleArrayList.size();i++){
                        String make = vehicleArrayList.get(i).getMake().toLowerCase();
                        String model = vehicleArrayList.get(i).getModel().toLowerCase();
                        if(make.contains(query)){
                            filterList.add(vehicleArrayList.get(i));
                        }else if(model.contains(query)){
                            filterList.add(vehicleArrayList.get(i));
                        }
                    }
                }
                SearchActivity.this.setTitle(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Vehicle> filter(String s){
        ArrayList<Vehicle> filterList = new ArrayList<>();
        if(s!=null){
            s=s.toLowerCase();
            for(int i=0;i<vehicleArrayList.size();i++){
                String make = vehicleArrayList.get(i).getMake().toLowerCase();
                String modeltype = vehicleArrayList.get(i).getModel().toLowerCase();
                if(make.contains(s)){
                    filterList.add(vehicleArrayList.get(i));
                }else if(modeltype.contains(s)){
                    filterList.add(vehicleArrayList.get(i));
                }
            }
        }
        return filterList;
    }
}
