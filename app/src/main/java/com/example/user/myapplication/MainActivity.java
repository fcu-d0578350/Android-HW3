package com.example.user.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int ABCDEFG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button11 = (Button) findViewById(R.id.button);
        button11.setOnClickListener(setBirthday);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private View.OnClickListener setBirthday = new View.OnClickListener(){
      public void onClick(View v){

          Intent intent = new Intent();
          intent.setClass(MainActivity.this, Main2Activity.class);
          startActivityForResult(intent, ABCDEFG);
      }

    };

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(intent==null){
            return;
        }
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode==ABCDEFG){
            Toast.makeText(MainActivity.this, "Hello " +intent.getStringExtra("iName"),Toast.LENGTH_SHORT ).show();

        }


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
        else if (id == R.id.action_website) {
            Uri uri = Uri.parse("http://www.google.com.tw");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }
}
