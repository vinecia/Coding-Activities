import java.util.Scanner;

public class ArmstrongNumber {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		int no = 0;
		System.out.print("Input a number: ");
		no = sc.nextInt();
		if (no >= 0)
		{	/*	Convert integer to a string then to a char array.
		 	 *	In order to perform operation on each digit,
		 	 *	it is needed to be converted to an int array. 
		 	 */
			String num = String.valueOf(no);
			char [] digit1 =  num.toCharArray();
			int [] digit2 = new int[digit1.length];
			int sum = 0;
			for (int i=0; i<digit1.length; i++) {
				digit2[i] = Integer.parseInt(String.valueOf(digit1[i]));
				sum = sum + (digit2[i]*digit2[i]*digit2[i]);
			}
			if (sum==no)
				System.out.println("The given number is an armstrong number\n");
			else 
				System.out.println("The given number is not an armstrong number\n");
		}
		else 
			System.out.println("Invalid input\n");
	}
}
