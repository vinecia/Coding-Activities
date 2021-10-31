import java.util.Scanner;

public class ArmstrongNumberr {
	static Scanner sc = new Scanner(System.in);
	static int number = 0, resume = 1;
	public static void main(String args[]) {
		programArmstrong();	
	}
	
	public static void inputNumber() {
		System.out.print("\nInput a number: ");
		number = sc.nextInt();
	}	
	
	public static void checkArmstrong() {
		/*	Convert integer to a string then to a char array.
	 	 *	In order to perform operation on each digit,
	 	 *	it is needed to be converted to an int array. 
	 	 */
		String num = String.valueOf(number);
		char [] digit1 =  num.toCharArray();
		int [] digit2 = new int[digit1.length];
		int sum = 0;
		for (int i=0; i<digit1.length; i++) {
			digit2[i] = Integer.parseInt(String.valueOf(digit1[i]));
			sum = sum + (digit2[i]*digit2[i]*digit2[i]);
		}
		if (sum==number)
			System.out.println("The given number is an armstrong number");
		else 
			System.out.println("The given number is not an armstrong number");
	}
	
	public static void programArmstrong() {
		inputNumber();
		if (number >= 0 && resume==1)
		{	
			checkArmstrong();
		}
		else System.out.println("Invalid input\n");
		tryAgain();
	}
	
	public static void tryAgain() {
		System.out.print("Input again?(1/0) ");
		resume = sc.nextInt();
		if (resume==1)
			programArmstrong();
		else System.out.println("Goodbye!");
	}
	
}
