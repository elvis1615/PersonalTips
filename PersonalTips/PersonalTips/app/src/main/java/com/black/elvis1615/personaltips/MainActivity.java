package com.black.elvis1615.personaltips;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends ActionBarActivity {

    private DataBaseManager manager;
    private Cursor c;
    private ListView lista;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=new DataBaseManager(this);

        lista=(ListView)findViewById(R.id.hola123);
        String [] from = new String[]{manager.CN_ID,manager.CN_TITLE};
        int[] to=new int[]{android.R.id.text1,android.R.id.text2};
        c=manager.CargarDatos();
        adapter=new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,c,from,to,0);
        lista.setAdapter(adapter);

    }


    public void open(View v)
    {
        EditText hola1=(EditText)findViewById(R.id.hola12);
        Consulta.hola0= hola1.getText().toString();
        Intent hello=new Intent(this,Consulta.class);
        startActivity(hello);
    }

    public void insert(View v)
    {
        Intent hello=new Intent(this,InsertarDatos.class);
        startActivity(hello);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void search(View  v)
    {


    }

}
