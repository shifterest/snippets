#include <iostream>
#include <regex>
#include <string>

using namespace std;

int main() {
    // A = {b E N | b is a multiple of 5}
    regex definition("\\s*([a-zA-Z]+)\\s*=\\s*\\{\\s*([a-zA-Z]+)\\s*[E∈]\\s*N\\s*\\|\\s*([a-zA-Z]+)\\s+is\\s+a\\s+multiple\\s+of\\s+(\\d+)\\s*\\}");
    string input, name;
    int mult, value;

    cout << "Enter set definition: ";
    getline(cin, input);

    if (!regex_match(input, definition)) {
        cout << "The set definition cannot be parsed.";
        return 1;
    }
    smatch match;
    regex_search(input, match, definition);
    if (match[2].str() != match[3].str()) {
        cout << "The variable names don't match.";
        return 1;
    }
    name = match[1].str();
    mult = stoi(match[4].str());

    do {
        cout << endl << "Enter a value: ";
        cin >> value;

        if (value % mult == 0 && value != 0)
            cout << value << " is an element of " << name << endl;
        else
            cout << value << " is not an element of " << name << endl;
    } while (value != 0);

    return 0;
}
