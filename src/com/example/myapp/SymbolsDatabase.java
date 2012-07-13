package com.example.myapp;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class SymbolsDatabase implements BaseColumns {
	
	private static final String TAG = "SymbolsDatabase";
	
	static final String DATABASE_NAME = "blah.db";
	static final String TABLE_NAME = "symbols";
	static final int DATABASE_VERSION = 1;
	
	// Define columns
	static final String COLUMN_NAME_SYMBOL = "symbol";
	static final String COLUMN_NAME_PRICE = "price";
	static final String COLUMN_NAME_TIME_UPDATED = "modified";
	
	// Handle to a new DatabaseHelper.
    private DatabaseHelper mOpenHelper;
	
	static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context)
		{
			super(context,DATABASE_NAME,null,DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
	                   + _ID + " INTEGER PRIMARY KEY,"
	                   + COLUMN_NAME_SYMBOL + " TEXT,"
	                   + COLUMN_NAME_PRICE + " REAL,"
	                   + COLUMN_NAME_TIME_UPDATED + " INTEGER,"
	                   + ");");
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			// Logs that the database is being upgraded
	           Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
	                   + newVersion + ", which will destroy all old data");

	           // Kills the table and existing data
	           db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

	           // Recreates the database with a new version
	           onCreate(db);
			
		}
	}
}
