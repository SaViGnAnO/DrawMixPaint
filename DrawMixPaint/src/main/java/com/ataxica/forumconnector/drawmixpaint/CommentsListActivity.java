package com.ataxica.forumconnector.drawmixpaint;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import static com.ataxica.forumconnector.drawmixpaint.R.layout.activity_comments;

/**
 * Created by Brian Savignano on 6/6/2014.
 */
public class CommentsListActivity extends ActionBarActivity{
    Document doc = null;
    ListView listView;
    RelativeLayout loadingPanel;
    ArrayList<CommentDetails> details;
    AdapterView.AdapterContextMenuInfo info;

    class RetrievedData extends AsyncTask<String, Void, Document> {
        @Override
        protected void onPreExecute() {
            listView.setVisibility(View.GONE);
            loadingPanel.setVisibility(View.VISIBLE);
        }

        protected Document doInBackground(String... docToParse) {
            try {
                doc = Jsoup.connect("http://forum.drawmixpaint.com/discussions").get();
                Elements discussions = doc.select(".ItemDiscussion");



            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Document document) {
            setDataToAdapter();
            listView.setVisibility(View.VISIBLE);
            loadingPanel.setVisibility(View.GONE);
            super.onPostExecute(document);
        }



    }
    private void setDataToAdapter() {
        listView.setAdapter(new CommentsAdapter(this, details));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_comments);
        listView = (ListView)findViewById(R.id.listView);
        loadingPanel = (RelativeLayout)findViewById(R.id.loadingPanel);
        details = new ArrayList<CommentDetails>();

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
        }
        return super.onOptionsItemSelected(item);
    }
}
