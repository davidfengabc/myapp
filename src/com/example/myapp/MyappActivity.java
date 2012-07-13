package com.example.myapp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyappActivity extends Activity {
		
	ArrayAdapter<String> symbols_adapter;
	ListView symbolsListView;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources();
        String symbols[] = res.getStringArray(R.array.symbols);
        symbolsListView = (ListView)findViewById(R.id.symbol_list);
        symbols_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, symbols);
        symbolsListView.setAdapter(symbols_adapter);
        
        
        
    }
    
}