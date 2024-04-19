#include <iostream>
#include <vector>
using namespace std;

int main () {
    int lo, hi;
    vector <int> primes;
    
    cout << "Enter lower limit: ";
    cin >> lo;
    cout << "Enter upper limit: ";
    cin >> hi;
    cout << endl;
    
    cout << "Even numbers written as sum of two prime numbers:" << endl;
    
    // Get all prime numbers within 2 and upper limit
    for (int i = 2; i <= hi; i++) {
        // A number is assumed to be prime unless proven otherwise
        bool prime = true;
        // Loop through all possible divisors of i to check if it is divisible
        // by any of them
        for (int j = 2; j < i; j++)
            // If a proper divisor is found, terminate the loop and declare i
            // as not prime (composite)
            if (i % j == 0) {
                prime = false;
                break;
            }
        if (prime) primes.push_back(i);
    }
    
    // Obtain all possible prime number combinations equal to an even number
    // within lower limit and upper limit
    for (int i = lo; i <= hi; i++) {
        // Skip odd numbers
        if (i % 2 != 0) continue;
        // Iterate through all possible prime number combinations
        for (int p : primes)
            for (int q : primes)
                // If a prime combination is found, print it and skip to
                // checking the next even number
                if (p + q == i) {
                    cout << i << " = " << p << " + " << q << endl;
                    goto next;
                }
        next:;
    }

    return 0;
}
