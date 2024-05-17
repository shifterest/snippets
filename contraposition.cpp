#include <iostream>
using namespace std;

bool isBinary (long n);
long bitFlip (long n);
int intToDec (long n);
bool powerOfTwo (int n);
bool isPower (long n);

int main () {
	long bin = 0;
	
	while (true) {
		cout << "Binary Number::>> ";
		cin >> bin;
		
		if (bin < 0) {
			cout << "Exiting.";
			return 0;
		}
		
		if (!isBinary (bin)) {
			cout << bin << " is not in binary form of a number" << endl << endl; 
			continue;
		}
		
		if (isPower (bin)) cout << bin << " is a power of two (2)" << endl << endl; 
		else cout << bin << " is not a power of two (2)" << endl << endl;
	}
	
	return 0;
}

bool isBinary (long n) {
	short d;
	while (n > 0) {
		d = n % 10;
		if (d > 1) return false;
		n /= 10;
	}
	return true;
}

long bitFlip (long n) {
	long flip = 0, pv = 1;
	while (n > 0) {
		flip += pv * (n % 10 == 0 ? 1 : 0);
		n /= 10;
		pv *= 10;
	}
	return flip;
}

int intToDec (long n) {
	short d;
	int dec = 0;
	for (int i = 0; n > 0; i++) {
		d = n % 10;
		for (int j = 0; j < i; j++) d *= 2;
		dec += d;
		n /= 10;
	}
	return dec;
}

int countOne (long n) {
	int one = 0, d = 0;
	for (int i = 0; n > 0; i++) {
		d = n % 10;
		if (d == 1) one++;
		n /= 10;
	}
	return one;
}

bool powerOfTwo (int n) {
	short d;
	bool power = false;
	for (; n > 0; n /= 2) {
		if (n == 1) {
			power = true;
			break;
		}
		d = n % 2;
		if (d != 0) break;
	}
	return power;
}

/* IMPLICATION:

   If the binary number i is composed of only a singular 1 and remaining 0s,
   then i is a power of two (2).
   
   CONTRAPOSITION:
   
   If the binary number i is not a power of (2), then i is not composed of
   only a singular 1 and remaining 0s.
   
   CONTRADICTION OF CONTRAPOSITION:
   Suppose i is bit-flipped. Since i is a power of 2, the contradiction is
   false, making the contraposition true, making the implication true.
*/
bool isPower (long n) {
	bool hyp = false;				// i is composed of only a singular 1
	bool proof = false;				// i is a power of two (2)
	bool cont = false;				// i bit-flipped is a power of 2
	long flip = bitFlip (n);		// Bit-flipped version of i
	int one, decimal, flippedDecimal;

	// Convert binary to decimal while counting ones
	decimal = intToDec (n);
	one = countOne (n);
	
	// Convert flipped binary to decimal
	flippedDecimal = intToDec (flip);
	
	// Check if the binary number is composed of only a singular 1
	if (one == 1) hyp = true;
	
	/* Check if decimal is a power of 2 by repeated division
	   
	   Since powers of 2 can be represented as 2^n for some integer n, aka 2
	   multiplied by itself n amount of times, repeated division by 2 should
	   result to 1 with a remainder of 0.
	*/
	proof = powerOfTwo (decimal);
	
	// Check if flipped decimal is a power of 2 by repeated division
	cont = powerOfTwo (flippedDecimal);
		
	/* If proof is false (aka i is not a power of 2), then hyp should also be 
	   false (i is not composed of only a singular 1 and remaining 0s), as per
	   the contraposition. This proves that the implication is TRUE.
	*/
	if (hyp && proof && !cont) return true;
	else return false;
}
