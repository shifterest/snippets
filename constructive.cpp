#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main () {
    int n;
    vector <int> primes, found;
    
    cout << "Enter an integer: ";
    cin >> n;
    
    for (int i = 2; i <= n; i++) {
        bool prime = true;
        for (int j = 2; j < i; j++)
            if (i % j == 0) prime = false;
        if (prime) primes.push_back(i);
    }
    
    for (const int p : primes) {
        if (count (found.begin(), found.end(), p) > 0) continue;
        for (const int q : primes) {
            if (found.size() >= 4) break;
            if (p + q == n) {
                found.push_back(p);
                found.push_back(q);
            }
        }
    }
    
    if (found.size() >= 4) {
        cout << n << " = " << found[0] << " + " << found[1];
        cout << " = " << found[2] << " + " << found[3];
    }
    else
        cout << "No posible constructive proof for integer " << n;


    return 0;
}
