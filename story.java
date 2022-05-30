/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class story {
   private int userid;
   private long publishing_time;
   private String storypath;
   private String storytext;
   private boolean viewed = false;
 
 
    public story(int userid) {
        this.userid = userid;
    }
 
 
    // getters & setters
    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }
 
    public boolean isViewed() {
        return viewed;
    }
 
    public void StoryDisappearing(){
 
    }
 
    public int getUserid() {
        return userid;
    }
 
    public void setUserid(int userid) {
        this.userid = userid;
    }
 
    public long getPublishing_time() {
        return publishing_time;
    }
 
    public void setPublishing_time(long publishing_time) {
        this.publishing_time = publishing_time;
    }
 
    public String getStorypath() {
        return storypath;
    }
 
    public void setStorypath(String storypath) {
        this.storypath = storypath;
    }
 
    public String getStorytext() {
        return storytext;
    }
 
    public void setStorytext(String storytext) {
        this.storytext = storytext;
    }
}