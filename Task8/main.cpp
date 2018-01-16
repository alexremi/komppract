#include <iostream>
#include <string>
#include <fstream>

using namespace std;
string act1 (string str);
string act2 (string str);

int main() {
    string str, backstroka;
    cin >> str;
    str = act1 (str);
    cout << str << endl;
    str = act2 (str) ;
    cout << str << endl;
    return 0;
}

string act1 (string str) {
    string backstroka;
    for (int i = 0; i < str.length(); i++) {
        int count = 1;
        while (str[i] == str[i + 1]) {
            count ++;
            i++;
        }
        if (count > 1) {
            backstroka.push_back (str[i]);
            backstroka.push_back (count + '0');
        } else {
            backstroka.push_back (str[i]);
        }
    }
    return backstroka;
}

string act2 (string str) {
    string backstroka;
    for (int i = 0; i < str.length(); i++) {
        int count = 0;
        if (str[i] >= 97 && str[i] <= 122 && (str[i + 1] - '0') > 1 && (str[i + 1] - '0') < 9) {
            int j = i + 1;
            while ( (str[j] - '0') > 1 && (str[j] - '0') < 9) {
                count += str[j] - '0';
                j++;
            }
            for (int z = 0; z < count; z ++) {
                backstroka.push_back (str[i]);
            }
            i += 1 + count / 10;
        }
        if (count  == 0)
            backstroka.push_back (str[i]);
    }
    return backstroka;
}
