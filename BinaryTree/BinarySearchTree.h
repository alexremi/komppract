#ifndef BINARYSEARCHTREE_H_INCLUDED
#define BINARYSEARCHTREE_H_INCLUDED
#include "Node.h"

namespace BST {
    /*
     * Конструктор
     * return указатель на корень созданного дерева
     */
    Node *createTree();

    /*
     * Деструктор
     * root указатель на корень дерева
     */
    void deleteTree(Node *root);

    /*
     * Проверяет наличие узла с ключом key в дереве
     * root указатель на корень дерева
     * return true, если содержит, иначе false
     */
    bool contains(Node *root, int key);

    /*
     * Добавляет в дерево узел с ключом key
     * root указатель на указатель на корень дерева
     */
    void insert(Node **root, int key);

    /*
     * Удаляет из дерева узел с ключом key
     * @param root указатель на указатель на корень дерева
     * @param key
     */
    void remove(Node **root, int key);

    /*
     * Выводит дерево в стандартный поток вывода
     */
    void print(Node *root);
}

#endif // BINARYSEARCHTREE_H_INCLUDED
