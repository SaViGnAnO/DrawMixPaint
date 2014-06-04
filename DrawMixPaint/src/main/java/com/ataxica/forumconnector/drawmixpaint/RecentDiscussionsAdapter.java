package com.ataxica.forumconnector.drawmixpaint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Brian Savignano on 6/2/2014.
 */
public class RecentDiscussionsAdapter extends BaseAdapter {

    private ArrayList<DiscussionDetails> _data;
    Context _c;

    RecentDiscussionsAdapter(ArrayList<DiscussionDetails> data, Context c){
        _data = data;
        _c = c;
    }

    @Override
    public int getCount() {
        return _data.size();
    }

    @Override
    public Object getItem(int position) {
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

        DiscussionDetails discussion = _data.get(position);
        imageView.setImageBitmap(discussion.image);
        titleView.setText(discussion.title);
        authorView.setText(discussion.author);
        return v;
    }
}
