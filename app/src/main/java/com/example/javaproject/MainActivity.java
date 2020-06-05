package com.example.javaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        final CardView numbersCardView = (CardView) findViewById(R.id.card_view_1);
        numbersCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(getBaseContext(), Numberctivity2.class);
                numbersIntent.putExtra("MessageFromMainActivity","This Message come from Main Activity");
                startActivity(numbersIntent);
            }
        });
    }


    public void showNumbersActivity(View v){
        Intent numbersIntent = new Intent(this, Numberctivity2.class);
        startActivity(numbersIntent);
    }
}