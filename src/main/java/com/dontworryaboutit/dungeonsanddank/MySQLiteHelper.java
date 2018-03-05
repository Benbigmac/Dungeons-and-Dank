package com.dontworryaboutit.dungeonsanddank;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "UserDB";

    private static final String TABLE_USERS = "users";


    private static final String KEY_ID = "UserID";
    private static final String KEY_NAME = "Name";
    private static final String KEY_PASSWORD = "Password";

    private static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_PASSWORD};


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE users (" +
                "UserID TEXT PRIMARY KEY, " +
                "Name TEXT, " +
                "Password TEXT, " +
                "created at DATETIME )";
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        this.onCreate(db);
    }

    public void addUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, user.getUserID()); //get ID
        values.put(KEY_NAME, user.getName()); //get Name
        values.put(KEY_PASSWORD, user.getPassword()); //get Password

        db.insert(TABLE_USERS,null,values);

        db.close();

    }

    public User getUser(String id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,   // table
                COLUMNS, //columns name
                "UserID =  ?", // selections
                new String[] {String.valueOf(id)}, //selections args
                null,
                null,
                null,
                null);

        if(cursor != null)
            cursor.moveToFirst();

        User user = new User();
        user.setUserID(cursor.getString(0));
        user.setName(cursor.getString(1));
        user.setPassword(cursor.getString(2));

        Log.d("getUser(" + id+")",user.toString());

        return user;
    }

    public List<User> getAllUsers()
    {
        List<User> users = new LinkedList<User>();

        String query = "Select * FROM " +TABLE_USERS ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        User user = null;
        if(cursor.moveToFirst()){
            do{
                user = new User();
                user.setUserID(cursor.getString(0));
                user.setName(cursor.getString(1));
                user.setPassword(cursor.getString(2));

                users.add(user);
            } while(cursor.moveToNext());
        }

        Log.d("getAllUsers()",users.toString());
        return users;
    }

    public int updateUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, user.getUserID());
        values.put(KEY_NAME, user.getName());
        values.put(KEY_PASSWORD, user.getPassword());

        int i = db.update(TABLE_USERS,
                values,
                KEY_ID+ " = ?",
                new String[] {String.valueOf(user.getUserID())}
                );

        db.close();

        return i;
    }

    public void deleteUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_USERS,
                KEY_ID+ " = ?",
                new String[] {String.valueOf(user.getUserID())});

        db.close();

        Log.d("deleteUser",user.toString());
    }

}