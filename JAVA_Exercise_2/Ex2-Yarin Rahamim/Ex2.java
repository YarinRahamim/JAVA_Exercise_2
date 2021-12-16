package EX2_Yarin;

import java.util.Arrays;

public class Ex2 {

	public static double f(double[] poly, double x) {
		double sum = 0;
		for(int i=0 ; i<poly.length ; i++) {
			sum += poly[i]*(Math.pow(x, i));
		}	
		return sum;
	}

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

	public static double root (double[] p,double x1,double x2,double eps){
		double pos = Math.max(f(p,x1), f(p,x2));
		double neg = Math.min(f(p,x1), f(p,x2));
		double root = (pos+neg)/2;
		while(Math.abs(f(p,root))>eps) {
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
	
	public static double[] mul(double[] p1, double[] p2) {
		double[] mul = new double[(p1.length-1)+(p2.length-1)];
		for(int i=0 ; i<p1.length; i++) {
			for(int j=0 ; j<p2.length; j++) {
				mul[i+j]+=p1[i]*p2[j];
			}
		}
		return mul;
	}

	public static double[] derivative (double[] po) {
		double[] der = new double[po.length-1];
		for(int i=0 ; i<der.length ; i++) {
			der[i] = po[i+1]*(i+1);
		}
		return der;
	}


	public static void main(String[] args) {
		double arr[] = {2,5,-1};
		System.out.println(f(arr,2));
		double[] arr2 = {3,4};
		String s = poly(arr2);
		System.out.println(s);
		double[] arr3 = {-2,-1,0,1};
		System.out.println(root(arr3,1,2,0.0001));
		System.out.println(Arrays.toString(add(arr2,arr3)));
		double[] arr4 = {2,0,-3,1,4};
		System.out.println(Arrays.toString(derivative(arr4)));

	}

}
