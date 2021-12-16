package Ex2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ex2_Test {

	@Test // Check if the function return result of f(x). 
	void testf() {
		double[] arr1= {2,5,3,-1};
		double x = 2;
		double ans= Ex2.f(arr1, x);
		double test = 16;
		assertEquals(test,ans);
	}

	@Test // Check if the function return the polynom.
	void testpoly() {
		double[] arr1= {2,5,3,-1};
		double[] arr2= {1,2,3};
		String ans= Ex2.poly(arr2);
		String test = "3.0x^2+2.0x^1+1.0";
		assertTrue(ans.equals(test));
	}

	@Test // Check if the function return a value.
	void testroot () {
		double[] arr3 = {-2,-1,0,1};
		double ans= Ex2.root(arr3 , 1, 2, 0.0001);
		double test=1.521392822265625;
		assertEquals(ans,test);
	}

	@Test // Check if the function add with 2 polynom and return new array.
	void testadd () { 
		double[] arr1 = {1,2,3};
		double[] arr2 = {1,2,3,4};
		double[] arr3 = {1,1,1,1,1};
		double[] arr4 = {1,0,1,0,1};
		double[] arr5 = {-1,-2,-3};
		double[] ans1 = Ex2.add(arr1, arr2);
		double[] test1 = {2.0, 4.0, 6.0, 4.0};
		assertArrayEquals(test1,ans1);
	}

	@Test // Check if the function multiple between 2 polynom (p1*p2) and return new array.
	void testmul () {
		double[] arr1 = {1,2,3};
		double[] arr2 = {1,2,3,4};
		double[] arr3 = {1,1,1,1,1};
		double[] arr4 = {1,0,1,0,1};
		double[] arr5 = {-1,-2,-3};
		double[] ans1 = Ex2.mul(arr3,arr4);
		double[] test1 = {1.0, 1.0, 2.0, 2.0, 3.0, 2.0, 2.0, 1.0, 1.0};
		assertArrayEquals(test1,ans1);
	}

	@Test // Check if the function derivative the polynom and return new array.
	void testder () {
		double[] arr1 = {1,0,1,0,1};
		double[] arr2 = {1,2,3,4};
		double[] ans1 = Ex2.der(arr1);
		double[] test1 = {0.0, 2.0, 0.0, 4.0};
		assertArrayEquals(test1,ans1);
	}
}

