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


class StringMath
{
    char* p;
public:
// Add necessary constructors and destructors and function
    StringMath()
    {
        p=new char[1];
        *p='\0';
        //cerr<<"C1"<<endl;
    }

    StringMath(char *s)
    {
        int l = strlen(s);
        p=new char[l+1];
        for(int i=l;i>=0;i--)
            *(p+i)=*(s+i);
        //cerr<<"C2"<<endl;
    }

    ~StringMath()
    {
        delete p;
        //cerr<<"DES"<<endl;
    }

    StringMath (const StringMath& S)
    {
        int l=S.len();
        p= new char[l+1];
        for(int i=0;i<=l;i++)
            *(p+i)=*(S.p+i);
        //cerr<<"CC"<<endl;

    }

    int len() const         ///this function promises not to modify object, hence the const
    {
        return strlen(p);
    }

    void print()
    {
        for(int i=0;i<=strlen(p);i++)
            cout<<*(p+i);
        cout<<endl;
    }

    StringMath& operator=(const StringMath& S)
    {
        delete p;
        int l=S.len();
        p=new char[l+1];
        for(int i=0;i<=l;i++)
            *(p+i)=*(S.p+i);
        return *this;
    }

    int operator>(StringMath& S)
    {
        if(len()>S.len())
            return 1;
        else if(len()<S.len())
            return 0;
        else
        {
            for(int i=0;i<=len();i++)
            {
                if(*(p+i)>*(S.p+i))
                    return 1;
                else if(*(p+i)<*(S.p+i))
                    return 0;
            }
            return 0;
        }
    }

    int operator>(int n)
    {
        char *a;
        a=itos(n);
        StringMath S(a);
        if(len()>S.len())
            return 1;
        else if(len()<S.len())
            return 0;
        else
        {
            for(int i=0;i<=len();i++)
            {
                if(*(p+i)>*(S.p+i))
                    return 1;
                else if(*(p+i)<*(S.p+i))
                    return 0;
            }
            return 0;
        }
    }

    StringMath operator+(StringMath& S)
    {
        StringMath S1,S2;
        char *a;
        if(S>*this)
        {
            S1=S;
            S2=*this;
        }
        else
        {
            S1=*this;
            S2=S;
        }
        a=new char[S1.len()+1];
        a[S1.len()]='\0';
        int d=S1.len()-S2.len();
        char c1,c2;
        int d1,d2,r=0,s;
        for(int i=S2.len()-1;i>=0;i--)
        {
            c1=S1.p[d+i];
            c2=S2.p[i];
            d1=c1-'0';
            d2=c2-'0';
            s=d1+d2+r;
            if(s>9)
            {
                r=1;
                s-=10;
            }
            a[i]=s+'0';

        }
        if(r==0)
        {
            StringMath ans(a);
            return ans;

        }
        else if(S1.len())
        {
            char *a2= new char[S1.len()+2];
            a2[S1.len()+1]='\0';
            a2[0]='1';
            for(int i=0;i<S1.len();i++)
            {
                a2[i+1]=a[i];
            }
            StringMath ans(a2);
            return ans;
        }



    }
};
int main()
{
    char s[20]="1234";
    /*int l=strlen(s);
    if(s[strlen(s)]=='\0')
        cout<<"Yo"<<endl;
        char *c;
        c=new char[strlen(s)+1];
        c[l]='\0';
        cout<<strlen(c)<<endl;
    */
    StringMath S1,S2("43212"),S3(s);
    StringMath S4,S5=S2;
    S4=S2=S3;
    S1.print();
    S2.print();
    S3.print();
    cout<<S1.len()<<endl;
    cout<<S2.len()<<endl;
    S4.print();
    S5.print();
    cout<<endl<<endl;
    StringMath S8="1232",S9="0";
    if(S8>S9)
        cout<<"S8>S9"<<endl;
    if(S9>S8)
        cout<<"S9>S8"<<endl;
//    if(S2>S4)
//        cout<<"S2>S5"<<endl;
    if(S8> 1234)
        cout<<"S8>1234"<<endl;
    S4.print();
    S4=S8+S9;
    S4.print();
}
