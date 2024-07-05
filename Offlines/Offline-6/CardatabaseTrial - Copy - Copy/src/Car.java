import java.io.PrintWriter;

class Car {
    private String CarReg;
    private int YearMade;
    private String Colour1;
    private String Colour2;
    private String Colour3;
    private String CarMake;
    private String CarModel;
    private int Price;
    public Car (String reg, int yrMade, String c1, String c2, String c3, String make, String model, int p){
        CarReg= reg;
        YearMade = yrMade;
        Colour1 = c1;
        Colour2 = c2;
        Colour3 = c3;
        CarMake = make;
        CarModel = model;
        Price = p;
    }
    String getReg(){
        return CarReg;
    }
    int getYearMade(){
        return YearMade;
    }
    String getC1(){
        return Colour1;
    }
    String getC2(){
        return Colour2;
    }
    String getC3(){
        return Colour3;
    }
    String getMake(){
        return CarMake;
    }
    String getModel(){
        return CarModel;
    }
    int getPrice(){
        return Price;
    }
    void setPrice(int p){Price = p;}
    public String toString()
    {
        return CarReg + ',' + YearMade + ',' + Colour1 + ',' + Colour2 + ',' + Colour3 + ',' + CarMake + ',' + CarModel + ',' + Price;
    }
    public void display(PrintWriter out)
    {
        String noColour = "";
        out.println("Registration Number: "+ CarReg);
        out.println("Made in the Year: "+ YearMade);
        out.println("Comes in the color(s):\n"+ Colour1);
        if(!Colour2.equals(noColour)) {
            out.println(Colour2);
        }
        if(!Colour3.equals(noColour)) {
            out.println(Colour3);
        }
        out.println("Make: "+ CarMake);
        out.println("Model: "+ CarModel);
        out.println("Price: "+ Price);
        out.println();

    }


}
