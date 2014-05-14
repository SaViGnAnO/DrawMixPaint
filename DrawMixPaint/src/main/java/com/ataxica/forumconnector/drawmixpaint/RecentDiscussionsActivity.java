package com.ataxica.forumconnector.drawmixpaint;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static com.ataxica.forumconnector.drawmixpaint.R.layout.activity_recent_discussions;

/**
 * Created by Brian Savignano on 5/11/2014.
 */
public class RecentDiscussionsActivity extends ActionBarActivity{
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
            Elements discussions = doc.select(".ItemDiscussion");

            for (Element post : discussions) {
                Elements title = post.getElementsByClass("Title");
                Elements author = post.select(".discussionauthor");
                String imageURL = post.select("a > img").attr("src");
                String msg = "Title: "+title.text()+" By: "+author.text()+" "+imageURL;
                Log.d("POST",msg);
            }
            super.onPostExecute(document);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_recent_discussions);
        new RetrievedData().execute();
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
