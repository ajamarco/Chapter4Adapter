package com.example.jamarco.chapter4adapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Car> mCars;
    private CarAdapter mAdapter;
    private ListView mListView;
    final int PADDING = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create an object of the list in the activity_main and
        //set the emptyview to be the empty textview
        mListView = (ListView) findViewById(R.id.list);
        mListView.setEmptyView(findViewById(R.id.empty));

        //create a new arraylist and add the cars
        mCars = new ArrayList<>();
        mCars.add(new Car("Celta",2010,1,true,false));
        mCars.add(new Car("Uno",2012,2,true,true));
        mCars.add(new Car("Fiesta",2009,3,false,true));
        mCars.add(new Car("Gol",2014,0,true,true));
        mCars.add(new Car("Celta",2010,1,true,false));
        mCars.add(new Car("Uno",2012,2,true,true));
        mCars.add(new Car("Fiesta",2009,3,false,true));
        mCars.add(new Car("Gol",2014,0,true,true));
        mCars.add(new Car("Celta",2010,1,true,false));
        mCars.add(new Car("Uno",2012,2,true,true));
        mCars.add(new Car("Fiesta",2009,3,false,true));
        mCars.add(new Car("Gol",2014,0,true,true));

        //set te adapter to the variable
        mAdapter = new CarAdapter(getBaseContext(),mCars);

        //set the header, creating the TextView in the java code
        TextView txtHeader = new TextView(this);
        txtHeader.setBackgroundColor(Color.GRAY);
        txtHeader.setTextColor(Color.WHITE);
        txtHeader.setText(R.string.text_header);
        txtHeader.setPadding(PADDING,PADDING,0, PADDING);

        //add the header to the listview
        mListView.addHeaderView(txtHeader);

        //setting the footer
        final TextView txtFooter = new TextView(this);
        txtFooter.setText(getResources().getQuantityString(R.plurals.text_footer,
                mAdapter.getCount(),mAdapter.getCount(),mAdapter.getCount()));

        txtFooter.setBackgroundColor(Color.LTGRAY);
        txtFooter.setGravity(Gravity.RIGHT);
        txtFooter.setPadding(0, PADDING,PADDING,PADDING);

        //adding the footer to the listview
        mListView.addFooterView(txtFooter);

        //set the adapter to the listView
        mListView.setAdapter(mAdapter);

        //item click event
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Car car = (Car)parent.getItemAtPosition(position);
                if (car != null) {
                    //if the user clicked on a valid car, it will remove it from the list
                    //update the adapter
                    //and update the footer
                    mCars.remove(car);
                    mAdapter.notifyDataSetChanged();
                    txtFooter.setText(getResources().getQuantityString(R.plurals.text_footer,
                            mAdapter.getCount(),mAdapter.getCount(),mAdapter.getCount()));
                }
            }
        });


    }
}
