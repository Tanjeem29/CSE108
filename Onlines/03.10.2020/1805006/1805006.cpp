#include<iostream>
#define UNDEFINED 0
#define LINE 1
#define RECTANGLE 2
#define CUBE 3

using namespace std;


class Shape
{
    int type;
public:
    Shape()
    {
        type = UNDEFINED;
        cout<<"In Shape with Type "<<type<<endl;
    }

    Shape(int type)
    {
        this->type = type;
        cout<<"In Shape with Type "<<type<<endl;
    }

    virtual int area()
    {
        cout<<"Overload this function in derived class"<<endl;
        return -1;
    }

    virtual int volume()
    {
        cout<<"Overload this function in derived class"<<endl;
        return -1;
    }

    int get_type(){ return type; }
    void set_type(int type){ this->type = type; }
};


class Line: public Shape
{
    int length;
public:

    Line()
    {
        length = 0;
        cout<<"In Line with length "<<length<<endl;
    }
    Line(int type, int length):Shape(type)
    {
        this->length = length;
        cout<<"In Line with length "<<length<<endl;
    }
    ~Line()
    {
        cout<<"Destroying line with length "<<length<<endl;
    }
    ///override area() and volume()
    int area()
    {
        cout<<"Line, so Area is 0"<<endl;
        return 0;
    }

    int volume()
    {
        cout<<"Line, so Volume is 0"<<endl;
        return 0;
    }

    ///setter getter if required
    int getLength()
    {
        return length;
    }
    void setLength( int l)
    {
        length=l;
    }
};

class Rectangle: private Line
{
    int width;
public:
    Rectangle()
    {
        width = 0;
        cout<<"In Rectangle with width "<<width<<endl;
    }

    Rectangle(int type, int length, int width):Line(type,length)
    {
        this->width = width;
        cout<<"In Rectangle with width "<<width<<endl;
    }
    ~Rectangle()
    {
        cout<<"Destroying Rectangle with width "<<width<<endl;
    }
    ///override area() and volume()
    int area()
    {
        cout<<"Area is: "<<width*getLength()<<endl;
        return getWidth()*getLength();
    }

    int volume()
    {
        cout<<"Rectangle, so Volume is 0"<<endl;
        return 0;
    }

    ///setter getter if required
    int getWidth()
    {
        return width;
    }
    void setWidth(int w)
    {
        width=w;
    }
    int getLength()
    {
        return Line::getLength();
    }
    void setLength(int l)
    {
        Line::setLength(l);

    }


};

class Cube: private Rectangle
{
    int height;
public:
    Cube()
    {

        height = 0;
        cout<<"in cube with height "<<height<<endl;
        /// set length and width
    }

    Cube(int type, int length, int width, int height): Rectangle(type, length, width)
    {
        this->height = height;
        cout<<"In cube with height "<<height<<endl;
    }
    ~Cube()
    {
        cout<<"Destroying cube with height "<<height<<endl;
    }

    ///override area() and volume()
    int area()
    {
        int l=getLength();
        int w=getWidth();
        int ans=2*(l*w+w*height+height*l);
        cout<<"Area is:"<<' '<<ans<<endl;
        return ans;
    }

    int volume()
    {
        int l=getLength(), w=getWidth();
        int ans = l*w*height;
        cout<<"Volume is:"<<' '<<ans<<endl;
        return ans;;
    }

    ///setter getter if required

    int getHeight()
    {
        return height;
    }
    void setHeight(int h)
    {
        height = h;
    }
};


int main()
{
    Shape s;
    s.area();
    ///Overload this function in derived class
    s.volume();
    ///Overload this function in derived class

    Line l(LINE, 5);
    ///Implement area and volume function
    l.area();
    ///Area is 0
    l.volume();
    ///Volume is 0

    Rectangle r(RECTANGLE, 5, 2);
    ///Notice that access modifier is private
    r.area();
    ///Area is 10
    r.volume();
    ///Volume is 0

    Cube c(CUBE, 5, 2, 4);
    ///You can not access length due to private modifier in rectangle
    ///write necessary methods in rectangle to access length
    c.area();
    ///Area is 76
    c.volume();
    ///Volume is 40

    ///Demonstration of Virtual Function in Shape
    Shape* s1;
    s1 = &l;
    s1->area();
    ///Area is 76
    s1->volume();
    ///Volume is 40
    ///write destructor function and observe (by printing something) the order of constructor and destructor call

    return 0;
}
