package com.black.elvis1615.personaltips;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Consulta extends ActionBarActivity {
    public static String hola0="";
    TextView hola1,hola2;
    EditText hola3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        hola1=(TextView)findViewById(R.id.leng1);
        hola2=(TextView)findViewById(R.id.title1);
        hola3=(EditText)findViewById(R.id.Texto);
        cargar();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consulta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void export(View v)
    {
        finish();
    }

    public void cargar()
    {
        try
        {
            DataBaseManager db= new DataBaseManager(this);
            Cursor c=db.buscarcodigo(hola0);

            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    hola1.setText(c.getString(1));
                    hola2.setText(c.getString(2));
                    hola3.setText(c.getString(3));
                } while(c.moveToNext());
            }
        }
        catch (Exception e)
        {
        finish();
        }
    }
}
