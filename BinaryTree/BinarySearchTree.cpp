#include "BinarySearchTree.h"

#include <iostream>
#include <iomanip>


Node *BST::createTree() {
    return nullptr;
}

/*
 * ���������� ������� node � ��� ��������
 * @param node ��������� �� ����
 */
void deleteNodeRecursively(Node *node) {
    if (node == nullptr)
        return;

    deleteNodeRecursively(node->left);
    deleteNodeRecursively(node->right);

    delete node;
}

void BST::deleteTree(Node *root) {
    deleteNodeRecursively(root);
}

/*
 * ���� ���� � ������ key
 * return ��������� �� ���� � ������ key
 */
Node *find(Node *root, int key) {
    Node *curr = root;

    while (curr != nullptr && key != curr->key) {
        if (key < curr->key)
            curr = curr->left;
        else
            curr = curr->right;
    }

    return curr;
}


bool BST::contains(Node *root, int key) {
    return find(root, key) != nullptr;
}

void BST::insert(Node **root, int key) {
    Node *curr = *root;
    Node *parentOfCurr = nullptr;

    while (curr != nullptr) {
        parentOfCurr = curr;
        if (key < curr->key)
            curr = curr->left;
        else
            curr = curr->right;
    }

    Node *insertableNode = new Node(key);
    insertableNode->parent = parentOfCurr;

    if (parentOfCurr == nullptr) // if tree was empty
        *root = insertableNode;
    else if (key < parentOfCurr->key)
        parentOfCurr->left = insertableNode;
    else
        parentOfCurr->right = insertableNode;
}

/*
 * �������� ��������� u ���������� v.
 * �������� u ���������� ��������� v, v ���������� ��������������� �������� �����
 * ������������� �� ��������� � u ����.
 * u ��������� �� ���������
 * v ��������� �� ���������
 */
void transplant(Node **root, Node *u, Node *v) {
    if (u->parent == nullptr)
        *root = v;
    else if (u == u->parent->left)
        u->parent->left = v;
    else
        u->parent->right = v;

    if (v != nullptr)
        v->parent = u->parent;
}

/*
 * ���� ���� � ��������� subtree � ����������� ������
 * subtree ��������� �� ���������
 * return ��������� �� ���� � ����������� ������
 */
Node *min(Node *subtree) {
    Node *curr = subtree;

    while (curr->left != nullptr)
        curr = curr->left;

    return curr;
}

void BST::remove(Node **root, int key) {
    Node *removableNode = find(*root, key);

    if (removableNode == nullptr)
        return;

    if (removableNode->left == nullptr) {
        transplant(root, removableNode, removableNode->right);
    } else if (removableNode->right == nullptr) {
        transplant(root, removableNode, removableNode->left);
    } else {
        Node *successorNode = min(removableNode->right);

        if (successorNode->parent != removableNode) {
            transplant(root, successorNode, successorNode->right);
            successorNode->right = removableNode->right;
            successorNode->right->parent = successorNode;
        }

        transplant(root, removableNode, successorNode);
        successorNode->left = removableNode->left;
        successorNode->left->parent = successorNode;
    }
}

void print(Node *node, int depth) {
    using std::cout;
    using std::endl;
    using std::setw;

    if (node == nullptr)
        return;

    print(node->right, depth + 1);

    for (int i = 0; i < depth; ++i)
        cout << "    ";
    static const int WIDTH = 4;
    cout << setw(WIDTH) << node->key << endl;

    print(node->left, depth + 1);
}

/*
 * ������� ������ � ����������� ����� ������, ������� � �������� ������� ���� (������ �����)
 */
void BST::print(Node *root) {
    print(root, 0);
}
