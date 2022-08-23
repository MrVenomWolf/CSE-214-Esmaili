/**
* A fully-documented class named TreeDriver which contains the main() method and it should display a menu:

    L (Load input file and build a tree)
    Prompt the user for a file name and build a new tree. The entire tree will be recreated each time this menu option is chosen.
    H (Start help session) 

    If the node is a leaf, then display the message and go back to the main menu. For example:

     You have to put in quarters to start the Washing Machine.
     Thank you for using our automated help system.
    

    T (Traverse the tree in pre-order)
    Traverse the tree in pre-order and display the label, prompt, and message in each node on a separate line (see sample input/output).
    The order is root, left subtree, middle subtree, right subtree.
    Q (Quit)
    Quit the program
*
* @author: Anubrota Majumdar
* @Due: 08/05/2022
* @ID: 114586887
* @Assignment: HW4 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
*/

import java.io.*;
import java.util.Scanner;

public class TreeDriver 
{
	private boolean treeCreated;
	Tree tree= new Tree();

	public TreeDriver()
	{
		
		treeCreated= false;
	}
	public void setTree(Tree tree)
	{
		this.tree= tree;
	}
	public Tree getTree()
	{
		return tree;
	}
	private void loadNewTree(String fileName) throws FileNotFoundException
	{
		try
		{
		File file= new File("C:\\"+fileName);
		Scanner scfile = new Scanner(file);
		
		int load = 0;
		String label, message, parentLabel, prompt, noOfChild, line;
		
		if(scfile.hasNextLine())
		{
			//System.out.println("file found "+fileName); // Testing
			// this is for root...
			setTree(new Tree());
			line = scfile.nextLine();
			line.trim();
			getTree().getRoot().setLabel(line);
			//System.out.println("label is : "+ line);// testing
			line = scfile.nextLine();
			line.trim();
			getTree().getRoot().setPrompt(line);
			//System.out.println("Prompt is : "+ line);// testing
			line = scfile.nextLine();
			line.trim();
			getTree().getRoot().setMessage(line);
		// System.out.println("Message is : "+ line);// testing
		 
		 while (scfile.hasNextLine()) 
			{
			  	parentLabel = scfile.next(); //test
				noOfChild = scfile.nextLine();
				//System.out.println("No of Child before substring : "+noOfChild);// testing
				noOfChild = noOfChild.substring(1, 2);
				//System.out.println("Parent label : "+parentLabel);// testing
				//System.out.println("No of Child : "+noOfChild);// testing
				
				int x = Integer.parseInt(noOfChild); // converting for loop
				
				for (int i = 1; i <= x; i++) // child times
				{
					label = scfile.nextLine();
					prompt = scfile.nextLine();
					message = scfile.nextLine();
					
					tree.addNode(label, prompt, message, parentLabel); // 
					
				}
			}
			treeCreated = true;
		 System.out.println("Tree loaded Successfully. ");
		}
		else
		{
			System.err.println("File not found. Please try again.");
			System.err.println("Make sure the input file is in the C drive.");
		}
		}
		catch (FileNotFoundException exf) {
			System.err.println("Error : "+ exf.getMessage());
			System.err.println("Make sure the input file is in the C drive.");
		}
		/*catch (Exception ex) {
			System.err.println("Error : "+ ex.getMessage());
			System.err.println("Make sure the input file is in the C drive.");
		}*/
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		TreeDriver td= new TreeDriver();
		Scanner sc = new Scanner(System.in);
		char option;
		String fileName=null;
		while (true) {
			System.out.println("\n");
			System.out.println(" L -  Load a Tree.");
			System.out.println(" H - Begin a Help Session.");
			System.out.println(" T - Traverse the Tree in preorder.");
			System.out.println(" Q - Quit. ");
			System.out.println(" Choice > ");
			option = sc.next().charAt(0);
			switch (option) {
			case 'l':
			case 'L': {
				System.out.println("Enter the file name : ");
				sc.nextLine();
				fileName= sc.nextLine();
				td.loadNewTree(fileName);
				
				break;
			}
			case 'h':
			case 'H': 
			{
				if (td.treeCreated == true) 
				{
					td.getTree().setExit(false);
					td.getTree().beginSession();					
					System.out.println("Thank you for using this automated help service!");
				} 
				else
				{
					System.out.println("No tree found. Please load the tree");
				}
				break;
			}
			case 't':
			case 'T': 
			{
				if (td.treeCreated == true) {
					System.out.println("Traversing the tree in preorder:");
					td.getTree().getPreorder();
				} else
					System.out.println("No tree found. Please load the tree");
				break;
			}
			case 'q':
			case 'Q': 
			{
				System.out.println("Thank you for using our automated help services!");
				System.exit(0);
				break;
			}
			default:
				System.err.println("Wrong choice, Please try again. \n ");
				break;
			}
		}

	} // end of main

}// End of class
