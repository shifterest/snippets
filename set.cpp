#include <iostream>
#include <string>
#include <vector>
#include <regex>

using namespace std;

const regex SET_NOTATION("\\s*\\{\\s*(.*)\\s*\\}\\s*");
const regex TRIM_NOTATION("\\s*(.*)\\s*");

vector<vector<string>> parseSet (int n) {
	vector<vector<string>> sets(n, vector<string>(0));
    string rawSet;
    
	for (int i = 0; i < n; i++) {
		do {
			cout << "Enter the member elements of set " << char(65 + i) << "? ";
			
	        // Get user input
	        getline (cin, rawSet);
	        
	        // Check if user input is using set notation
	        if (regex_match(rawSet, SET_NOTATION)) {
	            // Extract set elements as a single string
	            smatch match;
	            regex_search(rawSet, match, SET_NOTATION);
	            string rawElements = match[1].str();
	            int pos1 = 0, pos2 = 0;
	            
	            // Split elements using comma as delimiter
	            while (pos2 != string::npos) {
	                pos2 = rawElements.find_first_of (",", pos1);
	                if (pos1 != 0 || pos2 != string::npos)
	                    sets[i].push_back(rawElements.substr (pos1, pos2 - pos1));
	                pos1 = pos2 + 1;
	            }
	            
	            // Trim whitespace from elements
	            for (string& e : sets[i]) {
	                smatch element;
	                regex_search(e, element, TRIM_NOTATION);
	                e = element[1].str(); 
	            }
	        }
	        else cout << "This is not a valid set." << endl;
	    } while (!regex_match(rawSet, SET_NOTATION));
	}
	
	return sets;
}

vector<string> getUnion (vector<string> A, vector<string> B) {
    vector<string> set = A;
    
    for (const string& e : B) {
        if (!count (set.begin(), set.end(), e)) set.push_back(e);
    }
    
    return set;
}

vector<string> getIntersection (vector<string> A, vector<string> B) {
    vector<string> set;
    
    for (const string& e : B) {
        if (count (A.begin(), A.end(), e)) set.push_back(e);
    }
    
    return set;
}

vector<string> getDiffAB (vector<string> A, vector<string> B) {
    vector<string> set;
    
    for (const string& e : A) {
        if (!count (B.begin(), B.end(), e)) set.push_back(e);
    }
    
    return set;
}

vector<string> getDiffBA (vector<string> A, vector<string> B) {
    vector<string> set;
    
    for (const string& e : B) {
        if (!count (A.begin(), A.end(), e)) set.push_back(e);
    }
    
    return set;
}

vector<string> getCartProd (vector<string> A, vector<string> B) {
    vector<string> set;
    
    for (const string& e : A) {
        for (const string& f : B) {
            string p = "{" + e + ", " + f + "}";
            set.push_back(p);
        }
    }
    
    return set;
}

void printVect (vector<string> vect) {
    for (auto it = vect.begin(); it != vect.end(); it++) {
        if (it != vect.begin()) cout << ", ";
        cout << *it;
    }
}

int main () {
	vector<vector<string>> sets;
    int setN;
    
    do {
    	cout << "How many sets? ";
	    cin >> setN;
	    cin.ignore();
	    
	    if (setN < 2) cout << "You need at least 2 sets." << endl;
	    // Warning for more than 3 sets
	    else if (setN > 2)
			cout << "WARNING: This program is only built for two sets. nWill process first two sets only." << endl;
	} while (setN < 2);
    
	sets = parseSet(setN);
    cout << endl;
    
    // 2 sets only
    cout << "A ∪ B = {";
    printVect (getUnion (sets[0], sets[1]));
    cout << "}" << endl;
    
    cout << "A ∩ B = {";
    printVect (getIntersection (sets[0], sets[1]));
    cout << "}" << endl;
    
    cout << "A - B = {";
    printVect (getDiffAB (sets[0], sets[1]));
    cout << "}" << endl;
    
    cout << "B - A = {";
    printVect (getDiffBA (sets[0], sets[1]));
    cout << "}" << endl;
    
    cout << "A × B = {";
    printVect (getCartProd (sets[0], sets[1]));
    cout << "}" << endl;
    
    return 0;
}
