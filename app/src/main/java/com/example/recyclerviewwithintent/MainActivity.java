package com.example.recyclerviewwithintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerviewwithintent.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostAdapter.ListItemClickListener{
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        //TODO for staggered layout
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        //TODO CREATE ARRAY h
        String[] IMAGEARRAY={"/s1cVTQEZYn4nSjZLnFbzLP0j8y2.jpg","/h1B7tW0t399VDjAcWJh8m87469b.jpg",
                "/goEW6QqoFxNI2pfbpVqmXj2WXwd.jpg","/hoUzSMxGu4Bm73EvH6B3iceFwW8.jpg",
                "/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg","/tI8ocADh22GtQFV28vGHaBZVb0U.jpg",
                "/2WCDJDJowWG5zdBuLc4kqMfzETI.jpg", "/xT98tLqatZPQApyRmlPL12LtiWp.jpg"};
        List<Item> ItemList=new ArrayList<Item>();
        for(int i=0;i<IMAGEARRAY.length;i++){
            Item a=new Item(IMAGEARRAY[i]);
            ItemList.add(a);

        }


        recyclerView.setAdapter(new PostAdapter(MainActivity.this,ItemList,this));




    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Toast.makeText(this, "ITEM CLICKED"+clickedItemIndex, Toast.LENGTH_SHORT).show();

    }
}