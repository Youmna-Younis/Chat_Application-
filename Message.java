package com.mycompany.mavenproject1;


import java.util.Date;

public class Message {
    private int MessageID, UserID;
    private static int  counter =0;
    private String Text;
    private String Date_Time;
    private boolean seen=false;
    private Date date;

    public Message(int MessageID, int UserID,String Date_Time, String Text) {
        this.MessageID = MessageID;
        this.UserID = UserID;
        this.Text = Text;
        this.seen = false;
        
        this. Date_Time = Date_Time;
       
    }


    Message(int MessageID, int UserID, String Text){
       this.MessageID = MessageID;
        this.UserID = UserID;
        this.Text = Text;
        this.seen = false;
        
        date = new Date();            // saving current date and time
        Date_Time = date.toString();
       
        
    }
    
    void MessageInfo(){
        System.out.println("Message send at " + Date_Time);
        if(seen)
            System.out.println("Message is seen\n");
        else
            System.out.println("Message is send\n");
    }

    public String getText() {
        return Text;
    }

 
    public int getMessageID() {
        return MessageID;
    }

    public String getDate_Time() {
        return Date_Time;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

   public void setSeen(boolean seen) {
        this.seen = seen;
    }
 
    public boolean isSeen() {
        return seen;
    }
        

    
}

