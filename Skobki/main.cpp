#include <iostream>

using namespace std;

int main() {
    setlocale(LC_ALL, "rus");
    string s;
    int count = 0;
    cout << "������� ����� �� ��������" << endl;
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
        cout << "�����" << endl;
    }
    else
    {
        cout << "�������" << endl;
    }
    return 0;
}
