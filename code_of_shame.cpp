#include <iostream>
#include <string>
#include <sstream>
using namespace std;

string parseInput (string str, int &multiple, string &name) {
	// A = {b E N | b is a multiple of 5}
	bool hasName = false, 
		 hasEqual = false,
		 hasElementName = false,
		 hasE = false,
		 hasN = false,
		 hasPipe = false,
		 hasCondition = false,
		 hasMultiple = false;
	string word, words[50], elementName;
	
	stringstream ss(str);
	for (int i = 0; getline(ss, word, ' '); i++) {
		words[i] = word;
	}
	
	for (int i = 0; i < 50; i++) {
		if (words[i] == "") continue;
		if (!hasName) {
			name = words[i];
			hasName = true;
		}
		if (!hasEqual && words[i] == "=") hasEqual = true;
		if (!hasElementName) {
			if (words[i][0] == "{") {
				elementName = words[i].substr(1);
				hasElementName = true;
			}
		}
		if (!hasE && words[i] == "E") hasE = true;
		if (!hasN && words[i] == "N") hasE = true;
		if (!hasPipe && words[i] == "|") hasE = true;
		if (!hasCondition) {
			if (
				words[i] == elementName
				&& words[i + 1] == "is"
				&& words[i + 1] == "a"
				&& words[i + 1] == "multiple"
				&& words[i + 1] == "of"
			) hasCondition = true;
		}
		if (!hasMultiple) {
			if (words[i].back() == "}") {
				stringstream num (words[i].substr(0, words[i].length() - 1));
				num >> multiple;
				return 0;
			}
		}
	}
	
	return 1;
}

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
	int mult, value;
    string input, name;
    
    // A = {b E N | b is a multiple of 5}
    cout << "Enter set definition: ";
    getline (cin, input);
    parseInput (input, mult, name);
    if (mult < 0) {
    	cout << "I don't understand.";
    	return 1;
	}
    
    do {
    	cout << endl << "Enter a value: ";
	    cin >> value;
	    
	    if (value % mult == 0 && value != 0)
	    	cout << value << " is an element of A" << endl;
		else
			cout << value << " is not an element of A" << endl;
	} while (value != 0);
    
    return 0;
}
