#include <iostream>
using namespace std;

int n, m;
char op;

int addTwoNumbers (int a, int b) {
    return a + b;
}

int subtractTwoNumbers (int a, int b) {
    return a - b;
}

int multiplyTwoNumbers (int a, int b) {
    return a * b;
}

int divideTwoNumbers (int a, int b) {
    if (b == 0) return 0;
    else return a / b;
}

int calculatePower (int a, int b) {
    int p = 1;
    while (true) {
        if (b > 0) b--;
        else break;
        p *= a;
    }
    return p;
}

void readTwoNumbers (int &a, int &b) {
    cout << "Enter the first number: ";
    cin >> a;
    cout << "Enter the second number: ";
    cin >> b;
}

// Additional function to read operator
void readOperator (char &o) {
    cout << "Enter the operation (+, -, *, /, ^): ";
    cin >> o;
}

// Additional function to calculate result
void calculateResult (int &r, char o) {
    if (o == '+') 
        r = addTwoNumbers(n, m);
    else if (o == '-') 
        r = subtractTwoNumbers(n, m);
    else if (o == '*') 
        r = multiplyTwoNumbers(n, m);
    else if (o == '/') 
        r = divideTwoNumbers(n, m);
    else if (o == '^') 
        r = calculatePower(n, m);
}

void displayResult (int r, char o) {
    if (o == '^') cout << "Result of " << n << " raised to the power of " << m << " is: " << r;
    else if (o == '/' && m == 0) cout << "Error: Division by zero.";
    else {
        if (o == '+') cout << "Sum of ";
        else if (o == '-') cout << "Difference of ";
        else if (o == '*') cout << "Product of ";
        else if (o == '/') cout << "Quotient of ";
        cout << n << " " << o << " " << m << " is: " << r;
    }
}

int main () {
    int result;
    readTwoNumbers(n, m);
    readOperator(op);
    calculateResult(result, op);
    displayResult(result, op);

    return 0;
}
