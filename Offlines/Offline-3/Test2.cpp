#include<iostream>
#include<cstring>
using namespace std;

char* itos(int n)
{
    char *a;
    int l=0, temp;
    temp=n;
    while(temp)
    {
        l++;
        temp/=10;
    }
    a=new char[l+1];
    temp=n;
    a[l]='\0';
    for(int i=l-1;i>=0;i--)
    {
        int r=temp%10;
        *(a+i)='0'+r;
        temp/=10;
    }
    return a;
}
int main()
{
    int n=123456;
    char *s;
    s=itos(n);
    cout<<s<<endl;
    cout<<s[6]<<' '<<s[5]<<endl;
    char z=7+'0';
    cout<<z;


}
