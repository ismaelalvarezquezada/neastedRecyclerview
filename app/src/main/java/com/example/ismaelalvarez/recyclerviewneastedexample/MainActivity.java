package com.example.ismaelalvarez.recyclerviewneastedexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        List<TShirt> tShirtList = new ArrayList<>();
        List<TShirtFeature> tShirtFeatureList = new ArrayList<>();

        TShirtFeature tShirtFeature1 = new TShirtFeature("M","BLACK");
        TShirtFeature tShirtFeature2 = new TShirtFeature("L","ORANGE");
        TShirtFeature tShirtFeature3 = new TShirtFeature("XL","RED");
        TShirtFeature tShirtFeature4 = new TShirtFeature("S","WHITE");
        TShirtFeature tShirtFeature5 = new TShirtFeature("XS","YELLOW");
        TShirtFeature tShirtFeature6 = new TShirtFeature("XXL","GREEN");

        tShirtFeatureList.add(tShirtFeature1);
        tShirtFeatureList.add(tShirtFeature2);
        tShirtFeatureList.add(tShirtFeature3);
        tShirtFeatureList.add(tShirtFeature4);
        tShirtFeatureList.add(tShirtFeature5);
        tShirtFeatureList.add(tShirtFeature6);

        TShirt tShirt1 = new TShirt("Palomita1",tShirtFeatureList);
        TShirt tShirt2 = new TShirt("Palomita2",tShirtFeatureList);
        TShirt tShirt3 = new TShirt("Palomita3",tShirtFeatureList);
        TShirt tShirt4 = new TShirt("Palomita4",tShirtFeatureList);
        TShirt tShirt5 = new TShirt("Palomita5",tShirtFeatureList);

        tShirtList.add(tShirt1);
        tShirtList.add(tShirt2);
        tShirtList.add(tShirt3);
        tShirtList.add(tShirt4);
        tShirtList.add(tShirt5);





        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        VerticalRecyclerAdapter adapter = new VerticalRecyclerAdapter(tShirtList);
        mRecyclerView.setAdapter(adapter);
        adapter.SetOnItemClickListener(new HorizontalRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "click " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "long click " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
