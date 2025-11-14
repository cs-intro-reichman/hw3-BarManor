// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3)); 
		System.out.println(plus(2, -3));
		System.out.println(plus(-2, 3));
		System.out.println(plus(-2, -3));  // 2 + -3
	    System.out.println(minus(2,3)); 
		System.out.println(minus(2, -3));
		System.out.println(minus(-2, 3));
		System.out.println(minus(-2, -3)); // 2 - 7
 		System.out.println(times(2,3)); 
		System.out.println(times(2, -3));
		System.out.println(times(-2, 3));
		System.out.println(times(-2, -3));  // 2 + 4 * 2
   		System.out.println(pow(2,3)); 
		System.out.println(pow(-2, 3));
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5)); 
		System.out.println(div(5,0));    // 5 / 0
		System.out.println(div(5,-1));    // 5 / 1
   		System.out.println(div(-25,7));
   		System.out.println(div(-25,-7));
	    System.out.println(mod(25,25));   // 25 % 25
   		System.out.println(mod(120,6));
		System.out.println(mod(25,7));  // 25 % 7
   		System.out.println(sqrt(36));
		System.out.println(sqrt(1));
		System.out.println(sqrt(0));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int absx2 = abs(x2);
		for	 (int i = 0; i < absx2; i++) {
		if (x2<0) { // adding a negative number
			x1--;
		}
		else {
			x1++;
		}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int absx2 = abs(x2);
		for (int i = 0; i < absx2 ; i++) {
			if (x2<0) { // subtracting a negative number
				x1++;
			}
			else {
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int absx1 = abs(x1);
		int absx2 = abs(x2);
		int product = 0;
		if (x1 == 0 || x2 == 0) { // multiplication by zero
			return 0;
		}
		for (int i = 0; i < absx2; i++) { // adding abs(x1), abs(x2) times
			product = plus(product, absx1);
		}
		if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) { // product is negative
			product = minus(0, product);
		}		
		return product;
	}

	public static int pow(int x, int n) {
		int absx = abs(x);
		int result = 1;
		if (n==0) { // x^0 = 1
		return 1;
		}
		else if (x==0) { // 0^n = 0, n>0
			return 0;
		}
		for (int i = 0; i < n; i++) { // multiply abs(x), n times
			result = times(result, absx);
		}
		if (x<0 && mod(n, 2) == 1) { // x is negative and n is odd
			result = minus(0, result);
		}
		return result;
	}

	public static int div(int x1, int x2) {
		if (x2 == 0) { // error: division by zero
			return -1;
		}
		else if (x2 == 1) { // division by one
			return x1;
		}
		else if (x2 == -1) { // division by minus one
			return minus(0, x1);
		}

		int quotient = 0;
		int divider = abs(x1);
		int divisor = abs(x2);

		while (divider != 0 && divider >= divisor) { // subtract divisor from divider until divider < divisor
        divider = minus (divider, divisor);
		quotient++;
		}
		if ((x1<0 && x2>0) || (x1>0 && x2<0)) { // quotient is negative
			quotient = minus(0, quotient);
			
		}
		return quotient;
	}

	public static int mod(int x1, int x2) {
		int remainder = 0;
		if (x1==0) {
			return 0;
		}
		if (x2 == 0) { // error: modulo by zero
	    return -1; 
		}
		remainder = minus(x1,times(div(x1, x2), x2)); // r = a1 - q*n, by definition of modulo
		return remainder;
	}

 	public static int sqrt(int x) {
		if (x == 0) {
			return 0;
		}
		else if (x == 1) {
			return 1;
		}
		int root = 0;
		int square = 0;
		while (square <= x) { // increment root until root^2 > x
			root++;
			square = times(root, root);
		}
		return minus(root, 1);
		
	}

	public static int abs(int x) { // returns the absolute value of x
		int inverse = 0;
		if (x < 0) {
			for (int i = x; i < 0; i++) { // return -x
			   inverse++;
			}
			return inverse;
		}
		else {
			return x;
		}
	}
}