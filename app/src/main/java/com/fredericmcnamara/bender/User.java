package com.fredericmcnamara.bender;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by fredericmcnamara on 16-05-09.
 */
public class User implements Serializable {
    private String username;
    private int age;
    private String description;
    private String[] likes;
    private String imageName;

    public User(String username, int age, String description, String[] likes) {
        this.username = username;
        this.age = age;
        this.description = description;
        this.likes = likes;
    }

    public User(String username, int age, String description, String[] likes, String imageName)
    {
        this.setUsername(username);
        this.setAge(age);
        this.setDescription(description);
        this.setLikes(likes);
        this.setImageName(imageName);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getLikes() { return likes; }

    public void setLikes(String[] likes) {
        this.likes = likes;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return username;
    }
}
