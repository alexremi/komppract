#include <iostream>
using namespace std;


void swapEl(int *arr, int i)
{
	int buff;
	buff = arr[i];
	arr[i] = arr[i - 1];
	arr[i - 1] = buff;
}


void myShakerSort(int *arr, int size)
{
	int leftMark = 1;
	int rightMark = size - 1;
	while (leftMark <= rightMark)
	{
		for (int i = rightMark; i >= leftMark; i--)
		if (arr[i - 1] > arr[i]) swapEl(arr, i);
		leftMark++;


		for (int i = leftMark; i <= rightMark; i++)
		if (arr[i - 1] > arr[i]) swapEl(arr, i);
		rightMark--;

	}
}

int main()
{
	setlocale(LC_ALL, "rus");

	int size = 0;
	cout << "Размер массива: ";
	cin >> size;
	int *A = new int[size];

	for (int k = 0; k < size; k++)
	{
		A[k] = size - k;
		cout << A[k]  << " | ";
	}

	myShakerSort(A, size);

	cout << "\nМассив после сортировки:\n";
	for (int k = 0; k < size; k++)
	{
		cout << A[k] << " | ";
	}
	cout << endl;
	return 0;
}
