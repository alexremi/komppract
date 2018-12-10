#ifndef BINARYSEARCHTREE_H_INCLUDED
#define BINARYSEARCHTREE_H_INCLUDED
#include "Node.h"

namespace BST {
    /*
     * �����������
     * return ��������� �� ������ ���������� ������
     */
    Node *createTree();

    /*
     * ����������
     * root ��������� �� ������ ������
     */
    void deleteTree(Node *root);

    /*
     * ��������� ������� ���� � ������ key � ������
     * root ��������� �� ������ ������
     * return true, ���� ��������, ����� false
     */
    bool contains(Node *root, int key);

    /*
     * ��������� � ������ ���� � ������ key
     * root ��������� �� ��������� �� ������ ������
     */
    void insert(Node **root, int key);

    /*
     * ������� �� ������ ���� � ������ key
     * @param root ��������� �� ��������� �� ������ ������
     * @param key
     */
    void remove(Node **root, int key);

    /*
     * ������� ������ � ����������� ����� ������
     */
    void print(Node *root);
}

#endif // BINARYSEARCHTREE_H_INCLUDED
