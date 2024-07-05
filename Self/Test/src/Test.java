import org.w3c.dom.ls.LSOutput;

class lol{
    public int p;
    public char x;
    static public int y=0;
     {
        System.out.println(++y);
    }

    public lol(int p1, char x1) {
        p=p1;
        x= x1;
    }

    @Override
    public String toString(){
        return "int is " + p + " , char is" + "x" + "\n" ;
    }
}
public class Test {
    public static void main(String[] args) {
        int[] a = new int [10];
        for(int x:a)
        System.out.println(x);
        lol[] l = new lol[10];
        for(lol y:l)
            System.out.println(y);
        int f[] = {1,2,3,4,5};
        modArr(f);
        for(int g:f)
            System.out.println(g);
        int q=10;
        System.out.printf("This "+"is "+"q" + '\n');
        lol L = new lol(12,'b');
        //System.out.println(L.y);
        lol h = new lol(2,'x');
        String s = new String ("123456");
        String s5 = new String ("789");
        String s7=s;
        s=s.concat(s5);
        String s6 = "123456789";

        String s2[] = s.split(",,");
        System.out.println(s.substring(1,4));
        for(String s3:s2)
            System.out.println(s3);
        System.out.println(s.equals(s6));
        System.out.println(s==s6);
        System.out.println(s==s7);
        StringBuffer sb = new StringBuffer("12345");
        StringBuffer sb2 = sb;
        sb.append(sb) ;
        System.out.println(sb==sb2);
        System.out.println(sb);
        System.out.println(sb2);


        //String str = new String("12345");
        String str = "abcde";
        String str2 = str;
        //str= str + str ;
        str = str.concat(str);
        System.out.println(str==str2);
        System.out.println(str);
        System.out.println(str2);
        str2.replace('a','z');
        str2=str2.toUpperCase();
        System.out.println(str2);
        char carr[]={'l','o','l','a'};
        str2=String.valueOf(carr);
        System.out.println(str2);


        int b[][] = new int [2][];
        b[0] = new int [5];
        b[1] = new int [3];
        var tst = new int [2][0];
        tst[0] = new int[5];
        tst[1] =new int [4];

    }
    static void modArr( int a[])
    {
        int temp[] =a;
        temp[0]++;
    }
}
/*
class Complex {
    private double re, im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public String toString() {
        return String.format(re + " + i" + im);
    }
}

// Driver class to test the Complex class
public class Test {
    public static void main(String[] args) {
        Complex c1 = new Complex(10, 15);
        System.out.println(c1);
    }
}*/
/*



// Java program to demonstrate how to
// implement static and non-static
// classes in a Java program.
class OuterClass {
    private static String msg = "GeeksForGeeks";

    // Static nested class
    public static class NestedStaticClass {

        // Only static members of Outer class
        // is directly accessible in nested
        // static class
        public void printMessage()
        {

            // Try making 'message' a non-static
            // variable, there will be compiler error
            System.out.println(
                    "Message from nested static class: "
                            + msg);
        }
    }

    // Non-static nested class -
    // also called Inner class
    public class InnerClass {

        // Both static and non-static members
        // of Outer class are accessible in
        // this Inner class
        public void display()
        {
            System.out.println(
                    "Message from non-static nested class: "
                            + msg);
        }
    }
}
class Test {
    // How to create instance of static
    // and non static nested class?
    public static void main(String args[])
    {

        // Create instance of nested Static class
        OuterClass.NestedStaticClass printer
                = new OuterClass.NestedStaticClass();

        // Call non static method of nested
        // static class
        printer.printMessage();

        // In order to create instance of
        // Inner class we need an Outer class
        // instance. Let us create Outer class
        // instance for creating
        // non-static nested class
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner
                = outer.new InnerClass();

        // Calling non-static method of Inner class
        inner.display();

        // We can also combine above steps in one
        // step to create instance of Inner class
        OuterClass.InnerClass innerObject
                = new OuterClass().new InnerClass();

        // Similarly we can now call Inner class method
        innerObject.display();
    }
}*/
