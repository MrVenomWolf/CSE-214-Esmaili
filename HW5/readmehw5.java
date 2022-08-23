/*
The goal of this assignment is to write a program that manages an email system (like a
stripped down version of Outlook) except that you can’t send and receive emails (naturally).
However, this program will have all of the usual email features like deleting emails, creating
new emails, moving emails to different folders, adding and removing emails, and the like.
1. Write a fully documented class named Email. This class will contain the following
information about each email.
• private String to
The String literal which stores the “to” field.
• private String cc
The String literal which stores the “cc” field.
• private String bcc
The String literal which stores the “bcc” field.
• private String subject
The String literal which stores the “subject” field.
• private String body
The String literal which stores all of the text in the email’s body.
• private GregorianCalendar timestamp
Represents the time that this email was created.
The Email class should have a Constructor, mutator and accessor methods for each
instance variable. In order for your program to be able to save Email objects to a file, all
objects in it must be serializeable, so this class must implement Serializable.
2. Write a fully documented class named Folder. This class represents an email folder and
will handle all of the logic for adding and removing emails. It contains the following data
values:
􀀁 private ArrayList<Email> emails
Stores all of the emails contained in this folder. (It can be any data collection,
ArrayList is only an example)
􀀁 private String name
Stores the name of the folder.
􀀁 private String currentSortingMethod
Stores the current sorting method (however that you see fit) so that emails added
can be properly sorted without having to first resort the folder. Notes: Default is date
descending.
It also has the following methods (including the usual constructor and accessor/mutators
methods):
􀀁 public void addEmail(Email email)
Adds an email to the folder according to the current sorting method.
􀀁 public Email removeEmail(int index)
Removes an email from the folder by index.
􀀁 public void sortBySubjectAscending()
􀀁 Sorts the emails alphabetically by subject in ascending order.
􀀁 public void sortBySubjectDescending()
􀀁 Sorts the emails alphabetically by subject in descending order.
􀀁 public void sortByDateAscending()
􀀁 Sorts the emails by date in ascending order.
􀀁 public void sortByDateDescending()
􀀁 Sorts the emails by date in descending order.
3. Write a fully documented class named Mailbox. This class represents an email box and it
will contain all of the folders and the remaining logic. It contains the following data values:
􀀁 private Folder inbox
Stores the inbox, which is a special folder which should never be allowed to be
deleted or renamed. All new emails go here.
􀀁 private Folder trash
􀀁 Stores the trash, which is a special folder which should never be allowed to be
deleted or renamed. When an email is deleted, it is moved here.
􀀁 private ArrayList<Folder> folders
Stores all of the custom folders contained in the mailbox. (It can be any data
collection, ArrayList is only an example)
􀀁 public static Mailbox mailbox
Stores the main mailbox that will used by the application. This mailbox should be
instantiated in the main method.
It also contains the following methods (and a main method):
􀀁 public void addFolder(Folder folder)
Adds the given folder to the list of custom folders. Note: check to make sure a folder
with that given name does not already exist. If it does, return an error in some
manner.
􀀁 public void deleteFolder(String name)
Removes the given folder from the list of custom folders
􀀁 public void composeEmail()
Gets user input on the contents of the email and adds it to the inbox.
􀀁 public void deleteEmail(Email email)
Moves the email to the trash. (This method shouldn’t remove any emails from
folders, the method removeEmail should be called and then deleteEmail is called on
the result)
􀀁 public void clearTrash()
Removes all emails from the trash folder.
􀀁 public void moveEmail(Email email, Folder target)
Takes the given email and puts in in the given folder. If the folder cannot be found,
instead move it to the Inbox. (Again, this method shouldn’t remove any emails from
folders, the method removeEmail should be called and then moveEmail is called on
the result)
􀀁 public Folder getFolder(String name)
Returns a folder by folder name.
4. When the program begins, it should see if the file "mailbox.obj" exists in the current
directory. If so, it should initialize the mailbox with the data in this file using serialization.
Otherwise, your program will start with an empty mailbox. Then, the program should provide
the user with a menu with the following options.
A – Add folder
Prompts the user for folder name, and creates and adds a new folder with the specified
name to the list of folders.
R – Remove folder
Prompts the user for folder name and removes the folder if a folder with the given name
exists.
C – Compose email
Prompts the user for TO, CC, BCC, Subject, and then Body and creates a new email and
adds it to the inbox.
F – View Folder
Prompts the user for folder name, if the folder is found, the folder submenu is opened
for that specific folder which displays all of the emails in the folder.
I – View Inbox
Opens the folder submenu for the inbox.
T – View Trash
Opens the folder submenu for the trash.
E – Empty Trash
Empties the trash folder of all emails.
Q - Quit the program
Remember to save the contents of the mailbox to the file, "mailbox.obj".
There is no option to load or save a file in the menu. This is because you should
automatically search for a file named "mailbox.obj" upon startup, and save to the file when
the user wishes to quit the program.
Folder submenu:
M – Move email
Prompts the user for email index and then displays a list of folders and asks the user to
input the name of the folder to move to. I
f the specified folder was not found, cancel the
entire operation. User should be able to move to Inbox, Trash, and the current folder.
D – Delete email
Prompts the user for email index and moves the email to the trash folder.
V – View email contents
Prompts the user for email index and prints the information about the corresponding
email.
SA – Sort by subject ascending
Sorts the emails by subject in ascending order.
SD – Sort by subject descending
Sorts the emails by subject in descending order.
DA – Sort by date ascending
Sorts the emails by date in ascending order.
DD – Sort by date descending
Sorts the emails by date in descending order.
R – Return to main menu
4. Include exception classes or additional classes as needed.
OUTPUT FORMAT
• Be sure to have a menu after each operation.
• Display to the user any errors that seem appropriate at any point during
execution of your program.
*/