#include<cstdlib>
#include "Container.cpp"
class ContainerOp{
    public:
    Container first;
    Container second;

    int op;

    void setFirst(Container f)
    {
        if(f.getStoredType() == INTEGER)
            first.setItem(*(int *)f.getItem());
        else if(f.getStoredType() == INT_ARRAY)
            first.setItem((int *)f.getItem(), f.getFirstDim());
        else if(f.getStoredType() == INT_MATRIX)
            first.setItem((int**)f.getItem(), f.getFirstDim(), f.getSecondDim());
    }
    void setSecond(Container s)
    {
        if(s.getStoredType() == INTEGER)
            second.setItem(*(int *)s.getItem());
        else if(s.getStoredType() == INT_ARRAY)
            second.setItem((int *)s.getItem(), s.getFirstDim());
        else if(s.getStoredType() == INT_MATRIX)
            second.setItem((int**)s.getItem(), s.getFirstDim(), s.getSecondDim());

    }
    Container getFirst()
    {
        return first;
    }
    Container getSecond()
    {
        return second;
    }
    int getOp()
    {
        return op;
    }
    void setOp(int n)
    {
        op=n;
    }
    Container performOp()
    {
        if(second.getStoredType()== INTEGER)
        {
            if(first.getStoredType()== INTEGER)
            {
                Container ans(0);
                if(op==1)
                {
                    int temp=*(int*)first.getItem()-*(int*)second.getItem();
                    ans.setItem(temp);
                    return ans;
                }
                else if(op==0)
                {
                    int temp=*(int*)first.getItem()+*(int*)second.getItem();
                    ans.setItem(temp);
                    return ans;
                }
            }
            else if(first.getStoredType()== INT_ARRAY)
            {
                if(op==0)
                {
                    int n=first.getFirstDim();
                //int m=first.getSecondDim();
                int temp=*(int*)second.getItem();
                Container ans;
                int *a=(int *)first.getItem();
                int i,j;
                for(i=0;i<n;i++)
                {
                    a[i]+=temp;
                }
                ans.setItem(a, first.getFirstDim());
                return ans;
                }
                else
                {
                    int n=first.getFirstDim();
                //int m=first.getSecondDim();
                int temp=*(int*)second.getItem();
                Container ans;
                int *a=(int *)first.getItem();
                int i,j;
                for(i=0;i<n;i++)
                {
                    a[i]-=temp;
                }
                ans.setItem(a, first.getFirstDim());
                return ans;
                }



            }
            else if(first.getStoredType()== INT_MATRIX){
                    if(op==0){
                int n=first.getFirstDim();
                int m=first.getSecondDim();
                int temp=*(int*)second.getItem();
                Container ans;
                int **a=(int **)first.getItem();
                int i,j;
                for(i=0;i<n;i++)
                {
                    for(j=0;j<m;j++)
                    {
                        a[i][j]+=temp;
                    }
                }
                ans.setItem(a, first.getFirstDim(),second.getSecondDim());
                return ans;
                    }
                    else
                    {
                         int n=first.getFirstDim();
                int m=first.getSecondDim();
                int temp=*(int*)second.getItem();
                Container ans;
                int **a=(int **)first.getItem();
                int i,j;
                for(i=0;i<n;i++)
                {
                    for(j=0;j<m;j++)
                    {
                        a[i][j]-=temp;
                    }
                }
                ans.setItem(a, first.getFirstDim(),second.getSecondDim());
                return ans;
                    }

        }
        }
        else
        {
            return first;
        }

    }

};
int main()
{
    int **mat = new int*[2];
        mat[0] = new int[3];
        mat[0][0] = 1;
        mat[0][1] = 2;
        mat[0][2] = 3;
        mat[1] = new int[3];
        mat[1][0] = 4;
        mat[1][1] = 5;
        mat[1][2] = 6;
        Container a(mat, 2, 3);
        a.print();


        Container b(100);
        b.print();


        ContainerOp test;
        test.setFirst(a);
        test.setSecond(b);
        Container ans;
        test.setOp(0);
        ans=test.performOp();

        ans.print();
        test.first.print();
        test.second.print();

        int *arr = new int[3];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        Container c(arr, 3);
        c.print();
        ContainerOp test2;
        test2.setFirst(c);
        test2.setSecond(b);
        test2.setOp(1);
        Container ans2=test2.performOp();
        ans2.print();
        ContainerOp test3;
        test3.setOp(0);
        test3.setFirst(b);
        test3.setSecond(c);
        cout<<"------------"<<endl;
        ans= test3.performOp();
        ans.print();



    return 0;
}
