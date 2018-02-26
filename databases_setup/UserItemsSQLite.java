package com.hmkcode.android.model;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ovidiubahnean on 2/10/18.
 */

public class UserItemsSQLite extends SQLiteOpenHelper {

    //private static final String name = "UserItemsSQLite";

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "userItems";

    private static final String TABLE_CH = "ch_data";

    private static final String TABLE_IT = "Items";

    private static final String TABLE_WEAPONS = "Weapons";

    private static final String KEY_ID = "id";
    private static final String KEY_Character_Data = "CHARACTER_DATA";
    private static final String KEY_CREATED_AT = "created at";

    private static final String KEY_ITEMS = "item_id";
    private static final String KEY_ITEM_NAME = "item_name";
    private static final String KEY_ITEM_COST = "item_cost";
    private static final String KEY_ITEM_WEIGHT = "item_weight";

    private static final String KEY_WEAPONS = "weapon_name";
    private static final String KEY_COST = "weapon_cost";
    private static final String KEY_HANDED = "weapon_hand";
    private static final String KEY_DAMAGE = "weapon_damage";
    private static final String KEY_AVAILABILITY = "weapon_available";
    private static final String KEY_CRITMULT = "weapon_critmult";
    private static final String KEY_CRITON = "weapon_criton";
    private static final String KEY_RANGE = "weapon_range";
    private static final String KEY_TYPE = "weapon_type";
    private static final String KEY_LETHAL = "weapon_lethal";

    private static final String CREATE_TABLE_CH = "CREATE TABLE " + TABLE_CH
            +"("+ KEY_ID + " STRING PRIMARY KEY," + KEY_Character_Data +" TEXT,"
            +KEY_CREATED_AT + " DAYTIME" + ")";

    private static final String CREATE_TABLE_ITEMS = "CREATE TABLE "+ TABLE_IT
            +"(" + KEY_ITEMS + " STRING PRIMARY KEY," + KEY_ITEM_NAME + " TEXT,"
            + KEY_ITEM_COST + " INTEGER" + KEY_ITEM_WEIGHT+ " INTEGER"
            + KEY_CREATED_AT + " DATETIME" + ")";

    private static final String CREATE_WEAPONS_TABLE = "CREATE TABLE " + TABLE_WEAPONS
            +"("+ KEY_WEAPONS + " STRING PRIMARY KEY, "+ KEY_COST + " INTEGER"
            + KEY_HANDED + " INTEGER" + KEY_DAMAGE + " STRING" + KEY_AVAILABILITY + "INTEGER"
            + KEY_CRITMULT + " INTEGER" + KEY_CRITON + " " + KEY_RANGE + " INTEGER"
            + KEY_TYPE + " INTEGER" + KEY_LETHAL + " INTEGER";  //there is no boolean in sql


    public UserItemsSQLite(Context context)
    {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_CH);
        db.execSQL(CREATE_TABLE_ITEMS);
        db.execSQL(CREATE_WEAPONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEAPONS);

        onCreate(db);
    }
}
