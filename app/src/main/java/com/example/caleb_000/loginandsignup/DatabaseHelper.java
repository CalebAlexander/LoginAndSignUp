package com.example.caleb_000.loginandsignup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by caleb_000 on 3/19/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "contacts.db";

    private static final String TABLE_NAME = "contacts";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    //SQLiteDatabase db;

    private static final String TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + "(" + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_USERNAME + " TEXT,"
            + COLUMN_PASSWORD + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        //this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        //this.onCreate(db);
        onCreate(db);
    }

    public void insertContact(Contact c) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

//        String query = "SELECT * from " + TABLE_NAME;
//        Cursor cursor = db.rawQuery(query, null);
        //int count = cursor.getCount();

//        String query = "select " + COLUMN_USERNAME
//                + " , " + COLUMN_PASSWORD + " from " + TABLE_NAME;
//        Cursor cursor = db.rawQuery(query, null);

        //values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_USERNAME, c.getUsername());
        values.put(COLUMN_PASSWORD, c.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPassword(String username) {
        SQLiteDatabase db = this.getReadableDatabase();

//        String query = "SELECT " + COLUMN_USERNAME
//                + ", " + COLUMN_PASSWORD
//                + " from " + TABLE_NAME;
//        Cursor cursor = db.rawQuery(query, null);

        Cursor cursor = db.query(TABLE_NAME, new String[] { COLUMN_USERNAME, COLUMN_PASSWORD }, COLUMN_USERNAME + "=?",
                new String[] { username }, null, null, null, null);

        String uname;
        String pass;
        pass = "not found";
        //refactor this to be more readable
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    uname = cursor.getString(0);

                    if (uname.equals(username)) {
                        pass = cursor.getString(1);
                        break;
                    }
                }while(cursor.moveToNext());
            }
        } else {

        }

        return pass;
    }
    public String[] getInfo(String username) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { COLUMN_NAME, COLUMN_EMAIL, COLUMN_USERNAME, COLUMN_PASSWORD,  }, COLUMN_USERNAME + "=?",
                new String[] { username }, null, null, null, null);

        String[] info = new String[4];

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                info[0] = cursor.getString(0);
                info[1] = cursor.getString(1);
                info[2] = cursor.getString(2);
                info[3] = cursor.getString(3);
            }
        } else {

        }
        return info;
    }
}
