package com.ataxica.forumconnector.drawmixpaint;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static com.ataxica.forumconnector.drawmixpaint.R.layout.activity_main;

//testing
public class MainActivity extends ActionBarActivity {
    Document doc = null;

    class RetrievedData extends AsyncTask<String, Void, Document> {
        protected Document doInBackground(String... docToParse) {
            try {
                doc = Jsoup.connect("http://forum.drawmixpaint.com/discussions").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
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
        } else if (id == R.id.action_parse) {
            new RetrievedData().execute();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getRecentDiscussions(View v) {
        Intent myIntent = new Intent(MainActivity.this, RecentDiscussionsActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        MainActivity.this.startActivity(myIntent);
    }
}
