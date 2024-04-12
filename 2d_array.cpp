#include <iostream>
#include <iomanip>
using namespace std;

const int MAX_ROWS = 10;
const int MAX_COLS = 10;

void inputMatrix (int matrix[MAX_ROWS][MAX_COLS], int rows, int cols) {
    cout << "Enter elements of the " << rows << "x" << cols << " matrix: " << endl;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) { 
            cout << "Enter element [" << i << "][" << j << "]: ";
            cin >> matrix[i][j];
        }
    }
}

void searchInteger (int matrix[MAX_ROWS][MAX_COLS], int rows, int cols, int searchElement) {
    bool found = false;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (matrix[i][j] == searchElement) {
                cout << "The integer " << searchElement << " is found at position [" << i << "][" << j << "]" << endl;
                found = true;
            }
        }
    }
    if (found == false)
        cout << "The integer " << searchElement << " is not found in the array." << endl;
} 

void displayMatrix (int matrix[MAX_ROWS][MAX_COLS], int rows, int cols) {
    cout << "The entered matrix is: " << endl;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++)
            cout << setw (5) << matrix[i][j];
        cout << endl;
    }
}

int findMax (int matrix[MAX_ROWS][MAX_COLS], int rows, int cols) {
    int max = matrix[0][0];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++)
            if (matrix[i][j] > max)
                max = matrix[i][j];
    }
    cout << "The maximum integer in the array is: " << max << endl;
    return max;
}

int findMin (int matrix[MAX_ROWS][MAX_COLS], int rows, int cols) {
    int min = matrix[0][0];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++)
            if (matrix[i][j] < min)
                min = matrix[i][j];
    }
    cout << "The minimum integer in the array is: " << min << endl;
    return min;
}

void sumRows (int matrix[MAX_ROWS][MAX_COLS], int rows, int cols, int* sumArr) {
    int sum;
    for (int i = 0; i < rows; i++) {
        sum = 0;
        for (int j = 0; j < cols; j++)
            sum += matrix[i][j];
        sumArr[i] = sum;
    }
    cout << "The sum of rows in the array is: ";
    for (int i = 0; i < rows; i++)
        cout << sumArr[i] << " ";
    cout << endl;
}

void sumColumns (int matrix[MAX_ROWS][MAX_COLS], int rows, int cols, int* sumArr) {
    int sum;
    for (int i = 0; i < cols; i++) {
        sum = 0;
        for (int j = 0; j < rows; j++)
            sum += matrix[j][i];
        sumArr[i] = sum;
    }
    cout << "The sum of columns in the array is: ";
    for (int i = 0; i < cols; i++)
        cout << sumArr[i] << " ";
    cout << endl;
}

void findMinLocation (int matrix[MAX_ROWS][MAX_COLS], int rows, int cols, int& minRow, int& minCol) {
    int min = matrix[0][0];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++)
            if (matrix[i][j] < min) {
                min = matrix[i][j];
                minRow = i;
                minCol = j;
            }
    }
    cout << "The minimum integer in the array is located at position [" << minRow << "][" << minCol << "]" << endl;
}

void findMaxLocation (int matrix[MAX_ROWS][MAX_COLS], int rows, int cols, int& maxRow, int& maxCol) {
    int max = matrix[0][0];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++)
            if (matrix[i][j] > max) {
                max = matrix[i][j];
                maxRow = i;
                maxCol = j;
            }
    }
    cout << "The maximum integer in the array is located at position [" << maxRow << "][" << maxCol << "]" << endl;    
}

int main () {
    int rows, cols, search, max, min, minRow, minCol, maxRow, maxCol;
    int matrix[MAX_ROWS][MAX_COLS];
    int sumRow[MAX_COLS], sumCol[MAX_COLS];

    cout << "Enter the number of rows of the matrix between 1 and " << MAX_ROWS << ": ";
    do {
        cin >> rows;
        if (rows < 1 || rows > MAX_ROWS)
            cout << "Invalid input. Please enter a value between 1 and " << MAX_ROWS << ": ";
    } while (rows < 1 || rows > MAX_ROWS);

    cout << "Enter the number of columns of the matrix between 1 and " << MAX_COLS << ": ";
    do {
        cin >> cols;
        if (cols < 1 || cols > MAX_COLS)
            cout << "Invalid input. Please enter a value between 1 and " << MAX_COLS << ": ";
    } while (cols < 1 || cols > MAX_COLS);
    
    inputMatrix (matrix, rows, cols);
    cout << "Enter the integer to search for: ";
    cin >> search;
    searchInteger (matrix, rows, cols, search);
    displayMatrix (matrix, rows, cols);
    max = findMax (matrix, rows, cols);
    min = findMin (matrix, rows, cols);
    sumRows (matrix, rows, cols, sumRow);
    sumColumns (matrix, rows, cols, sumCol);
    findMinLocation (matrix, rows, cols, minRow, minCol);
    findMaxLocation (matrix, rows, cols, maxRow, maxCol);
}
