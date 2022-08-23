/**
* Fully-documented class named folder where this class represents an email folder 
* Also it will handle all of the logic for adding and removing emails.
*
* @author: Anubrota Majumdar
* @Due: 08/12/2022
* @ID: 114586887
* @Assignment: HW4 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
*/


import java.io.Serializable;
import java.util.*;

public class Folder implements Serializable {
	private ArrayList<Email> emails;
	private String name;
	private String currentSortingMethod;
	public final String Date_Descending = "DD";
	public final String Date_Ascending= "DA";
	public final String Sub_Ascending = "SA";
	public final String Sub_Descending = "SD";

	public Folder(String name) 
	{
		this.name = name;
		emails = new ArrayList<Email>();
		setSortingMethod(Date_Descending); 
	}


	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public ArrayList<Email> getEmails()
	{
		return emails;
	}
	
	public void setSortingMethod(String type)
	{
		switch(type)
		{
			case "DD" : 
			{
				currentSortingMethod=Date_Descending;
				break;
			}
			case "DA":
			{
				currentSortingMethod=Date_Ascending;
				break;
			}
			case "SA":
			{
				currentSortingMethod=Sub_Ascending;
				break;				
			}
			case "SD":
			{
				currentSortingMethod=Sub_Descending;
				break;
			}
		}
		
	}
	
	public String getSortingMethod()
	{
		return currentSortingMethod;
	}
	
	private int subjIndex(Email myMail) 
	{		
		boolean asc;
		String sub;
		if(getSortingMethod()== Sub_Ascending)
		{
			asc=true;			
		}
		else
		{
			asc=false;
		}
		sub = myMail.getSubject();
		
		if (emails.isEmpty()==true)
		{
			return -1;
		}
		else
		{		
			int i=0;
			for(Email email : emails)
			{
				
				if (asc== true && sub.compareTo(email.getSubject()) < 0) 
				{
					return i;
				}
				else if (asc==false && sub.compareTo(email.getSubject()) > 0)
				{
					return i;
				}
				i++;
			}
			return i;
		}
		
	}
	
 	public void addEmail(Email email) 
 	{
 		String curMethod;
 		int index=0;
 		curMethod = getSortingMethod();
 		
 		switch (curMethod)
 		{
 			case Date_Descending: 
 			{
 				emails.add(email);
 				break;
 			}
 			case Date_Ascending:
 			{
 				emails.add(index,email);
 				break;
 			}
 			case Sub_Ascending:
 			{
 				index=subjIndex(email);
 				if(index==-1)
 				{
 					emails.add(email);
 				}
 				else
 				{
 					emails.add(index,email);
 				}
 				
 				break;
 			}
 			case Sub_Descending:
 			{
 				index=subjIndex(email);
 				if(index==-1)
 				{
 					emails.add(email);
 				}
 				else
 				{
 					emails.add(index,email);
 				}
 				
 				break;
 			}
		}
		
	}

	public Email removeEmail(int index) {
		if (index >= 1 && index <= emails.size())
			return emails.remove(index - 1);
		else
			return null;
	}


	public void sortBySubjectAscending() 
	{
		setSortingMethod(Sub_Ascending);
	}

	public void sortBySubjectDescending()
	{
		setSortingMethod(Sub_Descending);
	}

	public void sortByDateAscending() 
	{
		setSortingMethod(Date_Ascending);
	}

	public void sortByDateDescending() 
	{
		setSortingMethod(Date_Descending);
	}

}
