import java.io.IOException;
import javax.swing.JOptionPane;

//TextCalculator is created
public class TextCalculator {

	//Constant variable are created using final keyword.
		final int additionCalculation = 1;
		final int subtractionCalculation = 2;
		final int multiplicationCalculation = 3;
		final int divisionCalculation = 4;
		final int nthRootCalculation = 5;
		final int powerCalculation = 6;
		final int helpCalculation = 7;
		final int turnOffCalculation = 11;
		
		//instance variable is declared. "result"  variable is visible in TextCalculator class only.
		private double result = 0;
		
		// @return the Result
		public double getResult() {
			return result; 
		}
		
		// This method prints the calculation/Operations and result details. Local variables are created.
		public void doOperation(double firstNumber, double secondNumber, int calc) {
			
			switch(calc) {  
			 
				case additionCalculation:
					result = firstNumber + secondNumber;
					//To get two decimal places after parsing double to string and to format.
					result = Double.parseDouble(String.format("%.2f", result)); 
						System.out.println("Result: " + firstNumber + " + " + secondNumber + " = " + result);  //calculation for addition.
					break;
				case subtractionCalculation:
					result = firstNumber - secondNumber;
					result = Double.parseDouble(String.format("%.2f", result));
						System.out.println("Result: "  + firstNumber + " - " + secondNumber + " = " + result);
					break;
				case multiplicationCalculation:
					result = firstNumber * secondNumber;
					result = Double.parseDouble(String.format("%.2f", result));
						System.out.println("Result: "  + firstNumber + " * " + secondNumber + " = " + result);
					break;
				case divisionCalculation:
					result = (double )firstNumber / secondNumber;
					result = Double.parseDouble(String.format("%.2f", result));
						System.out.println("Result: "  + firstNumber + " / " + secondNumber + " = " + result);
					break;
				case nthRootCalculation: 
					result = (double) Math.pow( Math.E, Math.log(firstNumber)/secondNumber);
					result = Double.parseDouble(String.format("%.2f", result));
						System.out.println("Result: " + secondNumber + "th root of " + firstNumber + " = " + result);
					break;
				case powerCalculation: 
					result = (double) Math.pow(firstNumber, secondNumber);
					result = Double.parseDouble(String.format("%.2f", result));
						System.out.println("Result: " + firstNumber + " raise to power of " + secondNumber + " = " + result);				
					break;
				case helpCalculation: 
						System.out.println("\nHELP: Please Enter..!! \n1 for Addition where 2 numbers will be added," 
							 + "\n2 for Subtraction  where 2 numbers will be subtracted,"
							 + "\n3 for Multiplication where 2 numbers will be multiplied, "
							 + "\n4 for Division  where 2 numbers will be divided"
							 + "\n5 for Nth Root" + "\n6 for Nth power" + "\n7 for HELP" + "\n8 for PI" + "\n9 Saved Result" 
							 + "\n10 Start new Operation"+"\n11 for TURN-OFF");
					break;	
				case turnOffCalculation:
					//Created dialog box to exit the calculator. Code to clear the console after you exit.
					int dialogButtonYes = JOptionPane.YES_NO_OPTION;
					int dialogButton= 0;
					int dialogResult = JOptionPane.showConfirmDialog(null, " Do you want to 'TURN-OFF' Text-Calculator ? ", "Calculator", dialogButton);
					if(dialogResult != 0) {
						System.out.println("\n  == ATTENTION: You did not Exit Calculator!! Please press 10 to Turn-OFF or you can continue. ==");
					} else {
						try{ 
							 Process exitCode;
								if( System.getProperty( "os.name" ).startsWith( "Window" ) ) {
									exitCode = Runtime.getRuntime().exec("cls");
								} else {
									exitCode = Runtime.getRuntime().exec("clear");
								}
								} catch (IOException e) {
								for(int i = 0; i < 1000; i++) {
									System.out.println();
							}	
						 }
						  
						System.exit(0);
					} 		  			
			}
		}
}
