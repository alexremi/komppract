#ifndef NODE_H_INCLUDED
#define NODE_H_INCLUDED


struct Node {
    const int key;
    Node *left = nullptr;
    Node *right = nullptr;
    Node *parent = nullptr;

    explicit Node(int key) : key(key) {}
};


#endif //BST_NODE_H
