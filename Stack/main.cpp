#include <iostream>

using namespace std;

struct stek
{
    int val;
    struct stek *next;
};


int pop(stek* &NEXT)
{
    int res = NEXT->val;
    stek *Stack = NEXT;
    NEXT = NEXT->next;
    delete Stack;
    cout<<res<<endl;;
    return res;
}

int push(stek* &NEXT, const int VAL)
{
    stek *Stack = new stek;
    Stack->val = VAL;
    Stack->next = NEXT;
    NEXT = Stack;
}


int main()
{
    stek *x=0;

    push(x,1);
    push(x,2);
    push(x,3);
    push(x,4);

    pop(x);
    pop(x);
    pop(x);
    pop(x);

    return 0;
}
