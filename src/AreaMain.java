import java.util.*;
public class AreaMain {
	Scanner sc = new Scanner(System.in);
	public void main (String [] args)
	{
	int choice; 
	System.out.print("Input a number: "); // Input the number of your desired shape
	choice = sc.nextInt();
	double length, breadth, radius, area = 0;
	float edge, base, height;
	Shape shapes = new Shape ();
	switch(choice){
	case 1:  System.out.print("Enter length: ");
			length = sc.nextDouble();
	         System.out.print("Enter breadth: ");
	         breadth = sc.nextDouble();
	         area = shapes.getArea(length, breadth);
	         System.out.println("Area of Rectangle is: "+area);
	         break;
	case 2:  System.out.print("Enter edge: ");
	         edge = sc.nextFloat();
	         area = shapes.getArea(edge);
	         System.out.println("Area of Square is: "+area);
	         break;
	case 3: System.out.print("Enter radius: ");
			radius = sc.nextDouble();
			area = shapes.getArea(radius);
			 System.out.println("Area of Circle is: "+area);
			break;
	case 4: System.out.print("Enter base: ");
			base = sc.nextFloat();
			System.out.print("Enter height: ");
			height = sc.nextFloat();
			area = shapes.getArea(base, height);
			System.out.println("Area of Triangle is: "+area);
			break;
	default: System.out.print("Invalid input!");
		break;
	}
  }
}
	
	


