package com.example.project2;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project2.secondActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends secondActivity {
    SearchView mySearch;
    ListView myListView;

    ArrayList<Vehicle> vehicleArrayList;
    ArrayAdapter<Vehicle> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mySearch = (SearchView)findViewById(R.id.searchView);
        myListView =(ListView)findViewById(R.id.search_list);

        ArrayList<Vehicle> vehicleArrayList = super.getMethod();

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,vehicleArrayList);
        myListView.setAdapter(adapter);

        mySearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }
}

