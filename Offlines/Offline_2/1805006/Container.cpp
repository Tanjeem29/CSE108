# include <iostream>
using namespace std;

# define INTEGER 1
# define INT_ARRAY 2
# define INT_MATRIX 3

// Container class can contain an integer, or an integer array or an integer matrix, but exactly one of them
class Container{
    // Do not add any additional member variable
    int *value;
    int *valueArray;
    int **valueMatrix;
    int firstDim, secondDim;    // the dimensions of array/matrix, in case of single integer, both should be 0
    int storedType;

    // the following is a private method, not needed from outside
    void reset(){
        if (value != NULL){
                delete value;
            // free memory occupied by value
        }
        if (valueArray != NULL){
            delete [] valueArray;
            // free memory occupied by valueArray
        }
        if (valueMatrix != NULL){
            int i;
            for(i=0;i<firstDim;i++)
                delete [] *(valueMatrix+i);
            delete [] valueMatrix;
            // free memory occupied by valueMatrix
        }
        firstDim = 0;
        secondDim = 0;
        storedType = -1;
    }

public:
    // do not write any additional public method except for those which you are asked to, according to the comments
    Container(){
        cout << "Constructing Container with empty parameter" << endl;
        cout << "___________________________________________" << endl;
        value = NULL;
        valueArray = NULL;
        valueMatrix = NULL;
        firstDim = 0;
        secondDim = 0;
        storedType = -1;
    }

    Container (int val){
        cout << "Constructing Container with a single integer parameter" << endl;
        cout << "______________________________________________________" << endl;
        value = new int;
        *value = val;
        // dynamically allocate memory to the appropriate pointer and initialize it with the argument(s) of this constructor
        firstDim = 0;
        secondDim = 0;
        storedType = INTEGER;
    }

    Container (int *valArr, int len){
        cout << "Constructing Container with integer array parameter" << endl;
        cout << "___________________________________________________" << endl;
        // dynamically allocate memory to the appropriate pointer and initialize with the argument(s) of this constructor
        valueArray = new int [len];
        for(int i=0;i<len;i++)
            valueArray[i]=valArr[i];
        firstDim = len;
        secondDim = 0;
        storedType = INT_ARRAY;
    }

    Container (int **valMat, int r, int c){
        cout << "Constructing Container with integer matrix parameter" << endl;
        cout << "____________________________________________________" << endl;
        valueMatrix = new int*[r];
        int i,j;
        for(i=0;i<r;i++)
        {
            *(valueMatrix+i) = new int [c];
        }
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
                valueMatrix[i][j]=valMat[i][j];
        }
        firstDim=r;
        secondDim=c;
        storedType = INT_MATRIX;
        // dynamically allocate memory to the appropriate pointer and initialize with the argument(s)
        // assign appropriate values to the remaining member variables by observing the previous constructors
    }
    Container (const Container &val)
    {
         cout << "Calling copy constructor of Container" << endl;
         cout << "_____________________________________" << endl;
         //if(val.getSecondDim()== 0 && val.getFirstDim() == 0)
         if(val.storedType == INTEGER)
         {
             value = new int;
             *value = *val.value;
             firstDim = 0;
             secondDim = 0;
             storedType = INTEGER;
         }
         else if (val.storedType == INT_ARRAY)
         {
             int len=val.firstDim;
             valueArray = new int [len];
             for(int i=0;i<len;i++)
                 valueArray[i]=val.valueArray[i];
             firstDim = len;
             secondDim = 0;
             storedType = INT_ARRAY;
         }
         else if (val.storedType == INT_MATRIX)
         {
             int r=val.firstDim;
             int c=val.secondDim;
             valueMatrix = new int*[r];
             int i,j;
             for(i=0;i<r;i++)
             {
                 *(valueMatrix+i) = new int [c];
             }
             for(i=0;i<r;i++)
             {
                 for(j=0;j<c;j++)
                     valueMatrix[i][j]=val.valueMatrix[i][j];
             }
             firstDim=r;
             secondDim=c;
             storedType = INT_MATRIX;
         }
    }
    // write a copy constructor whose first two lines should be as follows:
    // cout << "Calling copy constructor of Container" << endl;
    // cout << "_____________________________________" << endl;


    void setItem (int val){
        reset();
        value = new int;
        *value = val;
        firstDim = 0;
        secondDim = 0;
        storedType = INTEGER;
        // write necessary code similar to that of the 2nd constructor
    }
    void setItem (int *valArr, int len){
        valueArray = new int [len];
        for(int i=0;i<len;i++)
            valueArray[i]=valArr[i];
        firstDim = len;
        secondDim = 0;
        storedType = INT_ARRAY;
    }
    void setItem (int **valMat, int r, int c)
    {
        valueMatrix = new int*[r];
        int i,j;
        for(i=0;i<r;i++)
        {
            *(valueMatrix+i) = new int [c];
        }
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
                valueMatrix[i][j]=valMat[i][j];
        }
        firstDim=r;
        secondDim=c;
        storedType = INT_MATRIX;
    }
    // overload setItem function so that it can dynamically allocate and initialize the member integer array
    // observe the 3rd constructor to understand its parameters and tasks

    // overload setItem function so that it can dynamically allocate and initialize the member integer matrix
    // observe the 4th constructor to understand its parameters and tasks

    // the following function returns a void* which can be cast to any pointer based on the storedType variable
    void * getItem(){
        if (storedType==INTEGER) return value;
        else if (storedType==INT_ARRAY) return valueArray;
        if (storedType==INT_MATRIX) return valueMatrix;
        return NULL;
    }

    int getFirstDim(){
        return firstDim;
    }

    int getSecondDim(){
        return secondDim;
    }

    int getStoredType(){
        return storedType;
    }

    void print(){
        if (storedType==INTEGER){
            cout << "There is only an integer value in the container object" << endl;
            cout << "The value is: " << *value << endl;
        }
        else if (storedType==INT_ARRAY){
            cout << "There is an integer array in the container object" << endl;
            cout << "The values stored in the array are:" << endl;
            for (int i=0; i<firstDim; i++){
                cout << valueArray[i] << " ";
            }
            cout << endl;
        }
        else if (storedType==INT_MATRIX){
            cout << "There is an integer matrix in the container object" << endl;
            cout << "The values stored in the matrix are:" << endl;
            for (int i=0; i<firstDim; i++){
                for (int j=0; j<secondDim; j++){
                    cout << valueMatrix[i][j] << " ";
                }
                cout << endl;
            }
        }
        else{
            cout << "The object has no elements" << endl;
        }
    }

    ~Container(){
        if (storedType==INTEGER){
            cout << "Freeing allocated memory for a single integer" << endl;
            //cout<<value<<endl;
            delete value;
            // free memory occupied by value
        }
        else if (storedType==INT_ARRAY){
            cout << "Freeing allocated memory for integer array" << endl;
            //cout<<valueArray<<endl;
            delete [] valueArray;
            //cout<<valueArray<<endl;
            // free memory occupied by valueArray
        }
        else if (storedType==INT_MATRIX){
            cout << "Freeing allocated memory for integer matrix" << endl;
            //cout<<valueMatrix<<endl;
            int i;
            for(i=0; i<firstDim; i++)
                delete [] *(valueMatrix+i);
            delete [] valueMatrix;
            // free memory occupied by valueMatrix
        }
        firstDim = 0;
        secondDim = 0;
        storedType = -1;
        cout << "_____________________" << endl;
        cout << "Destructing Container" << endl;
    }
};
