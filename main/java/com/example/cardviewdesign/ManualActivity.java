package com.example.cardviewdesign;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class ManualActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter adapter;
    ArrayList<String> list1;
    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
        lv=(ListView)findViewById(R.id.list);
        sv=(SearchView)findViewById(R.id.Search);
        list1= new ArrayList<String>();
        list1.add("Zoho");
        list1.add("Infosys");
        list1.add("Microsoft");
        list1.add("Google");
        list1.add("Amazon");
        list1.add("Facebook");
        list1.add("Oracle");
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, (List) list1);
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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



