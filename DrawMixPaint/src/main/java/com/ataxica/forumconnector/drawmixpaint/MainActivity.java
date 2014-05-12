package com.ataxica.forumconnector.drawmixpaint;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static com.ataxica.forumconnector.drawmixpaint.R.layout.activity_main;

//testing
public class MainActivity extends ActionBarActivity {
    Document doc = null;
    Button btnBlog;
    Button btnBrowse;
    Button btnRecent;
    Button btnSupplyList;
    Button btnUnread;
    Button btnVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        btnBlog = (Button)findViewById(R.id.btnBlog);
        btnBrowse = (Button)findViewById(R.id.btnBrowse);
        btnRecent = (Button)findViewById(R.id.btnRecent);
        btnSupplyList = (Button)findViewById(R.id.btnSupplyList);
        btnUnread = (Button)findViewById(R.id.btnUnread);
        btnVideos = (Button)findViewById(R.id.btnVideos);
        btnBlog.setOnClickListener(onClickListener);
        btnBrowse.setOnClickListener(onClickListener);
        btnRecent.setOnClickListener(onClickListener);
        btnSupplyList.setOnClickListener(onClickListener);
        btnUnread.setOnClickListener(onClickListener);
        btnVideos.setOnClickListener(onClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btnBlog:
                    //DO something
                    break;
                case R.id.btnBrowse:
                    //DO something
                    break;
                case R.id.btnRecent:
                    Intent myIntent = new Intent(MainActivity.this, RecentDiscussionsActivity.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                    break;
                case R.id.btnSupplyList:
                    //DO something
                    break;
                case R.id.btnUnread:
                    //DO something
                    break;
                case R.id.btnVideos:
                    //DO something
                    break;
            }

        }
    };
}
