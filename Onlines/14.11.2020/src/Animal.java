interface Venomous {
    boolean isLethalToAdultHumans();
}
class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName(){
        return name;
    }

    public void setAge( int a) {
        age = a;
    }
    public void setAge(String  s) {
        name= s;
    }
    public String toString(){
        return getName() + "is an Animal, aged " + getAge();
    }


}


class Mammal extends Animal{
    public Mammal(String name, int age) {
        super(name, age);
    }
    public void printBloodType(){
        System.out.print(", Warm-Blooded!");
    }
}
class Dog extends Mammal{
    public Dog(String name, int age) {
        super(name, age);
    }
    public String toString(){
        return getName() + "is a Dog, aged " + getAge();
    }
}
class FruitBat extends Mammal{
    public FruitBat(String name, int age) {
        super(name, age);
    }
    public String toString(){
        return getName() + "is a FruitBat, aged " + getAge();
    }
}
class Human extends Mammal{
    public Human(String name, int age) {
        super(name, age);
    }
    public String toString(){
        return getName() + "is a Human, aged " + getAge();
    }

}
class Platypus extends Mammal implements Venomous{
    public Platypus(String name, int age) {
        super(name, age);
    }
    public boolean isLethalToAdultHumans(){
        return false;
    }
    public String toString(){
        return getName() + "is a Platypus, aged " + getAge();
    }

}



class Bird extends Animal{
    public Bird(String name, int age) {
        super(name, age);
    }
}
class Albatross extends Bird{
    public Albatross(String name, int age) {
        super(name, age);
    }
    public String toString(){
        return getName() + "is an Albatross, aged " + getAge();
    }
}



class Reptile extends Animal{
    public Reptile(String name, int age) {
        super(name, age);
    }
}
class EasternBrownSnake extends Reptile implements Venomous{
    public EasternBrownSnake(String name, int age) {
        super(name, age);
    }
    public boolean isLethalToAdultHumans(){
        return true;
    }
    public String toString(){
        return getName() + "is an Eastern Brown Snake, aged " + getAge();
    }
}


class Fish extends Animal{
    public Fish(String name, int age) {
        super(name, age);
    }
}
class GreatWhiteShark extends Fish{
    public GreatWhiteShark(String name, int age) {
        super(name, age);
    }
    public String toString(){
        return getName() + "is a Great White Shark, aged " + getAge();
    }
}


class Arachnid extends Animal{
    public Arachnid(String name, int age) {
        super(name, age);
    }
}
class RedBackSpider extends Arachnid implements Venomous{
    public RedBackSpider(String name, int age) {
        super(name, age);
    }
    public boolean isLethalToAdultHumans(){
        return false;
    }
    public String toString(){
        return getName() + "is a RedBackSpider, aged " + getAge();
    }
}



