package com.ataxica.forumconnector.drawmixpaint;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Brian Savignano on 6/2/2014.
 */
public class DiscussionsAdapter extends ArrayAdapter<DiscussionDetails> {
    private ArrayList<DiscussionDetails> _data;
    Context _c;

    public DiscussionsAdapter(Context context, ArrayList<DiscussionDetails> data) {

        super(context, 0, data);
        _data = data;
        _c = context;
    }



    @Override
    public int getCount() {
        return _data.size();
    }

    @Override
    public DiscussionDetails getItem(int position) {
        return _data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v==null){
            LayoutInflater vi = (LayoutInflater)_c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.discussion_list_item, parent, false);
        }
        ImageView imageView = (ImageView)v.findViewById(R.id.imageView);
        TextView titleView = (TextView)v.findViewById(R.id.titleView);
        TextView authorView = (TextView)v.findViewById(R.id.authorView);
        TextView lastCommentByView = (TextView)v.findViewById(R.id.lastCommentByView);
        TextView lastCommentTimeView = (TextView)v.findViewById(R.id.lastCommentTimeView);
        TextView viewsView = (TextView)v.findViewById(R.id.viewsView);
        TextView commentsView = (TextView)v.findViewById(R.id.commentsView);
        ImageView newCommentsView = (ImageView)v.findViewById(R.id.newCommentsImage);

        DiscussionDetails discussion = _data.get(position);
        imageView.setImageBitmap(discussion.image);
        titleView.setText(discussion.title);
        authorView.setText(discussion.author);
        lastCommentByView.setText(discussion.lastCommentBy);
        lastCommentTimeView.setText(discussion.lastCommentTime);
        viewsView.setText(discussion.viewCount);
        commentsView.setText(discussion.commentCount);
        if (discussion.hasNew) newCommentsView.setVisibility(View.VISIBLE);

        if (discussion.author == "Mark_Carder"){
            authorView.setTypeface(Typeface.DEFAULT_BOLD);
        }

        return v;
    }

    public static abstract class OnClickListener implements View.OnClickListener {
        
    }

//    public void loadComments(String title, String url) {
//        Intent recentIntent = new Intent(DiscussionsAdapter.this, RecentDiscussionsActivity.class);
//        String recentUrl = "http://forum.drawmixpaint.com/discussions";
//        recentIntent.putExtra("url",recentUrl);
//        //myIntent.putExtra("key", value); //Optional parameters
//        DiscussionsAdapter.this.startActivity(recentIntent);
//    }
}
