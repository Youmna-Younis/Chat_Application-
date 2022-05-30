
package com.mycompany.mavenproject1;


import java.util.Scanner;
 
public class UserProfileDes {
   Scanner in = new Scanner(System.in);
 
    private int UserID ;
    private String Describtion;
    private boolean ProfilePhoto;
    private String Profile_photo_path;
    private boolean Visible;   
 
    public UserProfileDes(int userid) {
        this.UserID = userid;
        this.Visible=true;  // true by default
    }
 
    public UserProfileDes(int UserID,boolean ProfilePhoto,boolean Visibility){
        this.UserID = UserID;  
        this.ProfilePhoto = ProfilePhoto;
        if(ProfilePhoto){
            System.out.println("enter profile photo path");
            String x = in.nextLine();
            Profile_photo_path=x;
        }
        this.Visible = Visibility;
    } 
 
    public void ChangeVisibility(boolean x, Users u){
            Visible=x;//true for anyone & false for only my contacts
           
        for(int i=0; i <messagefile.profilefile.size();++i){
            String s = messagefile.profilefile.get(i);
            String a[] = s.split(",");
           
            if(a[0].equals(String.valueOf(u.userid))){
                messagefile.profilefile.remove(i);
                messagefile.profilefile.add(i,a[0]+","+a[1]+","+a[2]+","+String.valueOf(x)+","+System.lineSeparator());
            }
        }
    }
 
 
    public void ProfileInfo(Users me){
        for(int i=0; i<messagefile.profilefile.size();++i){
            String s =  messagefile.profilefile.get(i);
            String a[] = s.split(",");
            if(a[0].equals(String.valueOf(me.userid))){
              System.out.println("ID: "+a[0]);
              System.out.println("Describtion: "+a[2]);
              System.out.println("ProfilePhotoPath:" +a[1]);
              if(a[3].charAt(0) == 't'){
              System.out.println("Visibility: Anyone");
              }else{
            System.out.println("Visibility: contacts only");
           }
         }
       } 
    }
 
 
    public int getUserID() {
        return UserID;
    }
 
    public void setDescribtion(String s) {
        this.Describtion=s;
    }
 
     public String getDescribtion() {
        return Describtion;
    }
 
    public void setVisible(boolean x) {
        this.Visible= x;
    }
    public boolean isVisible() {
        return Visible;
    }
 
}
 