#include <iostream>
using namespace std;

bool isBinary (long n) {
	short d;
	while (n > 0) {
		d = n % 10;
		if (d > 1) return false;
		n /= 10;
	}
	return true;
}

/* IMPLICATION:

   If the binary number i is composed of only a singular 1 and remaining 0s,
   then i is a power of two (2).
   
   CONTRAPOSITION:
   
   If the binary number i is not a power of (2), then i is not composed of
   only a singular 1 and remaining 0s.
*/
bool isPower (long n) {
	bool hyp = false;				// i is composed of only a singular 1
	bool proof = false;				// i is a power of two (2)
	short rem;
	int one = 0, decimal = 0;
		
	// Convert binary to decimal while counting zeroes and ones
	for (int i = 0; n > 0; i++) {
		rem = n % 10;
		if (rem == 1) one++;
		for (int j = 0; j < i; j++) rem *= 2;
		decimal += rem;
		n /= 10;
	}
	
	// Check if the binary number is composed of only a singular 1
	if (one == 1) hyp = true;
	
	/* Check if decimal is a power of 2 by repeated division
	   
	   Since powers of 2 can be represented as 2^n for some integer n, aka 2
	   multiplied by itself n amount of times, repeated division by 2 should
	   result to 1 with a remainder of 0.
	*/
	for (; decimal > 0; decimal /= 2) {
		if (decimal == 1) {
			proof = true;
			break;
		}
		rem = decimal % 2;
		if (rem != 0) break;
	}
		
	/* If proof is false (aka i is not a power of 2), then hyp should also be 
	   false (i is not composed of only a singular 1 and remaining 0s), as per
	   the contraposition. This proves that the implication is TRUE.
	*/
	if (hyp && proof) return true;
	else return false;
}

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
