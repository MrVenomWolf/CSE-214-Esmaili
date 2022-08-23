
/**
* Fully-documented class named Tree that will have a reference to the root of the tree and other useful methods.
*
* @author: Anubrota Majumdar
* @Due: 08/05/2022
* @ID: 114586887
* @Assignment: HW4 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
*/


/*
 * Please Note
 * 1. tree input file should be in C drive
 * 2. 
 */


import java.util.Scanner;

public class Tree 
{
	private TreeNode root;
	
	Scanner sc = new Scanner(System.in);
	private TreeNode parent;
	private TreeNode temp;
	private boolean isFound;
	private boolean complete;
	private boolean exit;

	public Tree() {// create tree only for root
		temp = null;
		parent = null;
		isFound = false;
		complete = false;
		exit = false;
		root = new TreeNode();
		
	}


	public TreeNode getRoot() {
		return root;
	}

	public TreeNode gettemp() {
		return temp;
	}

	public TreeNode getParent() {
		return parent;
	}

	public TreeNode getNodeReference(String label1) {
		//System.out.println("label 1 is (at first)"+ label1);
		//System.out.println("parent is (at first) "+ getRoot().getLabel());
		//System.out.println("Root is (at first)"+getRoot());
		if (getRoot().getLabel().equals(label1)) {
			//System.out.println("Returning : "+getRoot());
			return getRoot();
		} else {
			temp = getNodeReference(root, label1);
			this.setisFound(false);
			return temp;
		}
	}

	public void getPreorder() {
		setPreorder(this.getRoot());
	}

	public void setPreorder(TreeNode node) {
		System.out.println(node.toString() + "\n");// testing

		if (node.getLeft() != null)
		{
			setPreorder(node.getLeft());
		}
		if (node.getMiddle() != null)
		{
			setPreorder(node.getMiddle());
		}
		if (node.getRight() != null)
		{
			setPreorder(node.getRight());
		}
	}
	
	public TreeNode getNodeReference(TreeNode node, String label1) {
		if (node.getLeft() != null)
			getNodeReference(node.getLeft(), label1);
		if (isFound == true)
			return temp;
		if (node.getMiddle() != null)
			getNodeReference(node.getMiddle(), label1);
		if (isFound == true)
			return temp;
		if (isFound == false)
			if (node.getRight() != null)
				getNodeReference(node.getRight(), label1);
		if (isFound == true)
			return temp;
		if (node.getLabel().equals(label1)) {
			isFound = true;
			temp = node;
			return temp;
		} else
			return null;
	}

	public boolean getHelpExit() {
		return exit;
	}

	public void getAllChildPrompts(TreeNode node) {
		int i;
		boolean exit = node.isLeaf();
		while (exit == false) {
			for (i = 0; i < 3; i++) {
				
				if(i==0)
				{
					if (node.getLeft() != null) 
					{
						System.out.println("1. " + node.getLeft().getPrompt());
					}
				}
				else if(i==1)
				{
					if (node.getMiddle() != null) 
					{
						System.out.println("2.  " + node.getMiddle().getPrompt());
					}
				}
				else if(i==2)
				{
					if (node.getRight() != null)
					{
						System.out.println("3. " + node.getRight().getPrompt());
					} 
					else if (node.getRight() == null)
					{
						exit = true;
						
					}
					exit = true;
					
				}
				
			}
		}
	}
	

	public boolean getcomplete() {
		return complete;
	}

	public boolean getisFound() {
		return isFound;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void settemp(TreeNode temp) {
		this.temp = temp;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public void setisFound(boolean isFound) {
		this.isFound = isFound;
	}

	public void setcomplete(boolean complete) {
		this.complete = complete;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	
	public boolean addNodeLeft(TreeNode node, TreeNode parent) {
		if (parent != null) 
		{
			parent.setLeft(node);
			parent.setIsLeft(true);
			node.setParent(parent);
			return true;
		} 
		else
		{
			return false;
		}
	}

	public boolean addNodeMiddle(TreeNode node, TreeNode parent) {
		if (parent != null) {
			parent.setMiddle(node);
			parent.setIsMiddle(true);
			node.setParent(parent);
			return true;
		} 
		else
		{
			return false;
		}
	}

	public boolean addNodeRight(TreeNode node, TreeNode parent) {
		if (parent != null) {
			parent.setRight(node);
			parent.setIsRight(true);
			node.setParent(parent);
			return true;
		} else
		{
			return false;
		}
	}

	public void beginSession() {
		System.out.println("Help Session Starting...");
		helpSession(this.getRoot());
	}

	public void helpSession(TreeNode node) {
		while (exit == false) {
			if (node.isLeaf() == true)
			{
				System.out.println(node.getMessage() + "\n");
				exit = true;
			} 
			else 
			{
				System.out.println(node.getMessage());
				getAllChildPrompts(node);
				
				System.out.println("0. exit");

				System.out.println("Choice :  ");

				int option = sc.nextInt();

				switch (option) {
				case 0:
					exit = true;
					System.out.println("Help session Ended. Thanks. \n\n");
					break;
				case 1:
					helpSession(node.getLeft());
					break;
				case 2:
					helpSession(node.getMiddle());
					break;
				case 3:
					helpSession(node.getRight());
					break;
				
				default:
					System.out.println(" Wrong choice, \n");
					break;
				}
			}
		}
	}

	public boolean addNode(String label, String prompt, String message, String parentLabel) 
	{
		//System.out.println("Parent label : "+ parentLabel);
		parent = getNodeReference(parentLabel); 
		//System.out.println("Parent is "+ parent); // testing
		temp = new TreeNode(label, message, prompt);
		//System.out.println("is left : "+ parent.getIsLeft()); // testing
		if (parent.getIsLeft() == false) 
		{
			complete = addNodeLeft(temp, parent);
		}
		else if (parent.getIsMiddle() == false) 
		{
			complete = addNodeMiddle(temp, parent);
		} 
		else if (parent.getIsRight() == false) 
		{
			complete = addNodeRight(temp, parent);
		}
		
		return complete;
	}

	public int beginSession(TreeNode node)
	{
		if (node.isLeaf() == true)
		{
			System.out.println(node.getMessage());
			System.out.println("\n Thank you for using this automated help service!");
			return 1;
		} 
		else 
		{
			System.out.println(node.getMessage());
			getAllChildPrompts(node);
			System.out.println("0 Quit");
			return 0;
		}

	}

	
}
