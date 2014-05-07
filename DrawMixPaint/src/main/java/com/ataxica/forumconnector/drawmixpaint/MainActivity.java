package com.ataxica.forumconnector.drawmixpaint;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

//testing
public class MainActivity extends ActionBarActivity {

    TextView titleLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleLabel = (TextView) findViewById(R.id.titleLabel);
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
        } else if (id == R.id.action_parse) RunParse();
        return super.onOptionsItemSelected(item);
    }

    private void RunParse() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://forum.drawmixpaint.com").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = doc.title();

        titleLabel.setText(title);
    }
}
