//Anubrota Majumdar, 114586887, Recitation 30
public class ItemList {
	ItemInfoNode head; // class variable Head
	ItemInfoNode tail;

	public ItemList() {

	}
	
	public void insertInfo(String name, String rfidTag, double price, String initPosition) { // the order of complexity is O(n).
		ItemInfoNode temp = new ItemInfoNode(); // temp is holding a new node like malloc function in C
		 ItemInfoNode temp1;
	
		

		if (head == null) // list is empty
		{
			head = temp; // head is holding 1st node.
			temp.prev = null;
			temp.next = null;

		} else if (head.next == null) // for only 1 node is there
		{
			head.next = temp;
			temp.prev = head;

		} else { // more than 1 node is there

			temp1 = head;

			while (temp1.next != null) { // finding the last node
				temp1 = temp1.next;

			}
			temp1.next = temp; // linking with last node;

		} // end of else

		// assigning all data
		temp.info.name = name;
		temp.info.rfidTagNumber = rfidTag;
		temp.info.price = price;
		temp.info.OriginalLocation = initPosition;
		temp.info.CurrentLocation = initPosition;

		temp.next = null;

	}

	public void removeAllPurchased() //the order of complexity is O(n)
	// U, Update
	{
		// delete "out"
		
		ItemInfoNode temp1, temp2;
		temp1=head;
		
		int found=0;
		
		 while(temp1!=null) // finding location 
		 {
			 
			 if(temp1.info.CurrentLocation.equalsIgnoreCase("Out") == false)
			 {
				 temp1= temp1.next;	//Not found  // o(1)
			 }
			 else
			 {
				found=1;//Data found
				 break;				 
			 }
		 }
		 if(found==1)
		 {
			 System.out.println(String.format("%-21s %-16s %-19s %-19s %-6s", "Name", "RFID", "Original Location",
						"Current Location", "Price"));
				System.out.println(String.format("%-21s %-16s %-20s %-20s %-6s", "--------", "---------",
						"-----------------", "---------------", "-------"));
				temp1=head;
				while (temp1 != null) {
					if(temp1.info.CurrentLocation.equalsIgnoreCase("Out"))
					{
						System.out.println(String.format("%-21s %-15s %-20s %-20s %6.2f", temp1.info.name, temp1.info.rfidTagNumber,
									temp1.info.OriginalLocation, temp1.info.CurrentLocation, temp1.info.price));

						
					}
					temp1 = temp1.next;
				}
			 
			 // removing nodes
				temp1=head;
				while(temp1.next.info.CurrentLocation.equalsIgnoreCase("Out")==false )
				{
					temp1=temp1.next;		
				}
				if(temp1.next.next!=null)
				{
					temp2=temp1.next.next;
					temp1.next=temp2; // removing out
				}
				else
				{
					temp1.next=null;
				}
				
				
				
		 }
		 else
		 {
			 System.out.println("No item can be remove.");
		 }
		 
		
	}

	public void printByRFID(String rfidTag)  // the order of complexity is O(n).
	{
		int found=0;
		 ItemInfoNode temp1= head;
		 while(temp1!=null) // finding location 
		 {
			 
			 if(temp1.info.rfidTagNumber.equalsIgnoreCase(rfidTag) == false)
			 {
				 temp1= temp1.next;
				//Not found
				 
			 }
			 else
			 {
				found=1;
				//Data found
				 break;
				 
			 }
		 }
			 
			 if(found==1)
			 {
				 System.out.println(String.format("%-21s %-16s %-19s %-19s %-6s", "Name", "RFID", "Original Location",
							"Current Location", "Price"));
					System.out.println(String.format("%-21s %-16s %-19s %-19s %-6s", "--------", "---------",
							"-----------------", "---------------", "-------"));
					temp1=head;
					while (temp1 != null) {
						if(temp1.info.rfidTagNumber.equalsIgnoreCase(rfidTag))
						{
							System.out.println(String.format("%-21s %-15s %-19s %-19s %6.2f", temp1.info.name, temp1.info.rfidTagNumber,
										temp1.info.OriginalLocation, temp1.info.CurrentLocation, temp1.info.price));

							
						}
						temp1 = temp1.next;
					}
				 
				 
			 }
			 else
			 {
				 System.out.println("RFID tag Not Found. try again");
			 }
		
	}
	public boolean moveItem(String rfidTag, String source, String dest) {  // the order of complexity is O(n).
	
		int found=0;
		 ItemInfoNode temp1= head;
		 while(temp1!=null) // finding location 
		 {
			 
			 if(temp1.info.rfidTagNumber.equalsIgnoreCase(rfidTag) == false && temp1.info.OriginalLocation.equalsIgnoreCase(source)==false)
			 {
				 temp1= temp1.next;	//Not found
			 }
			 else
			 {
				found=1;  //Data found
				 break;
			 }
		 }
	
		 if(found==0)
		 {
			 System.out.println("Invalid RFID or Location. please try again.");
			 return false;
		 }
		 else
		 {
			 temp1=head;
				while (temp1 != null) {
					if(temp1.info.rfidTagNumber.equalsIgnoreCase(rfidTag) && temp1.info.OriginalLocation.equalsIgnoreCase(source))
					{
						
						temp1.info.CurrentLocation=dest;			
					}
					temp1 = temp1.next;
				}
				System.out.println("Item moved successfully.");
			return true; 
		 }
		
	}

	public void printAll() // the order of complexity is O(n).
	{
		ItemInfoNode temp;

		if (head == null)// list is empty
		{
			System.out.println("The list is empty. Try again. \n");
		} else {
			temp = head;
			System.out.println(String.format("%-21s %-16s %-19s %-19s %-6s", "Name", "RFID", "Original Location",
					"Current Location", "Price"));
			System.out.println(String.format("%-21s %-16s %-20s %-20s %-6s", "--------", "---------",
					"-----------------", "---------------", "-------"));
		
			while (temp != null) {
				System.out.println(String.format("%-21s %-15s %-19s %-19s %6.2f", temp.info.name, temp.info.rfidTagNumber,
								temp.info.OriginalLocation, temp.info.CurrentLocation, temp.info.price));

				temp = temp.next;
			}

		}
	}

	public void printByLocation(String location) { // the time complexity is  0(n)
		int found=0;
	 ItemInfoNode temp1= head;
	 while(temp1!=null) // finding location 
	 {
		 
		 if(temp1.info.CurrentLocation.equalsIgnoreCase(location) == false)
		 {
			 temp1= temp1.next;
			//Not found
			 
		 }
		 else
		 {
			found=1;
			//Data found
			 break;
			 
		 }
	 }
		 
		 if(found==1)
		 {
			 System.out.println(String.format("%-21s %-16s %-19s %-19s %-6s", "Name", "RFID", "Original Location",
						"Current Location", "Price"));
				System.out.println(String.format("%-21s %-16s %-19s %-19s %-6s", "--------", "---------",
						"-----------------", "---------------", "-------"));
				temp1=head;
				while (temp1 != null) { 
					if(temp1.info.CurrentLocation.equalsIgnoreCase(location))
					{
						System.out.println(String.format("%-21s %-15s %-19s %-19s %6.2f", temp1.info.name, temp1.info.rfidTagNumber,
									temp1.info.OriginalLocation, temp1.info.CurrentLocation, temp1.info.price));

						
					}
					temp1 = temp1.next;
				}
			 
			 
		 }
		 else
		 {
			 System.out.println("Location Not Found. try again");
		 }
	 }

	public void cleanStore() { // the order of complexity is O(n).
		// restore all current loc
		int count=0;
		 ItemInfoNode temp1= head;
		 temp1=head;
			while (temp1 != null) {
				if(temp1.info.CurrentLocation.equalsIgnoreCase(temp1.info.OriginalLocation)== false && temp1.info.CurrentLocation.equalsIgnoreCase("Out")== false && temp1.info.CurrentLocation.startsWith("s")== false)
				{
					temp1.info.CurrentLocation=temp1.info.OriginalLocation;	
					count++;
				}
				temp1 = temp1.next;
			}
			System.out.println(count + " items restored at the original location");

	}

	public double checkOut(String cartNumber) { // the order of complexity is O(n).
		double sum=0;
		
		int found=0;
		 ItemInfoNode temp1= head;
		 while(temp1!=null) // finding location 
		 {
			 
			 if(temp1.info.CurrentLocation.equalsIgnoreCase(cartNumber) == false)
			 {
				 temp1= temp1.next;
				//Not found
				 
			 }
			 else
			 {
				found=1;
				//Data found
				 break;
				 
			 }
		 }
		 if(found==0)
		 {
			 System.out.println("Cart Number not found. please try again.");
		 }
		 else
		 {
			 temp1=head;
				while (temp1 != null) {
					if(temp1.info.CurrentLocation.equalsIgnoreCase(cartNumber))
					{
						temp1.info.CurrentLocation="Out";	
						sum= sum+ temp1.info.price;
					}
					temp1 = temp1.next;
				}
	
		 }
		 
		 
		 
		 
		return sum; // Price
	}

}
