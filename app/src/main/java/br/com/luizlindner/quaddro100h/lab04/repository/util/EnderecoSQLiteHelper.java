package br.com.luizlindner.quaddro100h.lab04.repository.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Luiz on 18/07/2017.
 */

public class EnderecoSQLiteHelper extends SQLiteOpenHelper {
    public EnderecoSQLiteHelper(Context context) {
        super(context, "endereco.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE endereco (" +
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "nr_endereco VARCHAR(5) NULL," +
                "ds_complemento VARCHAR(50) NULL" +
                ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
