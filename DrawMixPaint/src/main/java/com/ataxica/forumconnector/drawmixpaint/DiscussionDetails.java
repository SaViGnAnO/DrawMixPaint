package com.ataxica.forumconnector.drawmixpaint;

import android.graphics.Bitmap;

/**
 * Created by Brian Savignano on 5/13/2014.
 */
public class DiscussionDetails {
    Bitmap image;
    String title;
    String author;
    String viewCount;
    String commentCount;
    String lastCommentBy;
    String lastCommentTime;
    String category;

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getLastCommentBy() {
        return lastCommentBy;
    }

    public void setLastCommentBy(String lastCommentBy) {
        this.lastCommentBy = lastCommentBy;
    }

    public String getLastCommentTime() {
        return lastCommentTime;
    }

    public void setLastCommentTime(String lastCommentTime) {
        this.lastCommentTime = lastCommentTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public DiscussionDetails(){
        super();
    }

    public DiscussionDetails(Bitmap image, String title, String author, String viewCount, String commentCount, String lastCommentBy, String lastCommentTime, String category){
        super();

        this.image = image;
        this.title = title;
        this.author = author;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.lastCommentBy = lastCommentBy;
        this.lastCommentTime = lastCommentTime;
        this.category = category;
    }
}
