import java.util.*;
public class Logging{
	static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int i;
		System.out.print("Hello World!\n Dibayn here\n");
		int arr[] = new int [7]; 
		for (i=0; i<6; i++) {
			System.out.print("Input "+(i+1)+":");
			arr[i]= sc.nextInt();
			if (i>0 && i<6)
				arr[i] = arr[i] + arr[i-1];
		}
		for (i=0; i<7; i++)
		System.out.println(arr[i]);
	}

}
