#include <iostream>
using namespace std;

int num1, num2;

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

int CalculatePower (int a, int b) {
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
        r = addTwoNumbers(num1, num2);
    else if (o == '-') 
        r = subtractTwoNumbers(num1, num2);
    else if (o == '*') 
        r = multiplyTwoNumbers(num1, num2);
    else if (o == '/') 
        r = divideTwoNumbers(num1, num2);
    else if (o == '^') 
        r = CalculatePower(num1, num2);
}

void displayResult (int r, char o) {
    if (o == '^') cout << "Result of " << num1 << " raised to the power of " << num2 << " is: " << r;
    else if (o == '/' && num2 == 0) {
        if (num2 == 0) cout << "Error: Division by zero.";
        else cout << "Result of dividing " << num1 << " by " << num2 << " is: " << r;
    }
    else {
        if (o == '+') cout << "Sum of ";
        else if (o == '-') cout << "Difference of ";
        else if (o == '*') cout << "Product of ";
        cout << num1 << " " << o << " " << num2 << " is: " << r;
    }
}

int main () {
    int result;
    char op;
    readTwoNumbers(num1, num2);
    readOperator(op);
    calculateResult(result, op);
    displayResult(result, op);

    return 0;
}
