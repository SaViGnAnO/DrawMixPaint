package com.ataxica.forumconnector.drawmixpaint;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Brian Savignano on 6/6/2014.
 */
public class CommentsAdapter extends ArrayAdapter<CommentDetails>{
    private ArrayList<CommentDetails> _data;
    Context _c;

    public CommentsAdapter(Context context, ArrayList<CommentDetails> data) {

        super(context, 0, data);
        _data = data;
        _c = context;
    }



    @Override
    public int getCount() {
        return _data.size();
    }

    @Override
    public CommentDetails getItem(int position) {
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
        TextView authorView = (TextView)v.findViewById(R.id.authorView);
        TextView rankView = (TextView)v.findViewById(R.id.rankView);
        TextView dateCreatedView = (TextView)v.findViewById(R.id.dateCreatedView);


        CommentDetails comment = _data.get(position);
        imageView.setImageBitmap(comment.image);
        authorView.setText(comment.author);

        if (comment.author == "Mark_Carder"){
            authorView.setTypeface(Typeface.DEFAULT_BOLD);
        }

        return v;
    }
}
