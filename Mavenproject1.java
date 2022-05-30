
package com.mycompany.mavenproject1;
import java.io.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Mavenproject1 {

   public static void main(String[] args) {
   
    
     //  messagefile file =new messagefile ();
       messagefile.readmessagefile();messagefile.readconversationfile();messagefile.readmychatfile();messagefile.readcontacts();messagefile.readusers();
       messagefile.readseenmessage();messagefile.readprofiledesc();messagefile.readstory();
       Scanner in = new Scanner(System.in);
       String ChatRoom_name ;   
       Users currentuser;
       currentuser =Users.login();
       Users m= new Users() ;
      if (currentuser==null){
      
           m = new Users (m.register());
      currentuser=new Users( m);
      }
       currentuser.tree.uploadtree(currentuser);
      currentuser.uploadcontacts(currentuser);
   // currentuser.tree.undo(file, currentuser.tree.root,"xc");
       System.out.println(currentuser.userid);
   while(true){
    boolean exit =false;
     System.out.println("1.log in with another user");
     System.out.println("2.creat new chat");
     System.out.println("3.send message");
     System.out.println("4.display messages ");
     System.out.println("5.display contacts");
     System.out.println("6.display chats name");
     System.out.println("7.exit");
     System.out.println("8.add contact");
     System.out.println("9. display chat info");
     System.out.println("10. delete message");
     System.out.println("11.add story");
     System.out.println("12.display story");
     System.out.println("13.display all contacts story");
     System.out.println("14.display a contacts story");
     System.out.println("15.change visibility ");
     System.out.println("16.display your profile ");
     System.out.println("17.display your friend profile");
     int x=in.nextInt();
      switch(x){
         case 1:
             
                currentuser=Users.login();
                 if (currentuser==null){
      
                   m = new Users (m.register());
               currentuser=new Users( m);
                }
                currentuser.tree.uploadtree( currentuser);
                currentuser.uploadcontacts(currentuser);


                 break;
          case 2:
                
                
                chat_room   chi = new chat_room();
                chi=chi.add_chatRoom(currentuser);
                
               //    System.out.println( currentuser.tree.root.left.left.user_name);
                
                break;
          case 3:
              System.out.println("enter chat name");
              ChatRoom_name=in.next();
                           //   currentuser.tree.uploadmessage(currentuser.tree.root,ChatRoom_name );
              currentuser.tree.store_message(currentuser.tree.root,ChatRoom_name,currentuser); 
      
              break;
          case 4:
               System.out.println("enter chat name to display messages");
               ChatRoom_name=in.next();
               currentuser.tree.display_messages(currentuser,currentuser.tree.root,ChatRoom_name);
               break;
          case 5:
               
              currentuser.displaycontacts(currentuser);
              break;
          case 6:
            currentuser.tree.inorder();
              break;
          case 7:
              exit=true;
              break;
          case 8:
             currentuser. addcontact(currentuser);
             break;
          case 9: 
             // currentuser=(currentuser.register());
                System.out.println("enter chat name to display info");
               ChatRoom_name=in.next();
             currentuser.tree.chatRoomInfo(currentuser.tree.root,ChatRoom_name);
              break;
               case 10: 
             // currentuser=(currentuser.register());
                System.out.println("enter chat name to display info");
               ChatRoom_name=in.next();
              currentuser.tree.undo(currentuser.tree.root,ChatRoom_name);
              break;
          case 11 :
              currentuser.AddStroy(currentuser,currentuser.userid);
              break;
          case 12:
              currentuser.DisplayStory(currentuser);
              break;
          case 13:
              currentuser.DisplayAllContactsStory(currentuser);
              break;
          case 14:
              System.out.println("id of contact you want to display it's story");
              int e = in.nextInt();
              currentuser.AContactStory(e);
              break;
          case 15:
              System.out.println("enter true for everyone and false for only your contacts");
              boolean v =in.nextBoolean();
              currentuser.profile.ChangeVisibility(v,currentuser);      
              break;    
          case 16:                                                // display my profile info
              currentuser.profile.ProfileInfo(currentuser);      // display my profile info
              break;
          case 17:
              System.out.println("enter phone of your friend");
              String phone= in.next();
              currentuser.Visibility(currentuser, phone);
              break;
            
      }
     if ( exit==true)
        break;
   }messagefile.writeseenmessage();messagefile.writestory();messagefile.writeprofiledesc();
   messagefile.writemessagefile();messagefile.writeconversationfile();messagefile.writemychatfile();messagefile.writecontacts();messagefile.writeusers();
//       System.out.println(currentuser.tree.root.right.user_name);
        //    System.out.println(currentuser.tree.root.left.user_name);

}
}

   
    
