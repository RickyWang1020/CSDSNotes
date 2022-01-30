package inner_outer_class;

public class OuterClass {
    public class InnerClass {
        public void display() {
            System.out.println("in inner class");
        }
    }

    public void inner() {
        InnerClass innerclass = new InnerClass();
        innerclass.display();
    }
}
