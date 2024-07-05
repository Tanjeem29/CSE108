#include <iostream>
#include <cstdlib>

using namespace std;

class Stack
{
    Array s;
    int size;
    int top;

public:

    Stack()
    {
        size=0;
        s.setLength(size);
        top=0;
    }
    Stack(int a)
    {
        size=a;
        s.setLength(a);
        top=0;

    }
    void setSize(int x)
    {
        size=x;
        s.setLength(x);
    }
    int getSize()
    {
        return size;
    }
    void clone(Stack a)
    {
        int l=a.getSize();
        setSize(l);
        while(!a.isEmpty())
            push(a.pop());

    }
    void push(int x)
    {
        if(isFull())
        {
            cout << "Stack is full" << endl;
            exit(0);
        }
        else
        {
            s.setElementAt(top,x);
            top++;
        }
    }
    int pop()
    {
        if(isEmpty())
        {
            cout << "Stack is empty" << endl;
            exit(0);
        }
        else
        {
            top--;
            return s.getElementAt(top);
        }
    }
    int isFull()
    {
        if(top==size)
            return 1;
        else
            return 0;
    }
    int isEmpty()
    {
        if(top==0)
            return 1;
        else
            return 0;
    }
};
