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
    }

    StringMath(char *s)
    {
        int l = strlen(s);
        p=new char[l+1];
        for(int i=l;i>=0;i--)
            *(p+i)=*(s+i);
    }

    ~StringMath()
    {
        delete p;
    }

    StringMath (const StringMath& S)
    {
        int l=S.len();
        p= new char[l+1];
        for(int i=0;i<=l;i++)
            *(p+i)=*(S.p+i);
        //cerr<<"CC"<<endl;

    }

    void print()
    {
        for(int i=0;i<=strlen(p);i++)
            cout<<*(p+i);
        cout<<endl;
    }

    int len() const         ///this function promises not to modify object, hence the const
    {
        return strlen(p);
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

    StringMath& operator=(const StringMath& S)
    {
        delete p;
        int l=S.len();
        p=new char[l+1];
        for(int i=0;i<=l;i++)
            *(p+i)=*(S.p+i);
        return *this;
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
        //S1.print();
        //S2.print();
        a=new char[S1.len()+1];
        a[S1.len()]='\0';
        int d=S1.len()-S2.len();
        char c1,c2;
        int d1,d2,r=0,s;
        for(int i=S2.len()-1;i>=0;i--)
        {
            //cerr<<i<<' ';
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
            else
            {
                r=0;
            }
            a[i+d]=s+'0';

        }
        for(int i=d-1;i>=0;i--)
        {
            //cerr<<i<<' ';
            if(r==0)
            {
                a[i]=S1.p[i];
                continue;
            }
            c1=S1.p[i];
            d1=c1-'0';
            s=d1+r;
            if(s>9)
            {
                r=1;
                s-=10;
            }
            else
            {
                r=0;
            }
            a[i]=s+'0';
        }
        if(r==0)
        {
            //cerr<<a<<endl;
            StringMath ans(a);
            return ans;

        }
        else
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
    StringMath S1;
    StringMath S2("123");
    StringMath S3("757");
    StringMath S4("220");
    StringMath S5;
    int n=345;
    S1=S4;
    //Print the character string of S1 and S4
    S1=S2+S3+S4;
    //Print the character string of S1, S2, S3 and S4, where S1 contains the character string: �1100�
    S5=S4=S3;
    // Print the character string of S5, S4 and S3
    if(S3 > n )
    {
        S5= S3+n;
    }
    // Print the character string of S5, where S5 contains the character string: �1102�
    S5= n+S2;
    // Print the character string of S5, where S5 contains the character string: �468�
    if(S5 > S2)
    {
        S5++; //Assume prefix increment
    }
    // Print the character string of S5, where S5 contains the character string: �469�
}