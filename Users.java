package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


public class Users {
        public Scanner in = new Scanner(System.in);
        private static int counter = 0;
        int  userid,no_contacts =0;
        String password, firstname,lastname , mobile_no;
	ArrayList <Users> contacts=new ArrayList<>();
        private Queue<story> story = new LinkedList<story>();
        BST_class tree = new BST_class();
       public UserProfileDes profile = new UserProfileDes(userid);

    public Users(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public Users(int userid, String password, String firstname, String lastname, String mobile_no) {
        this.userid = userid;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile_no = mobile_no;
    }
    
   public Users() {
	userid = counter;
        counter ++;
	mobile_no = "";
	password = "";
	firstname = "";
        lastname = "";
    }
Users(String mobile_number, String password, String fname , String lname ) {
	userid = counter;
        counter ++;
	this.mobile_no = mobile_number ;
	this.password = password ;
	firstname = fname ;
        lastname = lname ;
	no_contacts = 0 ;
}
Users(Users u) {
	this.userid=u.userid;
	this.mobile_no =u.mobile_no;
	this.password =u.password;
	this.firstname =u.firstname;
        this.lastname =u.lastname;
	this.no_contacts = u.no_contacts;
}
Users (String f_name , String lastn ,String pass){
    this.firstname = f_name ;
    this.lastname = lastn;
    this.password = pass ;
}
Users addcontact(Users currentuser) {
    
	String  number ;
       
        System.out.println("enter phone number of contact");
	number=in.next();
        String  name ;
        Users new_contact ;  
      chat_room chat = new chat_room();
        new_contact = searchuser(number);
        if (new_contact!=null)
        {
         Users   new__contact=searchcontact(number);
            if (new__contact==null){
                System.out.println("enter name for the contact");
	        name=in.next();  
                currentuser.contacts.add(new__contact);currentuser.no_contacts++;
                
                 String ss=Integer.toString(currentuser.userid)+","+new_contact.userid+","+new_contact.mobile_no+","+name+","+System.lineSeparator();
                 messagefile.contacts.add(ss);
                 System.out.println("contact added");
            
            }
            else{ System.out.println("contact already exist");
            return null;
            
            
            }
        
            String f= chat.check_if_chat_exist(currentuser,new_contact);
            if (!f.equals("")){
                System.out.println("contact added but chat already exist");
                for (int i = 0; i <messagefile.mychatfile.size(); i++) {
                    String s=messagefile.mychatfile.get(i),a[]=s.split(",");
                    if(f.equals(a[0])&&currentuser.userid==Integer.parseInt(a[1])){
                        System.out.println(i);
                        messagefile.mychatfile.remove(i);
                        messagefile.mychatfile.add(i,a[0]+","+a[1]+","+name+","+"not opend yet"+","+System.lineSeparator() );
                        currentuser.tree.root=null;
                        currentuser.tree.uploadtree(currentuser);
                      ///  currentuser.uploadcontacts(currentuser);
                    }
                }}else {
                
                        
        
       
       if(messagefile.conversationfile.isEmpty())chat.ChatRoom_ID=0;
       else{
        //   a[0]=chat id, a[1]=chat name,a[2]=chat type
        String sss=messagefile.conversationfile.get(messagefile.conversationfile.size()-1);
        String a[]=sss.split(",");
    
        chat.ChatRoom_ID=Integer.parseInt(a[0])+1;
         }
        chat.ChatRoomType="Ordinary";
        chat.numberofmembers=2;
         chat.Seen_messges.add(currentuser.userid +",-1,"+chat.ChatRoom_ID);
                chat.Seen_messges.add(new_contact.userid +",-1,"+chat.ChatRoom_ID);
                messagefile.seenfile.add(currentuser.userid +",-1,"+chat.ChatRoom_ID+","+System.lineSeparator());
                messagefile.seenfile.add(new_contact.userid +",-1,"+chat.ChatRoom_ID+","+System.lineSeparator());
        chat. users.add(currentuser); 
        chat. users.add(new_contact);
        /////
        chat.usersseen.add((new Date()).toString());
        chat.usersseen.add("chat not opened yet");
        chat.addmychatinfile(chat,name);
        currentuser.tree.insert( name, currentuser, chat);
        return  new_contact;     
        }}
            return null;
}
	
        
Users searchuser(String phone){
 
      for (int i = 0; i <messagefile.usersfile.size(); i++) {
        String s=messagefile.usersfile.get(i);
        String a[]=s.split(",");
        if(phone.equals(a[3])){
         Users new_contact=new Users() ;  
         new_contact.userid=Integer.parseInt(a[0]);
         new_contact.firstname=a[1];new_contact.lastname=a[2];new_contact.mobile_no=a[3];new_contact.password=a[4];
        return new_contact;
        }
}      
        System.out.println("there is no user have this number");
       
      return  null; 
}

Users searchcontact(String phone){
 
      for (int i = 0; i <messagefile.contacts.size(); i++) {
        String s=messagefile.contacts.get(i);
        String a[]=s.split(",");
        if(phone.equals(a[2])){
         Users new_contact=new Users() ;  
         new_contact.userid=Integer.parseInt(a[1]);
         new_contact.firstname=a[3];new_contact.lastname="";new_contact.mobile_no=a[2];
        return new_contact;
        }
        
}      
        System.out.println("there is no contact have this number");
      
      return null;
   
}
Users searchcontactbyname(String name){
 
      for (int i = 0; i <messagefile.contacts.size(); i++) {
        String s=messagefile.contacts.get(i);
        String a[]=s.split(",");
        if(name.equals(a[3])){
         Users new_contact=new Users() ;  
         new_contact.userid=Integer.parseInt(a[1]);
         new_contact.firstname=a[3];new_contact.lastname="";new_contact.mobile_no=a[2];
        return new_contact;
        }
        
}      
        System.out.println("there is no contact have this number yet");
      
      return null;    
}
void uploadcontacts(Users currentuser){
    
    for (int i = 0; i < messagefile.contacts.size(); i++) {
        String s=messagefile.contacts.get(i);
        String a[]=s.split(",");
        if(a[0].equals(Integer.toString(currentuser.userid))){
            Users contact=new Users() ;contact.userid=Integer.parseInt(a[1]);contact.firstname=a[3];
            contact.mobile_no=a[2];
            currentuser.contacts.add(contact);
           
        }
    }
    
}
void displaycontacts(Users currentuser) {
    currentuser.contacts.clear();
    currentuser.uploadcontacts(currentuser);
	for (int i = 0; i < currentuser.contacts.size(); i++) {
          
     //   System.out.println(currentuser.contacts.get(i));
        System.out.println(" with : "+currentuser.contacts.get(i).firstname +"\n");

        }
}
public void AddStroy(Users me,int userid){
        story new_story = new story(userid);
        System.out.println("enter your story type\n");
        Scanner s = new Scanner (System.in);
        char t = s.next().charAt(0);
 
        if(t == 't'){
            System.out.println("enter your text story\n");
            String x =s.next();
            new_story.setStorytext(x);
            me.story.add(new_story);
            new_story.setPublishing_time(System.currentTimeMillis());  /// gets currnet time
            String ss = Integer.toString(userid)+","+Long.toString(new_story.getPublishing_time())+","+new_story.getStorytext()+","+System.lineSeparator();
            messagefile.storyfile.add(ss);
 
        }else if( t == 'p'){
            System.out.println("enter path for your story\n");
            String x = s.next();
            new_story.setStorypath(x);
            me.story.add(new_story);
            new_story.setPublishing_time(System.currentTimeMillis()); 
            String ss = Integer.toString(userid)+ "," + Long.toString(new_story.getPublishing_time()) + "," + new_story.getStorypath()+","+System.lineSeparator();
            messagefile.storyfile.add(ss);
        }
    }
 
    public void DisplayStory(Users contact){                                  // parameter -> specify which user to display his story      
        contact.story.clear();
        contact.UploadStory(contact);                                             // upload story in queue first
        StoryUpdating(contact);                                             // checks if story time is over 24h
        System.out.println("story of : "+ contact.firstname + " " + contact.lastname);
        Iterator<story> it = contact.story.iterator();
        while(it.hasNext())
        {
            story x = it.next();
            System.out.println(x.getStorytext());
        }
    }

    public void DisplayAllContactsStory(Users me){
            me.contacts.clear();
            uploadcontacts(me); 
        for(int i=0; i<me.contacts.size();++i){
            
            Users contact = me.contacts.get(i);
            contact.story.clear();
            UploadStory(contact); 
            contact.DisplayStory(contact);
            System.out.println("----------------------------------------");
        }
    }
    // displays story of a certain contact
    public void AContactStory(int contactid){
        for(int i=0; i<messagefile.contacts.size();++i){
            String s = messagefile.contacts.get(i);
            String a[] = s.split(",");
            if(userid == Integer.parseInt(a[0])){
        
              if(contactid == Integer.parseInt(a[1])){
                 Users contact = searchcontact(a[2]);
                 contact.DisplayStory(contact);
              }
            }
        }
    }
 // deletes story after 24 hours
    public void StoryUpdating(Users currentuser){
        long current_time = System.currentTimeMillis();
        long ending_time = 24*60*60*1000; // change to 24 hours
        for(int i=0; i< messagefile.storyfile.size();++i){
            String s = messagefile.storyfile.get(i);
            String a[] = s.split(",");
            if(Integer.parseInt(a[0]) == currentuser.userid){
                if(current_time - Long.parseLong(a[1]) >= ending_time){
                    messagefile.storyfile.remove(i);
                    currentuser.story.remove();
                }
            }
        }
    }
 
    public void UploadStory(Users me){
        for(int i=0; i<messagefile.storyfile.size();++i){
            String s = messagefile.storyfile.get(i);
            String a[] = s.split(",");
            if(Integer.parseInt(a[0]) == me.userid){
                story new_story = new story(me.userid);
                new_story.setPublishing_time(Long.parseLong(a[1]));
                new_story.setStorytext(a[2]);
               me. story.add(new_story);
 
            }
        }
    }
    public void Visibility(Users user,String p){                          //userid,profilepic,describition,visibilit
     boolean w = true;
           if(user.searchuser(p)!= null){
               if(user.searchcontact(p) == null){
              for(int i=0; i<messagefile.profilefile.size(); ++i){
                  String s = messagefile.profilefile.get(i);
                  String a[] = s.split(",");
 
                  if(a[0].equals(String.valueOf(user.searchuser(p).userid))&& a[3].charAt(0) == 't'){
                          user.profile.ProfileInfo(user.searchuser(p));
                          w=true;
                  }else
                      w=false;
              }
              if(!w)
                       System.out.println("visibility is false for this user");
           }else{   
              user.profile.ProfileInfo(user.searchcontact(p));
          }
        }
    }
static Users  login() {
    Scanner in =new Scanner(System.in);
    
	
        String pass, phone ;  
        System.out.println(" for login enter your phone , pass" );  
        phone=in.next();
        pass=in.next();
        for (int i = 0; i <messagefile.usersfile.size(); i++) {
        String s=messagefile.usersfile.get(i);
        String a[]=s.split(",");
        if (phone.equals(a[3])){
            if(pass.equals(a[4])){
             Users u = new Users(Integer.parseInt(a[0]), pass, a[1], a[2],a[3]);
             System.out.println( u.mobile_no + u.password);
             return u;
             
            }
        System.out.println("wrong password ,try again");
        return login();
        }
    }System.out.println("incorrect phone number, try again");
	return null;
}
 Users register (){
    String ss =messagefile.usersfile.get(messagefile.usersfile.size()-1);
    String a[]=ss.split(",");
    System.out.println("ENTER PASS");
     String pass=in.next();
    System.out.println("enter first name ");
     String fname=in.next();
     System.out.println("enter last name");
     String lname=in.next();
     System.out.println("enter phone ");
     String phone=in.next();
    Users u = new Users(Integer.parseInt(a[0])+1,pass,fname,lname,phone);
    
    
    
    
    ss=Integer.toString(u.userid)+","+fname+","+","+lname+","+phone+","+pass+","+System.lineSeparator();
    System.out.println(ss);
    messagefile.usersfile.add(ss);
    return u;
}
} 
       
    
    
    
        