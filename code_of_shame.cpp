#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int getMultiple (string str) {
	int pos1, pos2, multiple;
	
	pos1 = str.find ("of ") + 3;
	if (pos1 < 0) return -1;
	pos2 = str.find ("}", pos1) - 1;
	
	stringstream num (str.substr (pos1, pos2));
	num >> multiple;
        
    return multiple;
}

int main() {
	int mult, v;
    string input;
    
    // A = {b E N | b is a multiple of 5}
    cout << "Enter set definition: ";
    getline (cin, input);
    mult = getMultiple (input);
    if (mult < 0) {
    	cout << "I don't understand.";
    	return 1;
	}
    
    do {
    	cout << endl << "Enter a value: ";
	    cin >> v;
	    
	    if (v % mult == 0)
	    	cout << v << " is an element of A" << endl;
		else
			cout << v << " is not an element of A" << endl;
	} while (v != 0);
    
    return 0;
}
