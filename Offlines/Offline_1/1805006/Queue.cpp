#include <iostream>
#include <cstdlib>

using namespace std;

class Queue
{
    Array s;
    int size;
    int front;
    int rear;
public:
    Queue(int x)
    {
        size=x+1;
        s.setLength(getSize());
        front=0;
        rear=0;
    }
    Queue()
    {
        size=1;
        s.setLength(getSize());
        front=0;
        rear=0;
    }
    int getFront()
    {
        return front;
    }
    void setFront(int x)
    {
        front =x;
    }
    void reset()
    {
        rear=front;
    }
    int getRear()
    {
        return rear;
    }
    void setSize(int x)
    {
        size=x+1;
        s.setLength(getSize());
    }
    int getSize()
    {
        return size;
    }
    int isFull()
    {
        if((rear+1==front)||(front==0&&rear==getSize()))
            return 1;
        return 0;
    }
    int isEmpty()
    {
        if(front==rear)
            return 1;
        return 0;
    }
    void enqueue(int x)
    {
        if(isFull())
        {
            cout << "Queue is full" << endl;
            exit(0);
        }
        else
        {
            rear++;
            if(rear==getSize())
                rear=0;
            s.setElementAt(rear,x);
        }
    }
    int dequeue()
    {
        if(isEmpty())
        {
            cout << "Queue is empty" << endl;
            exit(0);
        }
        else
        {
            front++;
            if(front==getSize())
                front=0;
            int p=s.getElementAt(front);
            return p;
        }
    }
    void clone(Queue q)
    {
        setFront(q.getFront());
        reset();
        int t;
        setSize(q.getSize());
        while(!(q.isEmpty()))
        {
            t=q.dequeue();
            enqueue(t);
        }


    }
};
