package basic_class;

public class Dog implements Comparable<Dog> {

    // static variable: a class variable (different from instance variables below) that can be used for the Dog class, not for each of the Dog instances
    protected static int counter = 0;

    // private: the variables are accessible only in this class
    // public: can be used for all other Java classes
    // protected: can be used within the same package
    protected String name;
    protected int age;

    // the constructor method, initiating an instance
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        // use class name to reference the static variable
        Dog.counter += 1;
        // call static/ non-static methods
        Dog.display();
        this.display2();
    }

    public void speak() {
        System.out.println("I am " + this.name + ", and my age is " + this.age);
    }

    // get the private parameter of the class
    public int getAge() {
        return this.age;
    }

    public void setAge(int new_age) {
        this.age = new_age;
    }

    // private method: can only be used within this class (for example, in the constructor)
    // cannot be used in other classes, even it is after creating an instance in another class
    private int add2() {
        return this.age + 2;
    }

    // static method, for the class (e.g., Dog) to call, have no access to the instance related stuff
    public static void display() {
        System.out.println("I am a doggie!");
    }

    // non-static method, need an instance (e.g., this) to call
    public void display2() {
        System.out.println("I am a dog2!");
    }

    // comparing two Dog instances by comparing whether their names and ages are the same
    // use "other" class instance
    public boolean equals(Dog other) {
        return (this.name.equals(other.name) && (this.age == other.age));
    }

    // comparing two Dog instances' names by calculating the numeric distances of the letters
    // actually overloads the compareTo method
    public int compareTo(Dog other) {
        return this.name.compareTo(other.name);
    }

    // overrides the original toString method, and when printing out the instance, it will automatically print out the name
    public String toString() {
        return this.name;
    }
}
