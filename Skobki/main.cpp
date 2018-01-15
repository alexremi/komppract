#include <iostream>

using namespace std;

int main() {
    setlocale(LC_ALL, "rus");
    string s;
    int count = 0;
    cout << "Введите текст со скобками" << endl;
    cin >> s;
    for (int i = 0; i < s.length();i++)
    {
        if (s[i] == '(')
        {
            count++;
        }
        if (s[i] == ')')
        {
            count--;
        }
    }
    if (count == 0)
    {
        cout << "Верно" << endl;
    }
    else
    {
        cout << "Неверно" << endl;
    }
    return 0;
}
