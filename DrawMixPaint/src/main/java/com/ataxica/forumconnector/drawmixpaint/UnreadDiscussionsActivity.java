package com.ataxica.forumconnector.drawmixpaint;

import android.app.ListActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static com.ataxica.forumconnector.drawmixpaint.R.layout.activity_unread_discussions;

/**
 * Created by Brian Savignano on 5/11/2014.
 */
public class UnreadDiscussionsActivity extends ActionBarActivity {
    Document doc = null;
    ListView listView;
    RelativeLayout loadingPanel;
    ArrayList<DiscussionDetails> details;
    AdapterView.AdapterContextMenuInfo info;
    String url;

    class RetrievedData extends AsyncTask<String, Void, Document> {
        @Override
        protected void onPreExecute() {
            listView.setVisibility(View.GONE);
            loadingPanel.setVisibility(View.VISIBLE);
        }

        protected Document doInBackground(String... docToParse) {
            try {
                doc = Jsoup.connect(url).get();
                Elements discussions = doc.select(".ItemDiscussion");


                for (Element post : discussions) {
                    if (post.getElementsByClass(".Unread")!=null) {
                        //.text();
                        Elements title = post.getElementsByClass("Title");
                        Elements author = post.select(".discussionauthor");
                        String imageURL = post.select(".ProfilePhoto").attr("src");
                        String lastCommentBy = post.select(".LastCommentBy").text();
                        String lastCommentTime = post.select(".LastCommentDate").text();
                        String viewCount = post.select(".ViewCount").text();
                        viewCount = viewCount.replace(" views", "");
                        String commentCount = post.select(".CommentCount").text();
                        commentCount = commentCount.replace(" comments", "");
                        DiscussionDetails Detail = new DiscussionDetails();
                        if (imageURL.startsWith("//")) {
                            imageURL = "http:" + imageURL;
                        }
                        try {
                            URL url = new URL(imageURL);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setDoInput(true);
                            connection.connect();
                            InputStream input = connection.getInputStream();
                            Bitmap myBitmap = BitmapFactory.decodeStream(input);
                            Detail.setImage(myBitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Detail.setAuthor(author.text());
                        Detail.setTitle(title.text());
                        Detail.setLastCommentBy(lastCommentBy);
                        Detail.setLastCommentTime(lastCommentTime);
                        Detail.setViewCount(viewCount);
                        Detail.setCommentCount(commentCount);
                        details.add(Detail);
                    }

                }
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
        listView.setAdapter(new DiscussionsAdapter(this, details));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_unread_discussions);
        url = getIntent().getStringExtra("url");
        listView = (ListView)findViewById(R.id.listView);
        loadingPanel = (RelativeLayout)findViewById(R.id.loadingPanel);
        details = new ArrayList<DiscussionDetails>();

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
