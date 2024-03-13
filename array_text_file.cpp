#include <iostream>
#include <fstream>
using namespace std;

const int size = 10;
int array[size], evenA[size], oddA[size];
int sumEven = 0, sumOdd = 0;
int cntEven = 0, cntOdd = 0;

void displayResult () {
    cout << "All numbers: ";
    for (int i = 0; i < size; ++i) {
        if (i != 0) cout << ", ";
        cout << array[i];
    }
    cout << endl << endl << "Even numbers: ";
    for (int i = 0; i < cntEven; ++i) {
        if (i != 0) cout << ", ";
        cout << evenA[i];
    }
    cout << endl << "     Sum: " << sumEven << endl;
    cout << "Odd numbers: ";
    for (int i = 0; i < cntOdd; ++i) {
        if (i != 0) cout << ", ";
        cout << oddA[i];
    }
    cout << endl << "     Sum: " << sumOdd << endl;
}

int main () {
    ifstream inputFile("data.txt");
    if (!inputFile.is_open()) {
        cerr << "Error opening the file." << endl;
        return 1;
    }
    
    for (int i = 0; i < size; ++i) {
        inputFile >> array[i];
    }
    
    for (int n : array) {
        if (n % 2 == 0) {
            sumEven += n;
            evenA[cntEven] = n;
            ++cntEven;
        }
        else {
            sumOdd += n;
            oddA[cntOdd] = n;
            ++cntOdd;
        }
    }
    
    inputFile.close();
    displayResult();
    return 0;
}
