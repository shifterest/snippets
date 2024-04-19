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
        bool prime = true;
        for (int j = 2; j < i; j++)
            if (i % j == 0) prime = false;
        if (prime) primes.push_back(i);
    }
    
    // Obtain all possible prime number combinations equal to an even number
    // within lower limit and upper limit
    for (int i = lo; i <= hi; i++) {
        if (i % 2 != 0) continue;
        for (int p : primes)
            for (int q : primes) {
                // cout << "i = " << i << ", p = " << p << ", q = " << q << endl;
                if (p + q == i) {
                    cout << i << " = " << p << " + " << q << endl;
                    goto next;
                }
            }
        next:;
    }

    return 0;
}
