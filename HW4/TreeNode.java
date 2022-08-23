/**
* Fully-documented class named TreeNode that stores the data in each node
* This class should have a constructor, mutator and accessor methods for each instance variable. 
*
* @author: Anubrota Majumdar
* @Due: 08/05/2022
* @ID: 114586887
* @Assignment: HW4 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
*/
public class TreeNode 
{
	private String label; // 
	private String message; //
	private String prompt;
	
	TreeNode left;
	TreeNode right;
	TreeNode middle;
	TreeNode parent;

	private int nextChild;
	private boolean isLeft;
	private boolean isRight;
	private boolean isMiddle;

	public TreeNode() {// default constructor
		label = null;
		message = null;
		prompt = null;
		left = null;
		middle = null;
		right = null;
		nextChild = 0;
		isLeft = false;
		isRight = false;
		isMiddle = false;
		parent = null;
	}

	public TreeNode(String label, String message, String prompt)
	{
		this.setLabel(label);
		this.setMessage(message);
		this.setPrompt(prompt);

		left = null;
		middle = null;
		right = null;
		nextChild = 0;
		isLeft = false;
		isRight = false;
		isMiddle = false;
		parent = null;
	}

	public int getNextChild() 
	{
		return (nextChild % 3);
	}

	public void setNextChild(int nextChild)
	{
		this.nextChild = nextChild;
	}

	public TreeNode getLeft()
	{
		return left;
	}

	public void setLeft(TreeNode left) 
	{
		this.left = left;
	}

	public TreeNode getMiddle()
	{
		return middle;
	}

	public void setMiddle(TreeNode middle) 
	{
		this.middle = middle;
	}
	
	public TreeNode getRight()
	{
		return right;
	}
	
	public void setRight(TreeNode right)
	{
		this.right = right;
	}


	public TreeNode getParent()
	{
		return parent;
	}

	public void setParent(TreeNode parent) 
	{
		this.parent = parent;
	}

	public String getLabel() 
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}
	
	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getPrompt() 
	{
		return prompt;
	}

	public void setPrompt(String prompt) 
	{
		this.prompt = prompt;
	}
	
	public boolean getIsLeft() 
	{
		return isLeft;
	}

	public void setIsLeft(boolean isLeft) 
	{
		this.isLeft = isLeft;
	}

	public boolean getIsRight() 
	{
		return isRight;
	}

	public void setIsRight(boolean isRight) 
	{
		this.isRight = isRight;
	}

	public boolean getIsMiddle() 
	{
		return isMiddle;
	}
	
	
	public void setIsMiddle(boolean isMiddle) 
	{
		this.isMiddle = isMiddle;
	}

	@Override
	public String toString() 
	{
		return "Label: " + this.getLabel() + "\nPrompt: " + this.getPrompt() + "\nMessage: " + this.getMessage();

	}

	public boolean isLeaf() {
		if (getLeft() == null && getMiddle() == null && getRight() == null) 
		{
			return true;
		}
		 else
		{
			return false;
		}
	}

}