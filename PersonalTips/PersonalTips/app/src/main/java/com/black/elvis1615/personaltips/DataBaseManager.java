package com.black.elvis1615.personaltips;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;

/**
 * Created by Elvis on 08/01/15.
 */
public class DataBaseManager {
    public static final String TABLA_NAME="tips";

    public static final String CN_ID="_id";
    public static final String CN_LENGUAJE="lenguaje";
    public static final String CN_TITLE="Titulo";
    public static final String CN_CONTENIDO="Contenido";

    // create table contactos(
    //                          _id integer key autoincrement,
    //                          nombre text not null,
    //                          telefono text)

    public static  final String CREATE_TABLE="create table " +TABLA_NAME+" ("
            + CN_ID+ " integer primary key autoincrement,"
            + CN_LENGUAJE +" text not null,"
            + CN_TITLE + " text not null,"
            +CN_CONTENIDO+" text not null);";

    private  DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {

        helper=new DbHelper(context);
        db=helper.getWritableDatabase();

    }

    private ContentValues generarContentValues(String lenguaje, String titulo, String contenido)
    {
        ContentValues valores=new ContentValues();
        valores.put(CN_LENGUAJE,lenguaje);
        valores.put(CN_TITLE,titulo);
        valores.put(CN_CONTENIDO,contenido);

        return valores;
    }

    public void insertar(String lenguaje, String titulo, String contenido)
    {


            db.insert(TABLA_NAME,null,generarContentValues(lenguaje,titulo,contenido));

    }

    public void insertar2(String lenguaje, String titulo, String contenido)
    {

    String consulta="insert into "+TABLA_NAME+" values('"+lenguaje+"','"+titulo+"','"+contenido+"')";

        try
        {
            db.execSQL(consulta);
        }
        catch (Exception e)
        {

        }


    }

    public void eliminar(String id)
    {
        //tabla,clausula
        try {
            db.delete(TABLA_NAME, CN_ID + "=?", new String[]{id});
        }
        catch (Exception e)
        {

        }

    }

    public void modificar(String id,String lenguaje,String titulo,String contenido)
    {
        try {
            //tabla,clausura where
            db.update(TABLA_NAME, generarContentValues(lenguaje, titulo, contenido), CN_ID + "=?", new String[]{id});
        }
        catch (Exception e)
        {

        }

    }

    public Cursor CargarDatos()
    {
        String [] colunmas=new String[]{CN_ID,CN_LENGUAJE,CN_TITLE,CN_CONTENIDO};
        //
        return db.query(TABLA_NAME,colunmas,null,null,null,null,null);


    }

    public Cursor buscarcodigo(String id)
    {

        String [] colunmas=new String[]{CN_ID,CN_LENGUAJE,CN_TITLE,CN_CONTENIDO};

        return db.query(TABLA_NAME,colunmas,CN_ID+"=?",new String[]{id},null,null,null);

    }


}
