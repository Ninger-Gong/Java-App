package com.example.project2;

import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MaterialSearchView searchView;
    ListView listView;
    String[] SearchSource = {};
    ArrayAdapter<String> arrayAdapter;
    //Search Button
    private Button SearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Search Button setting
        SearchBtn = (Button)findViewById(R.id.Search_button);
        SearchBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                        startActivity(intent);
                    }
                }
        );

        final List<Number> numbersList = DataProvider.getNumbers();
        NumberAdaptor itemsAdapter = new NumberAdaptor(this,
                R.layout.category_list_view_item,
                numbersList);
        ListView listView = (ListView) findViewById(R.id.category_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),secondActivity.class);

                intent.putExtra("selectedCategory", numbersList.get(position).getMaoriTranslation());
                startActivity(intent);
            }
        });


        final CardView numbersCardView = (CardView) findViewById(R.id.card_view_1);
        numbersCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(getBaseContext(), Numberctivity2.class);
                numbersIntent.putExtra("MessageFromMainActivity","This Message come from Main Activity");
                startActivity(numbersIntent);
            }
        });

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Search here");
        //toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

    }



    public void showNumbersActivity(View v){
        Intent numbersIntent = new Intent(this, Numberctivity2.class);
        startActivity(numbersIntent);
    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_up,R.anim.slide_down);
    }

    public void openSearchActivity(View view) {
        Intent intent= new Intent(this,SearchActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}

