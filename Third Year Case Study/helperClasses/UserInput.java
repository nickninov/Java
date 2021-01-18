package helperClasses;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

// This class gets user input and returns it to a variable
public class UserInput {

	private static Scanner sc = new Scanner(System.in);
	public UserInput () {}

	// Get the user's input and return string
	public String getString(String text) {
		System.out.print(text);
		String input = sc.nextLine();
		System.out.println();
		return input;
	}

	// Get the user's input and return integer
	public int getInt(String text) {
		boolean isNumber = false;
		int num = 0;
		String str;
		/*
		 * An infinite loop that repeats itself until the 
		 * user enters a String that can be successfully 
		 * converted to the required value.
		 */
		do {
			try {
				System.out.print(text);
				str = sc.nextLine();
				num = Integer.parseInt(str);
				isNumber = true;
				System.out.println();
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid input, please try again.");
			}
		} while(isNumber != true);

		return num;
	}

	// Get the user's input and return double
	public double getDouble(String text) {
		boolean isNumber = false;
		double num = 0;
		String str;
		/*
		 * An infinite loop that repeats itself until the 
		 * user enters a String that can be successfully 
		 * converted to the required value.
		 */
		do {
			try {
				System.out.print(text);
				str = sc.nextLine();
				num = Float.parseFloat(str);
				isNumber = true;
				System.out.println();
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid input, please try again.");
			}
		} while(isNumber != true);

		return num;
	}

}
