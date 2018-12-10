#include <iostream>
#include "Node.h"
#include "BinarySearchTree.h"
#include "BinarySearchTree.cpp"
using namespace std;


int main() {
    setlocale(LC_ALL,"Russian");
    Node *root = BST::createTree();

    int keys[] = { 8, 7, 6, 2, 10, 11, 4, 5, 9, 10, 7, 5, 12, 13, 11, 20, 0, 1 };

    for (int key : keys)
        BST::insert(&root, key);

    BST::print(root);

    cout << "� ������ ���� ���� 8? " << ( BST::contains(root, 8) ? "true" : "false" ) << endl;

    BST::remove(&root, 8); // ������
    BST::remove(&root, 13); // ����
    BST::remove(&root, 2); // ������ � ������ ��������
    BST::remove(&root, 12); // ������ � ����� ��������

    //cout << "BST::contains(root, 8): " << ( BST::contains(root, 8) ? "true" : "false" ) << endl;

    cout << "================================================================================" << endl;

    BST::print(root);
    cout << "� ������ ���� ���� 11? " << ( BST::contains(root, 11) ? "true" : "false" ) << endl;
    cout << "� ������ ���� ���� 8? " << ( BST::contains(root, 8) ? "true" : "false" ) << endl;

    BST::deleteTree(root);
    return 0;
}
