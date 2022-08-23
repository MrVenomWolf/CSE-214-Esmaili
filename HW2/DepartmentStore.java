/*Anubrota Majumdar, 114586887, Recitation 30*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DepartmentStore {

	
	public static void main(String[] args) throws IOException {
		ItemList list = new ItemList();

		String name, loc, RFID, dest, CartNo; // for insertInfo
	double price;
	char option;


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) { // Infinity LOop
			System.out.println("\n Welcome!!");
			System.out.println("\n C - Clean Store");
			System.out.println(" I - Insert an Item into the list");
			System.out.println(" L - List by location");
			System.out.println(" M - Move an item in the store");
			System.out.println(" O - Checkout");
			System.out.println(" P - Print all items in store");
			System.out.println(" R - Print by RFID tag number");
			System.out.println(" U - Update inventory system");
			System.out.println(" Q - Exit the program");
			System.out.println(" Please select an Option : ");
			
				option = br.readLine().charAt(0);
			
			try {
				switch (option) {
				case 'C': // for capital letter (Upper case) Input
				case 'c': // for small letter(lower case) input
					list.cleanStore();
					break;
				case 'I':
				case 'i': {
					// input for item info (name, rfid, price, location)
					System.out.println("Enter the Item name : "); 
					name = br.readLine();
					System.out.println("Enter the RFID Code (9 Digit Hexa Code): ");
					RFID = br.readLine();

					if (RFID.length() != 9) { // validating RFID Code
						System.out.println("Invalied RFID number. enter again");
						break;
					}
					else{
						try{
							Long x = Long.parseLong(RFID, 16);  // checking is it hexa or not  (01234567890ABCDEF)
						}
						catch(NumberFormatException ex){
							System.err.println("Invalied RFID number. enter again");
							break;
						}

					}
					System.out.println("Enter the price : ");
					price = Double.parseDouble(br.readLine());
					System.out.println(
							"Enter the Original Location (should start from 's' followed by 5 digit shelf number) : ");
					loc = br.readLine();
					if (loc.startsWith("s") == false || loc.length() != 6) {

						System.out.println(
								"Location should start from 's' followed by 5 digit shelf number. enter again");
						break;
					}

					list.insertInfo(name, RFID, price, loc); // calling insertInfo

				}

					break;
				case 'L':
				case 'l': {
					System.out.println("Enter Current Location");
					loc = br.readLine();
					list.printByLocation(loc);
				}
					break;
				case 'M':
				case 'm': {
					// move();
					System.out.println("Enter RFID Tag number :");
					RFID = br.readLine();
					System.out.println("Enter Original Location");
					loc = br.readLine();
					System.out.println("Enter Destination Location / Cart number");
					dest = br.readLine();
					// validating Destination number
					if ((dest.startsWith("s") == true && dest.length() == 6)
							|| (dest.startsWith("c") == true && dest.length() == 4)) {
						list.moveItem(RFID, loc, dest);
					} else {
						System.out.println("Invalid Destination number or Cart number");
						break;

					}
				}
					break;
				case 'O':
				case 'o': {// checkout
					System.out.println("Enter Cart number : ");
					CartNo = br.readLine();
					price = list.checkOut(CartNo);
					System.out.println("The total cost for all merchandise in cart " + CartNo + " was " + price);// returning total price

				}
					break;
				case 'P':
				case 'p':
					list.printAll();
					break;
				case 'R':
				case 'r': {
					// printByRFID();
					System.out.println("Enter the RFID");
					RFID = br.readLine();
					list.printByRFID(RFID);

				}
					break;
				case 'U':
				case 'u': {
					// removeAllPurchased
					list.removeAllPurchased();
				}
					break;
				case 'Q':
				case 'q':
					System.out.println("Goodbye! ");
					System.exit(0);
					break;
				default:
					System.out.println("Wrong choice. Please try again. ");
					break;
				}
			} // end of try
			catch (Exception ex) {
				System.err.println("Error : " + ex.getMessage());

			}
		}
	}  

} 
