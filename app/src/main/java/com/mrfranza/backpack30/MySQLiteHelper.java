package com.mrfranza.backpack30;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MySQLiteHelper extends SQLiteOpenHelper {

    //versione del database
    private static final int DATABASE_VERSION = 1;
    //nome dell database
    private static final String DATABASE_NAME = "zaino";

    //creo tabella contatti
    private static final String TABLE_SETTIMANA = "Settimana";
    private static final String KEY_ID = "id";
    private static final String KEY_CONTENT = "contenuto";

    private static final String[] COLUMNS = {KEY_ID,KEY_CONTENT};

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACT_TABLE = "CREATE TABLE Settimana ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "contenuto TEXT)";

        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Settimana");
        this.onCreate(db);
    }


    //aggiungi un contatto
    public void Aggiungi(String name,int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        db.delete(TABLE_SETTIMANA,KEY_ID + " = ?", new String[]{String.valueOf(id)});

        values.put(KEY_ID,id);
        values.put(KEY_CONTENT, name);
        db.insert(TABLE_SETTIMANA, null, values);
        db.close();
    }

    public String DAI(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  contenuto FROM " + TABLE_SETTIMANA+" WHERE id = '"+id+"'";

        Cursor curs=db.rawQuery(query,null);
        if(curs.getCount()==1) {
            while(curs.moveToNext()) {
                return curs.getString(0);
            }
        }
        curs.close();
        db.close();
        return "null";
    }


    //elimina un contatto
    public void Elimina(String nome) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SETTIMANA, KEY_CONTENT + " = ?", new String[]{String.valueOf(nome)}); //selections args
    }


    //elimina tutti i contatti
    public void Clear(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_SETTIMANA;
        db.execSQL(query);
        db.close();
    }


    //trova un contatto e restituisce vero se lo trova / falso se non lo trova
    public boolean Find(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  contenuto FROM " + TABLE_SETTIMANA+" WHERE id = '"+id+"'";
        Cursor curs=db.rawQuery(query,null);
        if(curs.getCount()==1) {
            curs.close();
            db.close();
            return true;
        }
        curs.close();
        db.close();
        return false;
    }

}
