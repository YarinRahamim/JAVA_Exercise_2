package Ex2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Ex2 {

	// Matala2- Yarin Rahamim 205833668
	// Polynom system- representation of a polynom with numbers of function.


	// Check polynom sum- Enter Array(the polynom) and variable x and the function calculate the sum.

	public static double f(double[] poly, double x) {
		double sum = 0;  
		for(int i=0 ; i<poly.length ; i++) { 
			sum += poly[i]*(Math.pow(x, i));
		}	
		return sum;
	}

	// Representation the polynom with String- Enter a Array and the function swap to String.
	// For example: Array :{2,3,4} swap to String --> 3.0x^2 + 2.0x+ 1.0.

	public static String poly(double[] poly) {
		String s = "";
		for(int i=poly.length-1 ; i>=0 ;i--) {
			if(i == 0) {
				if(poly[i]>0) {
					s+="+"+poly[i];
				}
				else if(poly[i]<0) {
					s+=poly[i];
				}
			}
			else if((i==poly.length-1 && poly[i]!=0 )|| poly[i]<0) {
				s+=poly[i]+"x^"+i;
			}
			else if(poly[i]>0) {
				s+="+"+poly[i]+"x^"+i;
			}
		}
		return s;
	}

	// Check root of the polynom between [x1,x2], use bisection method. 

	public static double root (double[] p,double x1,double x2,double eps){
		double pos = Math.max(f(p,x1), f(p,x2)); // check for max and result of the polynom(between x1,x2) is a positive.
		double neg = Math.min(f(p,x1), f(p,x2)); // check for min and result of the polynom(between x1,x2) is a negative.
		double root = (pos+neg)/2;
		while(Math.abs(f(p,root))>eps) { // The eps variable defines how accurate the result will be. 
			if(f(p,root)>0) {
				pos = root;
			}
			else { 
				neg = root;
			}
			root = (pos+neg)/2;
		}
		return root;
	}

	// The function add with two Arrays(polynoms) and return new Array.
	// For example : {1,2,3} + {1,2,3,4} = {2.0, 4.0, 6.0, 4.0}. 

	public static double[] add(double[] p1, double[] p2) {
		int len = Math.max(p1.length,p2.length);
		double[] add = new double [len];
		for(int i=0 ; i<add.length; i++) {
			if(i<Math.min(p1.length,p2.length)) {
				add[i] = p1[i]+p2[i];
			}
			else {
				if(p1.length>p2.length) {
					add[i] = p1[i];
				}
				else {
					add[i] = p2[i];
				}
			}
		}
		return add;
	}

	// The function multiplier between two Arrays(polynoms) and return new Array. 
	// For example: {1,1,1,1,1} * {1,0,1,0,1} = {1.0, 1.0, 2.0, 2.0, 3.0, 2.0, 2.0, 1.0, 1.0}.
	public static double[] mul(double[] p1, double[] p2) {
		double[] mul = new double[(p1.length-1)+(p2.length-1)+1];
		for(int i=0 ; i<p1.length; i++) {
			for(int j=0 ; j<p2.length; j++) {
				mul[i+j]+=p1[i]*p2[j];
			}
		}
		return mul;
	}

	// The function calculate the derivative of the Array(polynom). 
	// For example: {1,0,1,0,1} (The Polynom) --> {0.0, 2.0, 0.0, 4.0} (The derivative of the Polynom). 
	public static double[] der(double[] po) {
		double[] der = new double[po.length-1];
		for(int i=0 ; i<der.length ; i++) {
			der[i] = po[i+1]*(i+1);
		}
		return der;
	}


	public static void main(String[] args) {

	}

}
