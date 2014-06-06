package com.ataxica.forumconnector.drawmixpaint;

import android.graphics.Bitmap;

/**
 * Created by Brian Savignano on 6/6/2014.
 */
public class CommentDetails {
    Bitmap image;
    String author;
    String rank;
    String dateCreated;
    String dateUpdated;
    String message;

    public CommentDetails(){
        super();
    }

    public CommentDetails(Bitmap image, String author, String rank, String dateCreated, String dateUpdated, String message){
        super();
        this.image = image;
        this.author = author;
        this.rank = rank;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.message = message;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
