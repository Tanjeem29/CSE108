#include <iostream>
#include "testclass.h"
using namespace std;
int main()
{
    integer p;
    int q;
    cin>>q;
    p.setint(q);
    cout<<p.getint()<<endl;
    return 0;
}

