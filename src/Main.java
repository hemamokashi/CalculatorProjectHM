/*@author : Hemlata Mokashi
@Date: 05/02/2018
1.First I created the TextCalculator class. Passed the three parameters in void() method. 
2.Used the Switch Case to do the different operation and call those operations in Main Class.
3.In Main Class, using main() method. I created calculator object from the TextCalculator class and called in Main method.
4.Got little fancy and made dialog box to start the calculator.
5.Used scanner class to read the inputs number.
6.Used while loop to execute the calculator operations and stop the infinite loop.
7.In while loop created if-else condition to call for the "Saved Result" from TextCalculator Class from getResult().
*/

import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

//Create a Main class. 
public class Main {
	
		//declaring final static int  for variable so that it  will have a single reference.
		//Since int is final you cannot change the value of variable
		final static int piCalculation = 8;
		final static int savedResultCalculation = 9;
		final static int startNewOperation = 10;
		
		//// firstNum and secondNum  variable is a private static variable
		private static double firstNum;
	    private static double secondNum;
	   
	    // Created method that computes the firstNum of the values in doubles.
		public static double  firstNum() {
			// we are creating an object named inputReader of Scanner class to read the input.
	        Scanner inputReader = new Scanner(System.in);
	        boolean inputNumber = false;
	        while (inputNumber == false) {
	            System.out.print("Enter a First Number: ");
	            try {
	                 firstNum = inputReader.nextDouble();
	                 inputReader.nextLine();
	                 inputNumber = true;
	            } catch (Exception e) {         // Check for Integer by Exception Handling
	                System.out.println("ERROR: PLEASE ENTER VALID INTEGER..!!");  
	                inputReader.next();
	            }
	        }
	        return  firstNum;
	    }
		
		// Created method that computes the SecondNum of the values in doubles.
		public static double  secondNum() {
			// we are creating an object named inputReader of Scanner class to read the input.
	        Scanner inputReader = new Scanner(System.in);
	        boolean inputNumber = false;
	        while (inputNumber == false) {
	            System.out.print("Enter a Second Number: ");
	            try {
	                 secondNum = inputReader.nextDouble();
	            inputReader.nextLine();
	               inputNumber = true;
	            } catch (Exception e) {     // Check for Integer by Exception Handling
	                System.out.println("ERROR: PLEASE ENTER VALID INTEGER..!!");
	                inputReader.next();
	            }
	        }
	        return  secondNum;
	    }
	    
		//Created Main() method.
		public static void main(String[] args) {
			
			//created an object to call from TextCalculator class
			TextCalculator calculator = new TextCalculator();
			
			// Created dialog box to to display message to start the calculator.
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null, " Do you want to 'TURN-ON' Text-Calculator ? ", "Calculator", dialogButton);
				if(dialogResult == 0) {
					System.out.println("*** Welcome to Text Calculator!!! ***");
				} else {
					System.exit(0);
				} 
			
			// we are creating an object named scanner of Scanner class to read the input.
			Scanner inputReader = new Scanner (System.in);

			System.out.println("First Number: " + firstNum());
		    System.out.println("Second Number: " + secondNum());		
			
			//Using while loop to execute the calculator program.
			boolean isFinished = false;
			while (!isFinished) {
						   
				System.out.print("\nEnter a operator: ------------------------------------------------------------------------------"
						     + "\n|1 for Addition, 2 for Subtract, 3 for Multiply, 4 for Division, 5 for Nth Root, 6 for Nth Power, |"
					         + "\n|7 for HELP, 8 for PI, 9 for Saved Result, 10 Start new Operation, 11 for TURN-OFF:               |");
				System.out.print("\n-------------------------------------------------------------------------------------------------" + "  Operator:");
				
				
				int calc = inputReader.nextInt();   // Using scanner class to input the operations.
					if (calc == piCalculation) {
						System.out.println("First number will be used as PI value.");
					firstNum = Double.parseDouble(String.format("%.2f", Math.PI)); 
						System.out.println("First Number: " + firstNum);
						System.out.println("Second Number: " + secondNum());
					} else if (calc == savedResultCalculation) {
					//"Saved Result" from last operation used as first number.
						System.out.println("Saved Result as first number.");
					firstNum = calculator.getResult();
						System.out.println("First Number: " + firstNum);
						System.out.println("Second Number: " + secondNum());
					} else if (calc == startNewOperation ) {
						System.out.println("First Number: " + firstNum());
						System.out.println("Second Number: " + secondNum());
			        }else
			        	calculator.doOperation(firstNum, secondNum, calc); 
					
			}
		}
  
	}


