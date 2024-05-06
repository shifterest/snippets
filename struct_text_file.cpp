#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
#include <sstream>
using namespace std;

struct Item {
    int itemNo = 0;
    string description = "";
    int quantity = 0;
    float unitPrice = 0.0;
    float amount = 0.0;
    
    float calculateAmount () {
        amount = quantity * unitPrice;
        return amount;
    }
};

string formatPrice (float price) {
    stringstream priceStream;
    priceStream << fixed << setprecision (2) << price;
    
    string priceStr = priceStream.str();
    
    for (int pos = priceStr.find ('.') - 3; pos > 0; pos -= 3)
        priceStr.insert (pos, ",");
        
    return priceStr;
}

string padStrRight (const string& str, int width) {
    string paddedStr = str;
    
    if (paddedStr.length() < width) {
        paddedStr += string(width - paddedStr.length(), ' ');
    }
    
    return paddedStr;
}

string padStrLeft (const string& str, int width) {
    string paddedStr = str;
    
    if (paddedStr.length() < width) {
        paddedStr = string(width - paddedStr.length(), ' ') + paddedStr;
    }
    
    return paddedStr;
}

int main () {
    // Steps 1-5
    int itemNum = 0;
    string input;
    cout << "Enter file to open (input, input2): ";
    cin >> input;
    ifstream inputFile (input + ".txt");
    if (!inputFile.is_open()) {
        cerr << "Error opening the input file." << endl;
        return 1;
    }
    else {
        // Placeholder string, will only be used to count
        string line;
        while (getline (inputFile, line)) itemNum++;
    }
    inputFile.close();
    
    // Steps 6-8
    inputFile.open (input + ".txt");
    if (!inputFile.is_open()) {
        cerr << "Error opening the input file." << endl;
        return 1;
    }
    Item items[itemNum];
    float sum = 0;
    
    // Steps 9-13
    ofstream outputFile ("output.txt");
    if (!outputFile.is_open()) {
        cerr << "Error opening the output file." << endl;
        return 1;
    }
    string line, members[5];
    for (int i = 0; i < itemNum; i++) {
        getline (inputFile, line);
        // Iterate through the line and store comma-separated values
        int pos1 = 0, pos2 = 0;
        for (int j = 0; pos2 != string::npos; j++) {
            pos2 = line.find_first_of (",", pos1);
            members[j] = line.substr (pos1, pos2 - pos1);
            pos1 = pos2 + 1;
        }
        items[i].itemNo = stoi (members[0]);
        items[i].description = members[1];
        items[i].quantity = stoi (members[2]);
        items[i].unitPrice = stof (members[3]);
        items[i].calculateAmount();
        sum += items[i].amount;
    }
    
    // Steps 13-15
    outputFile << padStrRight ("ITEM #", 10) << padStrRight ("Description", 30)
               << padStrLeft ("Quantity", 12) << padStrLeft ("Unit price", 15)
               << padStrLeft ("Amount", 15) << endl;
    for (int i = 0; i < itemNum; i++) {
        outputFile << padStrRight (to_string (items[i].itemNo), 10)
                   << padStrRight (items[i].description, 30)
                   << padStrLeft (to_string (items[i].quantity), 12)
                   << padStrLeft ("$ " + formatPrice (items[i].unitPrice), 15)
                   << padStrLeft ("$ " + formatPrice (items[i].amount), 15)
                   << endl;
    }
    outputFile << endl << "Total amount of all items: $ " << formatPrice (sum);

    // Steps 16-19
    inputFile.close();
    outputFile.close();
    cout << "Output has been written to the file output.txt";
    return 0;
}
