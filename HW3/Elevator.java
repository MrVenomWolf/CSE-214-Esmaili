/**
* fully-documented class a class called Elevator that contains the following member variables:
*   currentFloor (int)
*   elevatorState (an int constant, either IDLE, TO_SOURCE, or TO_DESTINATION)
*   request (Request object representing the request being handled or null if the Elevator is idle) 
*
* @author: Anubrota Majumdar
* @Due: 07/28/2022
* @ID: 114586887
* @Assignment: HW3 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
*/

public class Elevator {
// Idle value is 0;
	private final int IDLE=0 ;
	private final int TO_SOURCE = 1;
	private final int TO_DESTINATION = 2;
	
	private int currentFloor;
	
	private int  elevatorState;// an int constant, either IDLE, TO_SOURCE, or TO_DESTINATION)
	
	private Request request;// (Request object representing the request being handled or null 
					//  if the Elevator is idle)

	public Elevator()
	{
		setElevatorState(IDLE); // by default. zero is IDLE
		setRequest(null); 
		setCurrentFloor(1); // at first, current floor is 1
	
	}

	/*
	 * 
	 * Those are accesser and mutator methods.. {set; get}
	 */
	
	public void setCurrentFloor(int curr)
	{
		currentFloor=curr;
	}
	public int getCurrentFloor()
	{
		return currentFloor;
	}
	
	public void setElevatorState(int state)
	{
		elevatorState=state;
	}
	public int getElevatorState()
	{
		return elevatorState;
	}
	
	public Request getRequest()
	{
		return request;
	}
	public void setRequest(Request request)
	{
		if(this.getElevatorState()==IDLE) 
			this.request = null;
		else 
			this.request = request;
	}
	
	public int getTO_SOURCE() {
		return TO_SOURCE;
	}
	public int getTO_DESTINATION() {
		return TO_DESTINATION;
	}
}


