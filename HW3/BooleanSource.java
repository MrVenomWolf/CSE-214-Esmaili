/**
* fully-documented class named BooleanSource that is the same as the BooleanSource object. 
* This class has a double named probability as a member variable, a constructor that accepts a double as a parameter as the value of this member variable, 
* and also a boolean method called requestArrived() that returns true a percentage of the time equal to probability (and otherwise it returns false).
*
* @author: Anubrota Majumdar
* @Due: 07/28/2022
* @ID: 114586887
* @Assignment: HW3 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
*/


public class BooleanSource {
	private double probability;
	private double percentageOfTime;
	
	public BooleanSource(double prob) throws IllegalArgumentException    //accepting from the simulator class and setting probability to 'prob'
	{
		probability=prob; 
	}
	
	public boolean requestArrived() {
		/*
		 * 
		 */
		double randvalue;
		randvalue= (double) (Math.random()*(1.0-0.0)+0.0); // 0.25   0.9856874 0.0  1.0 0.1   0.01 0.02 1.00
		percentageOfTime= Math.round( randvalue *100.0)/100.0 ; // rounding up my system prob value into two digits 0.95
	   //  System.out.println("Prob is "+ probability+" and Percentage of time is "+percentageOfTime);// testing
	
		/*
		 * 
		 */
		
	     
		if ( percentageOfTime == probability ) 
		{
			return true;
		}
		else {
			return false;
		}

		
	/*	
		if ( percentageOfTime >=probability-0.15 && percentageOfTime<= probability+ 0.15 ) // making probability range a little Bigger
		{
			return true;		
		}
		else 
		{
			return false;
		}
	*/
		
	}

}



