package inner_outer_class;

public class Main {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        // the outer class can refer to the method in inner class
        outer.inner();

        // another way to refer to the inner class method
        OuterClass.InnerClass in = outer.new InnerClass();
        in.display();
    }
}
