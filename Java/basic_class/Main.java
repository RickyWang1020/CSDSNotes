package basic_class;

public class Main {

    public static void main(String[] args) {
        // create the class object
        Dog jack = new Dog("jack", 15);
        // use the speak method
        jack.speak();
        System.out.println(jack.getAge());
        jack.setAge(222);
        jack.speak();
        // test the static counter
        Dog bill = new Dog("bill", 12);
        System.out.println(Dog.counter);

        // subclass test
        Cat tom = new Cat("tom", 11, 4);
        tom.speak();
        Cat tim = new Cat("tim", 18);
        tim.speak();
        Cat tam = new Cat("tam");
        tam.speak();

        // class instance comparison test
        Dog bob = new Dog("bob", 11);
        Dog bob1 = new Dog("bob", 11);
        Dog bob2 = new Dog("bob", 15);
        System.out.println(bob.equals(bob1));
        System.out.println(bob.equals(bob2));
        System.out.println(bob.compareTo(tim));
        System.out.println(bill);
    }
}
