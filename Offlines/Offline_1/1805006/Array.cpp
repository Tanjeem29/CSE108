#include <iostream>
#include <cstdlib>
using namespace std;
#define SIZE 100
#define EMPTY -99

class Array
{
    int a[SIZE];
    int length;
public:
    Array()
    {
        length = 0;
    }
    Array(int size)
    {
        length = size;
        for (int i = 0; i < size; i++)
        {
            a[i] = EMPTY;
        }
    }
    Array(int size, int x)
    {
        length=size;
        for(int i=0;i<size;i++)
            a[i]=x;
    }
    Array(int size, int *x)
    {
        length = size;
        for(int i=0;i<size;i++)
        {
            a[i]=x[i];
        }
    }
    void setLength(int size)
    {
        length = size;
    }
    int getLength()
    {
        return length;
    }
    void setElementAt(int i, int e)
    {
        if(i >= length)
        {
            cout << "Invalid Index" << endl;
            exit(0);
        }
        else
        {
            a[i]=e;
        }
    }
    int getElementAt(int i)
    {
        if(i >= length)
        {
            cout << "Invalid Index" << endl;
            exit(0);
        }
        else
        {
            return a[i];
        }
    }
    void print()
    {
        for(int i =0; i < length; i++)
        {
            cout << a[i] << " ";
        }
        cout << endl;
    }
    void clone(Array c)
    {
        int l;
        l=c.getLength();
        setLength(l);
        for(int i=0;i<l;i++)
        {
            setElementAt(i,c.getElementAt(i));
        }
    }
};
