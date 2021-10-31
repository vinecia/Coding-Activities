public class Shape {
	
	double getArea (double l, double w) { // For Rectangle
		return  (l*w); 
	}
	
	double getArea (float e) { // For Square
		return  (e*e); 
	}
	
	double getArea (double r) { // For Circle
		return ((3.14)*(r*r));
	}
		
	double getArea (float b, float h) { // For Triangle
		return  ((b*h)/2); 
	}
}
