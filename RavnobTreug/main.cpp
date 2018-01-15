#include <iostream>

using namespace std;

int main() {
    setlocale(LC_ALL, "rus");
    char s = '*';
    int n;
    int m;
    cout << "Высота:" << endl;
    cin >> m;
    char a[m][m];
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < m; j++)
        {
            a[i][j] = ' ';
        }
    }
    for (int i = 0; i < m; i++)
    {
        for (int j = m - 1 - i; j < m; j++)
        {
            a[j][i] = s;
        }
    }
    for (int i = 0; i < m; i++)
    {

        for (int j = 0; j < m; j++)
        {
            cout << a[i][j];
        }
        if (i > 0)
        {
            for (int j = m-1; j >= 0; j--)
            {
                cout << a[i-1][j];
            }
        }
        cout << endl;
    }
    return 0;
}
