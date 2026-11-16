package com.mgonzalz.basicapp.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteManager extends SQLiteOpenHelper {
    //Clase abstracta que declara métodos abstractos, hay que darle a Import Methods para cargarlos sobre la línea de arriba.
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crea la base de datos, definir tablas de la BBDD y la relación entre las diferentes tablas

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Cuando cambiamso de versión de BBDD, modificar la base de datos sin borrar los datos.
    }
}
