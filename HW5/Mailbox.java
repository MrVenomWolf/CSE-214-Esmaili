/**
* Fully-documented class named folder where this class represents an mailbox folder 
* Also it will handle all of the logic for adding and removing emails.
* This class will contain all of the folders and the remaining logic. It contains the following data values 
*
* @author: Anubrota Majumdar
* @Due: 08/12/2022
* @ID: 114586887
* @Assignment: HW4 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
*/
	
import java.io.*;
import java.util.*;

public class Mailbox implements Serializable {
	private Folder inbox;
	private Folder trash;
	private ArrayList<Folder> folders;

	public static Mailbox myMailBox;
	static Scanner sc = new Scanner(System.in);
	// Done
	public Mailbox() 
	{
		inbox = new Folder("Inbox");
		trash = new Folder("Trash");
		folders = new ArrayList<Folder>();
	}

	// Done
	public void addFolder(Folder folder) 
	{
		String myFolderName;
		myFolderName = folder.getName();

		if (getFolder(myFolderName) == null) 
		{
			folders.add(folder);
		}
		else 
		{
			System.out.println(myFolderName + " Already exists.");
		}

	}

	// Done
	public void deleteFolder(String name) 
	{
		char option;
		for (int i = 0; i < folders.size(); i++) 
		{
			if (folders.get(i).getName().equalsIgnoreCase(name)) 
			{
				System.out.println("Are you sure to delete? (y/n)");
				option=sc.next().charAt(0);
				if(option=='y' || option=='Y')
				{
					folders.remove(i);
				}
				
			} 
			else 
			{
				System.out.println(name + " Not Found");
			}

		}
	}
// Done
	public void composeEmail() {
		String to, cc, bcc,sub, body;
		
		Email email = new Email();
		
		System.out.print("Enter Recipient (To): ");
		 to = sc.next();
		 sc.nextLine();

		System.out.print("Enter CC recipients: (Double enter to skip) ");
		cc = sc.nextLine();
		 sc.nextLine();
		System.out.print("Enter BCC recipients:  (Double enter to skip) ");
		bcc = sc.nextLine();
		 sc.nextLine();
		System.out.print("Enter Subject Line: ");
		sub = sc.next();
		 sc.nextLine();
		System.out.println("Enter Body:");
		body = sc.nextLine();
		
		email.setTo(to);
		email.setCc(cc);
		email.setBcc(bcc);
		email.setSubject(sub);
		email.setBody(body);
		email.setTimestamp((GregorianCalendar) GregorianCalendar.getInstance()); // now current time
				
		myMailBox.inbox.addEmail(email);
		System.out.println("Email successfully added to Inbox.");
	}

	//Done
	public void deleteEmail(Email email) 
	{
		if (email == null)
		{
			System.out.println("Invalid Email.");
		}
		else
		{
			trash.addEmail(email);
		}
	}
    
	// Done
	public void clearTrash() 
	{
		int totalEmail;
		char option;
		totalEmail = trash.getEmails().size();
		System.out.println(totalEmail+ " Email(s) found. ");
		System.out.println("Are you sure to delete all mail permanently (y/n)");
		option=sc.next().charAt(0);
		if(option=='y' || option=='Y')
		{
			trash.getEmails().clear();
			System.out.println(totalEmail + " mail(s) deleted.");
		}
	}

	// Done
	public void moveEmail(Email email, Folder target) 
	{
		if(target==null)
		{
			System.out.println("Wrong folder name, please try again.");
		}
		else if(email==null)
		{
			System.out.println("Wrong Email. please try again.");
		}
		else
		{
			target.addEmail(email);	
		}
	}
		

	// Done
	public Folder getFolder(String name) {
		if (name.equalsIgnoreCase("Inbox")) {
			return inbox;
		} else if (name.equalsIgnoreCase("Trash")) {
			return trash;
		} else {
			for (int i = 0; i < folders.size(); i++) {
				if (folders.get(i).getName().equalsIgnoreCase(name)) {
					return folders.get(i);
				}
			}
		}
		return null; // name does not found
	}

	// Done
	private static void listFolders() {
		System.out.println(myMailBox.inbox.getName());
		System.out.println(myMailBox.trash.getName());
		// System.out.println(mailbox.folders.size()+" folders"); // testing
		for (int i = 0; i < myMailBox.folders.size(); i++) {
			System.out.println(myMailBox.folders.get(i).getName());
		}
	}

	// Done
	static void checkMailBox() {
		try {
			FileInputStream fISystem = new FileInputStream("mailbox.obj");
			ObjectInputStream oinStream = new ObjectInputStream(fISystem);
			myMailBox = (Mailbox) oinStream.readObject();
			// System.out.println("Mailbox created..."); // testing
			fISystem.close();
		} catch (Exception ex) {
			System.out.println("Previous save not found, starting with an empty mailbox.");
			myMailBox = new Mailbox();
		}
	}
//=
	private static void folderSubmenu(String folderName) 
	{
		Folder folder = myMailBox.getFolder(folderName);
		if (folder == null) 
		{
			System.out.println(folderName+ " not found. ");
			return;
		}
		else
		{
			String choice="";
			ArrayList<Email> emails = folder.getEmails();
			int index;
			Email email;
			while (choice.equals("R")==false)
			{
				System.out.println(folder.getName());
				if (emails.size() == 0)
				{
					System.out.println(folder.getName() + " is empty. ");
				}
				else 
				{
					System.out.printf("%5s|%30s|%s\n", "Index", "Time", "Subject");
					for (int i = 0; i < emails.size(); i++) 
					{
						email = emails.get(i);
						System.out.printf("%5s|%30s|%s\n", (i + 1), email.getTimestamp().getTime(), email.getSubject());
					}
				}
				// sub menu
				System.out.println();
				System.out.println("M – Move email");
				System.out.println("D – Delete email");
				System.out.println("V – View email contents");
				System.out.println("SA – Sort by subject ascending");
				System.out.println("SD – Sort by subject descending");
				System.out.println("DA – Sort by date ascending");
				System.out.println("DD – Sort by date descending");
				System.out.println("R – Return to main menu");
				System.out.print("Enter option: ");
				choice = sc.next().toUpperCase();
			
				switch (choice) 
				{
				case "M":
				{
					System.out.print("Enter the index of email to move: ");
					index = sc.nextInt();
				
					if (index >= 1 && index <= emails.size())
					{
						email = emails.get(index - 1);
					
						listFolders(); // showing all email
					
						System.out.println("Select a folder where you want to move");
						String targt = sc.next();
						Folder targetFolder = myMailBox.getFolder(targt);
						if (targetFolder == null)
						{
							System.out.println(targt+ " Not found");
						}
						else 
						{
							Email myMail;
							myMail=folder.removeEmail(index);
							
							myMailBox.moveEmail(myMail, targetFolder);
							System.out.println("" + email.getSubject() + " has successfully been moved to "+ targetFolder.getName());
						}
					}	 
					else
					{
						System.out.println("Invalid mail index.");
					}
					break;
				}
				
				case "D": // Delete mail
				{
					System.out.print("Enter email index of Inbox: ");
					index = sc.nextInt();
					sc.nextLine();
					int last=emails.size();
					if (index >= 1 && index <= last) 
					{						
						myMailBox.deleteEmail(folder.removeEmail(index));
					} 
					else
					{
						System.out.println("Invalid mail index.");
					}
					break;
				}
				
				case "V": // View email contents
				{
					System.out.print("Enter email index: ");
					index = sc.nextInt();
					sc.nextLine();
					int last=emails.size();
					if (index >= 1 && index <= last) 
					{
						System.out.println("\n Your Email : \n=====================================");
						email = emails.get(index - 1);
						System.out.println("To: " + email.getTo());
						System.out.println("CC: " + email.getCc());
						System.out.println("BCC: " + email.getBcc());
						System.out.println("Subject: " + email.getSubject());
						System.out.println("Email Body : \n"+email.getBody());
						System.out.println("===================================== \n");
					} 
					else
					{
						System.out.println("Invalid mail index.");
					}
					break;
				}
				case "SA":
				{
					folder.sortBySubjectAscending();
					break;
				}
				case "SD":
				{
					folder.sortBySubjectDescending();
					break;
				}
				case "DA":
				{
					folder.sortByDateAscending();
					break;
				}
				case "DD":
				{
					folder.sortByDateDescending();
					break;
				}
				case "R":					
				{
					break;
				}
				default:
				{
					System.out.println("Wrong choice. Try again");
				}
			} // end of switch
			} // end of while
		}
	}
	
	static void saveMailBox() 
	{
		try 
		{
			FileOutputStream foStream = new FileOutputStream("mailbox.obj");
			ObjectOutputStream objoutStream = new ObjectOutputStream(foStream);
			objoutStream.writeObject(myMailBox);
			objoutStream.close();
			System.out.println("All mail has been saved");
		}
		catch (Exception ex) 
		{
			System.err.println("Error : " + ex.getMessage());
		}

	}

	public static void main(String[] args) 
	{
		char option;
		String fName;

		checkMailBox(); // My first Task

		while (true) {
			System.out.println("Mailbox:");
			System.out.println("--------");
			listFolders();

			System.out.println();
			System.out.println(" A - Add folder. ");
			System.out.println(" R - Remove folder. ");
			System.out.println(" C - Compose email. ");
			System.out.println(" F - Open folder. ");
			System.out.println(" I - Open Inbox. ");
			System.out.println(" T - Open Trash. ");
			System.out.println(" E - Empty Trash. ");
			System.out.println(" Q - Quit. ");
			System.out.print("Enter option: ");
			option = sc.next().toUpperCase().charAt(0);
			System.out.println("You entered : " + option);
			try {
				switch (option) {
				case 'A': {
					System.out.print("Enter folder name: ");
					fName = sc.next();
					myMailBox.addFolder(new Folder(fName));
					break;
				}
				case 'R': {
					System.out.print("Enter folder name: ");
					fName = sc.next();
					myMailBox.deleteFolder(fName);
					break;
				}
				case 'C': {
					myMailBox.composeEmail();
					break;
				}
				case 'F':
					System.out.print("Enter folder name: ");
					fName = sc.next();
					folderSubmenu(fName);
					break;
				case 'I':
					folderSubmenu("Inbox");
					break;
				case 'T':
					folderSubmenu("Trash");
					break;
				case 'E':
					myMailBox.clearTrash();
					break;
				case 'Q': {
					saveMailBox();
					System.out.println("Good Bye !");
					System.exit(0);
					break;
				}
				default:
					System.out.println("Wrong choice. Try again.");
					break;
				}
			} 
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}

		}

	}
}
