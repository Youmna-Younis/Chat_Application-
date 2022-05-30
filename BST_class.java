package com.mycompany.mavenproject1;
 
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;
 import java.util.concurrent.ThreadLocalRandom;
public class BST_class {   
    public   class Node { 
       String user_name ; 
       chat_room chat_message=new chat_room();
       Node left, right; 
       Node(String data ,chat_room chi){ 
            user_name = data; 
            chat_message=chi;
            left = right = null; 
        } 
    }
    Node root; 
    BST_class(){ 
        root = null; 
    }
void insert(String key,Users u,chat_room chi){
    Node node=new Node(key, chi);
    if (chi==null){
        System.out.println("honaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return;
    }
    if(root==null) {
        u.tree.root = node;
          return;
    }
    Node prev=null;
    Node temp=u.tree.root;
    while (temp!=null){
        if(temp.user_name.compareTo(key)>0){ //////// هناااااا
            prev=temp;
            temp=temp.left;
        }

        else if (temp.user_name.compareTo(key)<0){///////هنا
            prev=temp;
            temp=temp.right;
        }
    }
    if(prev.user_name.compareTo(key)>0)///////هناااا
        prev.left=node;
    else
        prev.right=node;
    }



public void inorder(){

    Node temp=root;
    Stack<Node> stack=new Stack<>();
    while (temp!=null||!stack.isEmpty()){
        if(temp!=null){
            stack.add(temp);
            temp=temp.left;
        }
        else {
            temp=stack.pop();
            System.out.print(temp.user_name+" ");
            temp=temp.right;
        }

    }
}

public Node search(Node root, String key)
{
    if (root==null || root.user_name.equals(key)){
         return root;
    }
    if (root.user_name.compareTo(key)<0)
        return search(root.right, key);
    else
        return search(root.left, key);

}

 boolean searchbool(Node root,String key)  { 
     Node n= search( root,key); 
     if (n!= null)
        return true;
     else
       return false;
}
 

 void store_message(Node root,String key,Users u)  {
    Scanner in=new Scanner (System.in);
    Node m = search(u.tree.root,key); 
    try{
    if(m==null)
        throw new myexception("null node exception ");
  
        System.out.println("type your message");
        String Message_send=in.nextLine();
        String x;
        // get id of message
        if(!messagefile.messagesfile.isEmpty()){
            String a=messagefile.messagesfile.get(messagefile.messagesfile.size()-1);
            String b[]=a.split(",");b[0]=Integer.toString(Integer.parseInt(b[0])+1);
             x=b[0];
          }
        else 
            x="1";
       // get user id , id chat for message
        String userid= Integer.toString(u.userid);
        String idchat=Integer.toString(m.chat_message.ChatRoom_ID);
        Message messag=new Message(Integer.parseInt(x),Integer.parseInt(userid),encrypt(Message_send));
        Message_send=encrypt(Message_send);
        m.chat_message.messages.add(messag);
        messagefile.messagesfile.add(x+(",")+(userid)+(",")+(idchat)+(",")+(Message_send)+","+messag.getDate_Time()+",not seen,"+System.lineSeparator());
        changeuserlastseen( m,u);
         addlastmessage(u,x,m.chat_message); 
         System.out.println(all(m.chat_message,x));
         
        }
 catch (myexception ex){
        System.out.println("exception handled");
    }
    }
 void addlastmessage(Users u,String m, chat_room chat)
    {
        for (int i =0 ; i < chat.users.size() ; i++)
        {
            String s[] = chat.Seen_messges.get(i).split(",");
 
            if(u.userid == Integer.parseInt(s[0])) {
                chat.Seen_messges.remove(i);
                chat.Seen_messges.add(u.userid + "," + m +"," +chat.ChatRoom_ID);
            }
        }
 
        for (int i =0 ; i < messagefile.seenfile.size() ; i++)
        {
            String ss[] = messagefile.seenfile.get(i).split(",");
            if(ss[0].equals(String.valueOf(u.userid)) && ss[2].equals(String.valueOf(chat.ChatRoom_ID))) {
                messagefile.seenfile.remove(i);
                messagefile.seenfile.add(u.userid + "," + m +"," +chat.ChatRoom_ID+","+ System.lineSeparator());
            }
        }
    }
    boolean all(chat_room chat , String mid)
    { try{
    if(chat==null)
        throw new myexception("null chat exception ");
  
        int counter = 0 ;
        for(int i =0 ; i < chat.users.size()  ;i++)
        {
           String e[] = chat.Seen_messges.get(i).split(",");
           if(Integer.parseInt(e[1]) >= Integer.parseInt(mid))
           {
               counter++ ;
           }
        }
        
        if(counter == chat.users.size())
        {System.out.println("counter "+counter);
            return true ;
        }
        }
    catch (myexception ex){
        System.out.println("exception handled");
        System.out.println(ex.getMessage());
    }
        return false ;
    
  }
 void uploadmessage(Node root,String key ){
    Node m=search(root,key);
    try{
    if(m==null)
        throw new myexception("null node exception ");
  
         if (messagefile.messagesfile.isEmpty())
             return;
        for (int i=0;i<messagefile.messagesfile.size();i++){
            String s=messagefile.messagesfile.get(i);
            String a[]=s.split(",");
            int messageid=Integer.parseInt(a[0]);
            int userid=Integer.parseInt(a[1]);
            int idchat=Integer.parseInt(a[2]);
           String Message_send=a[3];
           if(m.chat_message.ChatRoom_ID==idchat){
                Message new_message = new Message(messageid, userid,a[4],(Message_send) );
                m.chat_message.messages.add( new_message);
            }
        }
    }catch (myexception ex){
        System.out.println("exception handled");
        System.out.println(ex.getMessage());
    }
         
 }
      
void display_messages(Users u ,Node root,String key){
Node mm  = search(root,key); 
 try{
    if(mm==null)
        throw new myexception("null node exception ");
  
  mm.chat_message.messages.clear();
    uploadmessage(mm ,key );
            String s = String.valueOf(mm.chat_message.messages.get(mm.chat_message.messages.size() -1).getMessageID());
            addlastmessage(u ,s, mm.chat_message);
    for(int i =0 ; i < mm.chat_message.messages.size() ; i++){
       String real_message = decrypt(mm.chat_message.messages.get(i).getText());
 
                String ee =String.valueOf(mm.chat_message.messages.get(i).getMessageID());
                System.out.println(all(mm.chat_message,ee));
                if(all(mm.chat_message,ee))
                {
                    String change = messagefile.messagesfile.get(mm.chat_message.messages.get(i).getMessageID()-1);
                    String cc[] = change.split(",");
                    messagefile.messagesfile.remove(mm.chat_message.messages.get(i).getMessageID()-1);
                    messagefile.messagesfile.add(mm.chat_message.messages.get(i).getMessageID()-1,cc[0]+","+cc[1]+","+cc[2]+ ","+ cc[3]+ "," + cc[4] + "," + "seen," + System.lineSeparator());
                    mm.chat_message.messages.get(i).setSeen(true);
                   
                }
                System.out.println("message : " + real_message+mm.chat_message.messages.get(i).getDate_Time() + "," +"message "+ mm.chat_message.messages.get(i).isSeen());
            }
      
 
 changeuserlastseen( mm,u );
 }catch (myexception ex){
        System.out.println("exception handled");
        System.out.println(ex.getMessage());
    }
}
void changeuserlastseen(Node mm,Users currentuser ){
    try{
    if(mm==null)
        throw new myexception("null node exception ");
  
   for (int i = 0; i <   mm.chat_message.users.size() ; i++) {
    int id=  mm.chat_message.users.get(i).userid;
    //System.out.println("chatid "+mm.chat_message.ChatRoom_ID);
    if (currentuser.userid==id) {
         mm.chat_message.usersseen.remove(i);
         mm.chat_message.usersseen.add(i,(new Date()).toString());
         for (int j = 0; j <messagefile.mychatfile.size(); j++) {
              String s=messagefile.mychatfile.get(j);
              String a[]=s.split(",");
              if (a[0].equals(Integer.toString(mm.chat_message.ChatRoom_ID))&&a[1].equals(Integer.toString(currentuser.userid))) {
                  messagefile.mychatfile.remove(j);
                  messagefile.mychatfile.add(j,a[0]+","+a[1]+","+a[2]+","+(new Date()).toString()+","+System.lineSeparator());
                 }
             }
     }
   } }catch (myexception ex){
        System.out.println("exception handled");
        System.out.println(ex.getMessage());
    }
}
void undo( Node root,String key){
    Scanner in = new Scanner(System.in);
    Node mm=search(root,key);
  //  mm.chat_message.messages.clear();
  //  uploadmessage( mm,key );
   try{
    if(mm==null)
        throw new myexception("null node exception ");
  
    if(searchbool(root,key)) {
       while (true) {
            System.out.println("For undo Your message press Number of message else press -1");
            int choices = in.nextInt();
            if (choices == -1)
                break;
            else {
               if (choices<mm.chat_message.messages.size()){
                    mm.chat_message.messages.get(choices).setText(encrypt("Deleted message")); 
                    int id= mm.chat_message.messages.get(choices).getMessageID();
                    String s= messagefile.messagesfile.get(id-1);
                    String a[]=s.split(",");
                    messagefile.messagesfile.remove(id-1);
                    messagefile.messagesfile.add(id-1,a[0]+","+a[1]+","+a[2]+","+ encrypt("Deleted message")+","+a[4]+","+System.lineSeparator());
                 }
               else
               System.out.println("Invalde option");
            }
        }
    } 
    }catch (myexception ex){
        System.out.println("exception handled");
        System.out.println(ex.getMessage());
    }

}

  

 void uploadtree(Users u){
    for(int i=0;i<messagefile.mychatfile.size();i++){
        String s=messagefile.mychatfile.get(i);
        String a[]=s.split(",");
        String name=a[2];
        if(Integer.toString(u.userid).equals(a[1])){
            String chatid=a[0];
            chat_room chi;
            for(int j=0;j<messagefile.conversationfile.size();j++){
                String ss=messagefile.conversationfile.get(j);
                String aa[]=ss.split(",");
                if(chatid.equals(aa[0])){
                    chi=uploadusersinchat(aa[0]);
                    chi.ChatRoom_ID=Integer.parseInt(aa[0]);
                    chi.ChatRoomType=aa[1];
                    String[] k=aa[2].split(System.lineSeparator());
                    chi.numberofmembers=Integer.parseInt(k[0]);
                    u.tree.insert( name,u,chi);
                    uploadmessage(u.tree.root,name );
                    break;
                }
             }
        }
    }
}
 
 
 chat_room uploadusersinchat(String chatid){
    chat_room chi=new chat_room();
    for (int i = 0; i <messagefile.mychatfile.size(); i++) {
        String s=messagefile.mychatfile.get(i);
        String a[]=s.split(",");
        if(chatid.equals(a[0])){
            String userid=a[1];
            chi.usersseen.add(a[3]);
            for (int j = 0; j <messagefile.usersfile.size(); j++) {
                String ss=messagefile.usersfile.get(j);
                String aa[]=ss.split(",");
                if (userid.equals(aa[0])) {
                       Users u = new Users(Integer.parseInt(aa[0]),aa[4],aa[1],aa[2],aa[3]);
                       chi.users.add(u);break;
                   }
             }
        }
    }
    for(int i=  0 ; i < chi.users.size() ; i++)
        {
            for(int  j = 0; j < messagefile.seenfile.size() ; j++)
            {
                String aa[] = messagefile.seenfile.get(j).split(",");
 
                if(aa[0].equals(String.valueOf(chi.users.get(i).userid)) && aa[2].equals(chatid))
                {
                   chi.Seen_messges.add(aa[0]+","+ aa[1] + ","+ aa[2]);
                }
            }
        }
    return chi;
 }
String encrypt(String s){
    int rand ;
    StringBuilder HashValue=new StringBuilder();
    for(int i=(s.length()-1); i>=0 ;i--){
        HashValue.append(s.charAt(i));
        rand=ThreadLocalRandom.current().nextInt(47, 125);
        char temp=(char)rand;
        HashValue.append(temp);
    }
    return HashValue.toString();
}
String decrypt(String s){
  int rand ;
  StringBuilder HashValue=new StringBuilder();
  for(int i=(s.length()-1); i>=0 ;i--){
    if(i%2!=0){
    continue;
    }
    HashValue.append(s.charAt(i));
   }
return HashValue.toString();
}


 void chatRoomInfo(Node root, String key){
   Node m=search(root,key);
    try{
    if(m==null)
        throw new myexception("null node exception ");
  
        System.out.println(" this chat_room id is :"+ m.chat_message.ChatRoom_ID); 
        for( int l = 0 ; l < m.chat_message.users.size() ; l++){
         System.out.println(" id for the  "+ (l+1) +" participate is :"+ m.chat_message.users.get(l).userid+m.chat_message.usersseen.get(l)); 
         }
    }
    catch (myexception ex){
        System.out.println("exception handled");
    }

}}

 