#include "stdafx.h"
#include <iostream>
using namespace std;
int i, j, n, d, count;
void Shell(int A[], int n)
{
d=n;
d=d/2;
while (d>0)
{
for (i=0; i<n-d; i++)
{
j=i;
while (j>=0 && A[j]>A[j+d])
{
count=A[j];
A[j]=A[j+d];
A[j+d]=count;
j--;
}
}
d=d/2;
}
for (i=0; i<n; i++) cout<<A[i]<<" ";
}

void main()
{
setlocale(LC_ALL,"Rus");
cout<<"Размер массива > "; cin>>n;
int *A= new int[n];
for (i=0; i<n; i++)
{ cout<<i+1<<" элемент > "; cin>>A[i]; }
cout<<"\nИтоговый массив: ";
Shell(A, n);
delete [] A;
system("pause>>void");
}
