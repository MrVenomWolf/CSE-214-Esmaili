/**
* fully-documented class named named RequestQueue that must be derived as a subclass of ArrayList (or other class) from the Java API. 
* Also provided a constructor and the standard methods enqueue(), dequeue(), size(), and isEmpty()
*
* @author: Anubrota Majumdar
* @Due: 07/28/2022
* @ID: 114586887
* @Assignment: HW3 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
*/



import java.util.LinkedList;

public class RequestQueue extends LinkedList<Request>
{
	private int size;
	LinkedList<Request> s= new LinkedList<>();
	
	public RequestQueue() // Constructor
	{
		s=null;
		size=0;
	}
	
	public void enqueue(Request request){
		size++;
		this.addLast(request);
	
	
		
	}
	public void push(Request request)
	{
		this.enqueue(request);
	}
	
	public Request dequeue()
	{
		
		size--;
		return this.removeFirst(); // is deleting first element 
	}
	
	public Request pop()throws IllegalArgumentException{
		if(isEmpty()==false)
			return dequeue();
		else
			throw new IllegalArgumentException();		
	}
	
	public  boolean isEmpty()
	{
		if(this.size()<=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getSize()
	{
		return this.size;
	}
	
}
	
	
