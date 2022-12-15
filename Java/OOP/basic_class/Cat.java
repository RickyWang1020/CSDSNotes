package basic_class;

// Dog is the superclass, Cat is the subclass
public class Cat extends Dog {

    private int food;

    public Cat(String name, int age, int food) {
        // will inherit everything in the Dog constructor
        super(name, age);
        this.food = food;
    }
    // now we have three ways to set up the cat class: using 3 parameters or 2 parameters or 1 parameter
    public Cat(String name, int age) {
        super(name, age);
        this.food = 100;
    }
    public Cat(String name) {
        // if not specifying the age, then the age is 1
        super(name, 1);
        this.food = 100;
    }

    // override the method of the superclass
    public void speak() {
        System.out.println("I am " + this.name + ", my age is " + this.age + ", and I have " + this.food + " grams food");
    }

}
