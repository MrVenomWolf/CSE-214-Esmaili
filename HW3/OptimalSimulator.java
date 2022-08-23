/**
*   Fully-documented class named OptimalSimulator will be used to actually carry out the simulation. 
*   This class will contain a single static method called simulate that accepts the following four parameters, carries out the simulation, and prints the results:
*   The probability of a request being introduced per time unit (a double between 0.0 and 1.0, inclusive)
*   The number of floors in the building (an int greater than 1)
*   The number of elevators in the building (an int greater than 0)
*   The length of the simulation in time units (an int greater than 0) 
*
* @author: Anubrota Majumdar
* @Due: 07/28/2022
* @ID: 114586887
* @Assignment: HW3 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
* @algorithm used for ExtraCredit:

Algorithm 
------------------------
step 1: start
step 2: calling main
step 3: taking all input in a proper format
step 4: calling static method named simulate in OptimalSimulator class
step 5: assigned a queue(which is following FIFO) 
step 6: calling the method named simulate in OptimalSimulator class
step 7: checked the probability of request arrival
step 8: generating request
step 9: generating source and destination floor using Math.random()
step 10: elevator is coming to the source floor
step 11: counting wait time
step 12: counting number of requests
step 13: elevator is coming to the destination floor
step 14: setting elevator state to 0(IDLE)
step 15: waiting for the next request(using "for" loop)
step 16: end loop
step 17: calculating average wait time
step 18: printing output
step 19: end
*/


public class OptimalSimulator {


	public static void simulate(double probability, int numFloors, int numElevators, int lengthSim)
	{
		// System.out.println("I am Optimal passenger");
		
		try
		{
			RequestQueue s = new RequestQueue();
			BooleanSource arrival =new BooleanSource(probability);
			int waitTime=0, totalWaitTime=0;
			int i, done=0;
			double avgWaitTime; 
			int currentSecond;
			
			Elevator[] elevators=new Elevator[numElevators];  // an array of elevators (max is number of elevator)
			
			for(currentSecond =1; currentSecond<=lengthSim; currentSecond++)
			{
				if(arrival.requestArrived()==true)
				{
					//System.out.println("Request : "); // testing
					Request r=new Request(numFloors); // this function generates SourceFloor and destinationFloor(Random)
					s.push(r); //request pushed in the Queue (ernqueued)
					// now work with elevator
									 
					for( i=0;i<numElevators; i++)
					{

						elevators[i] = new Elevator();
						//System.out.println("current floor : "+ elevators[i].getCurrentFloor()+ ", state:"+ elevators[i].getElevatorState()); // testing
						//System.out.println("size is "+ s.getSize());// testing
						if(elevators[i].getElevatorState()==0 && !( s.isEmpty() ) ) // 0 is IDLE 
						{
							
							elevators[i].setElevatorState(1);
							elevators[i].setRequest(s.pop());
						}
						
						if(elevators[i].getElevatorState()==elevators[i].getTO_SOURCE()) // elevator is going to the source location
						{							
						//	System.out.println("Elevator is coming to pick up the passenger");
						//	System.out.println("current floor : "+ elevators[i].getCurrentFloor());
						//	System.out.println("Passenger is at : "+ elevators[i].getRequest().getSourceFloor()); // 1 to 5
							//waitTime= elevators[i].getRequest().getSourceFloor()-1; 
							
							if(elevators[i].getRequest().getSourceFloor()> elevators[i].getCurrentFloor())  // elevator is coming UP
							{
								
								for(int x= elevators[i].getCurrentFloor(); x< elevators[i].getRequest().getSourceFloor(); x++ )
								{
									elevators[i].setCurrentFloor(elevators[i].getCurrentFloor()+1);
									waitTime++;
								 //	System.out.println("Elevator is in Floor: "+elevators[i].getCurrentFloor());
								}
								r.setRequestTime(waitTime);
								waitTime=0; // resetting waitTime for next action
								totalWaitTime += r.getRequestTime();
								// now reached 
								
							//	System.out.println("elevator is at  : "+ elevators[i].getCurrentFloor());
							//	System.out.println("Passenger is at : "+ elevators[i].getRequest().getSourceFloor());
							//	System.out.println("wait time is : "+ r.getRequestTime());
								done++; 
								elevators[i].setElevatorState(2);
							}
							else if(elevators[i].getRequest().getSourceFloor()< elevators[i].getCurrentFloor()) // elevator is coming Down
							{
								
								for(int x= elevators[i].getCurrentFloor(); x> elevators[i].getRequest().getSourceFloor(); x-- ) //
								{
									elevators[i].setCurrentFloor(elevators[i].getCurrentFloor()-1);
									waitTime++;
							//		System.out.println("Elevator is in Floor: "+elevators[i].getCurrentFloor());
								}
								r.setRequestTime(waitTime);
								waitTime=0; // resetting waitTime for next action
								totalWaitTime += r.getRequestTime();
								// now reached 
								
							//	System.out.println("elevator is at  : "+ elevators[i].getCurrentFloor());
							//	System.out.println("Passenger is at : "+ elevators[i].getRequest().getSourceFloor());
							//	System.out.println("wait time is : "+ r.getRequestTime());
								done++;
								elevators[i].setElevatorState(2);
								
							}
							else
							{
								// same floor, so wait time is zero
								done++;
								elevators[i].setElevatorState(2);	
							}
							
							
						}
						// ============================== Destination =============================================
						if(elevators[i].getElevatorState()==elevators[i].getTO_DESTINATION()) // elevator is going to the Destination
						{
						//	System.out.println("Elevator is coming to the Destination");
						//	System.out.println("current floor : "+ elevators[i].getCurrentFloor());
						//	System.out.println("Destination is at : "+ elevators[i].getRequest().getDestinationFloor());
							//waitTime= elevators[i].getRequest().getSourceFloor()-1; 
							
							if(elevators[i].getRequest().getDestinationFloor()> elevators[i].getCurrentFloor())
							{
								// elevator is coming UP
								for(int x= elevators[i].getCurrentFloor(); x< elevators[i].getRequest().getDestinationFloor(); x++ )
								{
									elevators[i].setCurrentFloor(elevators[i].getCurrentFloor()+1);
								//	System.out.println("Elevator is in Floor: "+elevators[i].getCurrentFloor());
								}
								
								
								// now reached 
								
							//	System.out.println("Destination is at  : "+ elevators[i].getRequest().getDestinationFloor());
							//	System.out.println("Elevator is at : "+ elevators[i].getCurrentFloor());
							//	System.out.println("Passenger reached : ");
								
								elevators[i].setElevatorState(0);
								
							}
							else if(elevators[i].getRequest().getDestinationFloor()< elevators[i].getCurrentFloor())
							{
								// elevator is coming Down
								for(int x= elevators[i].getCurrentFloor(); x> elevators[i].getRequest().getDestinationFloor(); x-- )
								{
									elevators[i].setCurrentFloor(elevators[i].getCurrentFloor()-1);
								//	System.out.println("Elevator is in Floor: "+elevators[i].getCurrentFloor());
								}
						
								// now reached 
								
								//	System.out.println("Elevator is at : "+ elevators[i].getCurrentFloor());
								 //System.out.println("Passenger reached : The elevator is Free now. ");
					
								elevators[i].setElevatorState(0);
								
							}
							else
							{
								
								elevators[i].setElevatorState(0);	
							}
						}
						
						 if(elevators[i].getElevatorState()==0 && !(s.isEmpty()))
							{
								elevators[i].setElevatorState(1);
								elevators[i].setRequest(s.pop());
							}
						
					}
					
				}
				else
				{
				//	System.out.println("No Request Arrived."); // testing
				}
				
			}
			
			
			avgWaitTime=(double)totalWaitTime/done;
			System.out.println("\n Simulation Result for Optimal Passenger : ");
			System.out.println("--------------------");
			System.out.println("Total Wait Time:"+totalWaitTime);
			System.out.println("Total Requests:"+done);
			System.out.printf("Average Wait Time: %.2f \n",avgWaitTime);
		}
		catch (Exception ex) {
			System.err.println("Error : "+ex.getMessage());
		}
		
		
	}


}



