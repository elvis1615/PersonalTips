package com.black.elvis1615.personaltips;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class InsertarDatos extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_datos);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_insertar_datos, menu);
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

    public void save(View v)
    {
       DataBaseManager db =new DataBaseManager(this);
        EditText hola=(EditText)findViewById(R.id.Inleng);
        EditText hola2=(EditText)findViewById(R.id.title);
        EditText hola3=(EditText)findViewById(R.id.codigo);
        db.insertar(hola.getText().toString(),hola2.getText().toString(),hola3.getText().toString());
        Intent hello=new Intent(this,MainActivity.class);
        startActivity(hello);
        finish();


    }

    public  void  back(View v)
    {

        Intent hello=new Intent(this,MainActivity.class);
        startActivity(hello);
        finish();

    }
}
