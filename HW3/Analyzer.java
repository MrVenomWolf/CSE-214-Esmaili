/**
* fully-documented class named Analyzer containing a main method which prompts the user, on separate lines,
* for each of the 4 parameters required for the simulate method of the Simulator class. 
*
* @author: Anubrota Majumdar
* @Due: 07/28/2022
* @ID: 114586887
* @Assignment: HW3 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
* @algorithm used for ExtraCredit:
* 
* 
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Analyzer {

	public static void main(String[] args) throws IllegalArgumentException {
		Scanner sc = new Scanner(System.in);
		double prob_arriv;
		int floors, elev,len_simul;
		char c;
		char reg;
		
		
		do
		{
			try
			{
			System.out.println("Welcome to the Elevator simulator !");
			System.out.println("Please enter the probability of arrival for Requests (0.0 to 1.0) :");
			prob_arriv=sc.nextDouble();
			while(prob_arriv < 0.0||prob_arriv > 1.0)
			{
				System.out.print("Invalid. Please try again: ");
				System.out.println("Please enter the probability of arrival for Requests (0.0 to 1.0) :");
				prob_arriv=sc.nextDouble();
			}
			
			System.out.println("Please enter the number of floors: "); // set
			floors= sc.nextInt();
			while(floors<2){
				System.out.print("Invalid Floor. Re-Enter again: ");
				System.out.println("Please enter the number of floors: ");
				floors=sc.nextInt();
			}
			System.out.println("Please enter the number of elevators: "); //
			elev=sc.nextInt();
			
			while(elev<1){
				System.out.print("Invalid. Please try again: ");
				System.out.println("Please enter the number of elevators: "); //
				elev=sc.nextInt();
			}
			
			System.out.println("Please enter the length of the simulation (in time units): ");
			len_simul=sc.nextInt();
			while(len_simul<1){
				System.out.print("Invalid. Please try again: ");
				System.out.println("Please enter the length of the simulation (in time units): ");
				len_simul=sc.nextInt();			
			}
			System.out.println("Please enter 'r' for regular or 'o' for optimal passenger! "); //ppp
			reg= sc.next().charAt(0);
		
			while( ! (reg=='r'  || reg== 'o' || reg=='R' || reg=='O'))
			{
				System.out.println("Invalid Answer. Please try again...");
				System.out.println("Please enter 'r' for regular or 'o' for optimal passenger! ");
				reg= sc.next().charAt(0);
			}
			
			
			if(reg=='r' || reg=='R')
			{
				Simulator.simulate(prob_arriv, floors, elev, len_simul);
			}
			else
			{
				OptimalSimulator.simulate(prob_arriv, floors, elev, len_simul);
			}
			
			
		
		}
			catch (InputMismatchException ex) {
				System.err.println("Error : "+ ex.getMessage());
			}
			catch (Exception ex1) {
				System.err.println("Error : "+ ex1.getMessage());
			}
			
	
			System.out.println("\n\nWant to Continue again? (y/n)");
			c= sc.next().charAt(0);
		}
		while(c=='y' || c=='Y');
		System.out.println("Goodbye ! ");


		sc.close();
		
		
		
	//	System.out.println("  A request arrives from Floor "+r.getsourceFloor()+ " To Floor "+r.getDestinationFloor());
	}	
}


		
		
