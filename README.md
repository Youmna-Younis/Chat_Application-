# Chat-application
## The application should keep track of these entities.
### User : 
the user has (UserID ,mobile number , password , First name, Last name ,ChatRooms, ChatRoomInfo ,Contacts which are other users. , Stories , User Profile description )
###  ChatRoom : the ChatRoom has (ChatRoomID, List of Users (2 in case of one to one
chat and 2 or more in case of group chat ), List of Messages ,ChatRoom Type (one to
one chat or group chat ) ) 3- ChatRoomInfo : the ChatRoomInfo has (UserID,
ChatRoomID , Last seen (Date that corresponds to the last date the user opened the
ChatRoom))
###  Message: The Message entity has (MessageId , UserID (who wrote the message),
Text, Status).
###  Status :
The status has ( Date of message sent , time of message sent , status type
(which is either seen or unseen (when the message is sent it is initially unseen until
the another user opens the chat room , In case of group chat it is seen if only all the
other users opened the chat room)).
###  Story : 
story entity has (User ID , Published Story time , Story photo (This attribute
is optional) , Story text).
### User Profile Description 
(User ID, Personal photo if exists , About description,
Visibility (Boolean to make your information visible to anyone or only your contacts )
)
### Constraints:
● Each user story should be disappeared to all his contacts after 24 hours from
the time it was published.
● The user can only see the photo and profile description for the users that
already have him as a contact if the visibility is false otherwise he can see any
of his contacts photo and profile description.
General functions:

● Each user can add new contacts.
● Each user can chat with any other user in his contacts and a chatroom should
be created for both users.
● Each user can create a group chat and a chatroom should be created for all
users in the group.
● The user can see all the chatrooms that he is already in.
● The user can open any of his chatrooms and see all the previous messages
and he can also send a new message
● The user can see the status of the message whether it is seen or not.
● The user can see all the stories of his mutual contacts .
● The user can change his profile picture and his about description.
● The user can undo a message
