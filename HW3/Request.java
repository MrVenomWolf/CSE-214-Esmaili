/**
*  a class called Request that contains the following member variables:
*   sourceFloor (int)
*   destinationFloor (int)
*   timeEntered (int - the time that this request was placed on the queue) 
*
* @author: Anubrota Majumdar
* @Due: 07/28/2022
* @ID: 114586887
* @Assignment: HW3 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
*/

public class Request {
	private int sourceFloor;
	private int destinationFloor;
	private int timeEntered;
	private int max;
	private int arrival;
	
	
	public Request(int totalFloors) // constructor 
	{
		max= totalFloors;
	/*
	 *  the systax of Math.random is math.random()*(max-min)+min;
	 *  here totalFloors is max, and min is 1
	 */
	setSourceFloor((int) (Math.random()*(max-1)+1)  ); // 
	setDestinationFloor((int) (Math.random()*(max-1)+1));
	
	//System.out.println("Request occoured from "+getSourceFloor()+ " To "+ getDestinationFloor());// testing
		
	}
	
	
	public void setSourceFloor(int source)
	{
		sourceFloor= source;
	}
	public int getSourceFloor()
	{
		return sourceFloor;
	}
	
	
	public void setDestinationFloor(int destination)
	{
		destinationFloor= destination;
	}
	public int getDestinationFloor()
	{
		return destinationFloor;
	}
	
	public void setRequestTime(int time)
	{
		timeEntered= time;
	}
	public int getRequestTime()
	{
		return timeEntered;
	}
	
	public int getMax() 
	{
		return max;
	}
	public void setMax(int max) 
	{
		this.max = max;
	}
	public int getArrival() 
	{
		return arrival;
	}
	public void setArrival(int arrival)
	{
		this.arrival = arrival;
	}
}


	