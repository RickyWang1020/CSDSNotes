# Java Notes

## Don't Use Stack, Use Deque?!

https://mp.weixin.qq.com/s/Ba8jrULf8NJbENK6WGrVWg


## Increment in Java: post and pre methods

1) Post-Increment (i++): we first use the current value, and then increment the value of i by 1.

2) Pre-Increment (++i): we first increment the value of i by 1, and then use its value.

Example:

``` java
// initialize i
int i = 0;
System.out.println("Post-Increment");

// i values is incremented to 1 after returning current value, i.e., 0
System.out.println(i++); // this will return 0, but i will become 1 after that

// initialized to 0
int j = 0;
System.out.println("Pre-Increment");

// j is incremented to 1 and then it's value is returned
System.out.println(++j); // this will return 1, and j is 1 now
```

Example 2:
``` java
// ++a increments and then uses the variable.
// a++ uses and then increments the variable.
int i = 3;
int a = i++; // a = 3, i = 4
int b = ++a; // b = 4, a = 4

// in loops and/or conditions
int pre = 0;
while (++pre < 5) { // 1,2,3,4 passed the evaluation here
    System.out.println(pre); // 1,2,3,4
}

int post = 0;
while (post++ < 5) { // 0,1,2,3,4 passed the evaluation here
    System.out.println(post); // 1,2,3,4,5
}
```

Example 3: a special case
``` java
int idx = 1;
int[] arr = {2,3,4,5,6};
// left part: arr[1], right part: arr[2+2]
// so the left part is the idx before idx+1, and the right part is already the idx after idx+1
arr[idx++] = arr[idx+2];
for (int n:arr) {
    System.out.println(n); // 2,6,4,5,6
}
System.out.println(idx); // 2
```

## Static Keyword

### Static Variable

1. can be used to refer to a common (shared) property for all the objects
2. the static variable gets memory only once, when it is first loaded in class

``` java
class Student {
    int stu_no;
    String name;
    // here, the CS major will be given to every student in this class
    static String major = "CS";
    
    //constructor
    Student(int r, String n){
        stu_no = r;
        name = n;
    }
    //method to display the values
    void display() {
        System.out.println(stu_no + " " + name + " " + major);
    }   
}

public class Test {
    public static void main(String[] args) {
        Student stud = new Student(1, "rick");
        stud.display(); // 1 rick CS
    }
}
```
3. if a counter is static, then it will continue to be updated, instead of being initialized every time (like non-static variable) when the class object is created

A non-static counter:
``` java
class Counter{  
    int count = 0; //will get memory each time when the instance is created  
  
    Counter(){  
        count ++; //incrementing value  
        System.out.println(count);  
    }  
  
    public static void main(String args[]){  
        Counter c1 = new Counter();  // 1
        Counter c2 = new Counter();  // 1
        Counter c3 = new Counter();  // 1
    }  
}
```
A static counter:
``` java
class Counter2{  
    static int count = 0;//will get memory only once and retain its value  
  
    Counter2(){  
        count ++; //incrementing the value of static variable  
        System.out.println(count);  
    }  
  
    public static void main(String args[]){  
        Counter2 c1 = new Counter2();  // 1
        Counter2 c2 = new Counter2();  // 2
        Counter2 c3 = new Counter2();  // 3
    }  
}  
```

### Static Method
1. a static method belongs to the class, rather than class object
2. a static method can access (and modify) static variables in the class

``` java
class Student {
    int stu_no;
    String name;
    static String major = "CS";
    // a static method to change the value of static variable  
        static void change() {  
         major = "DS";  
    }  
    
    //constructor
    Student(int r, String n){
        stu_no = r;
        name = n;
    }
    //method to display the values
    void display() {
        System.out.println(stu_no + " " + name + " " + major);
    }   
}

public class Test{  
    public static void main(String args[]){  
        Student s1 = new Student(111, "Karan");  
        Student s2 = new Student(222, "Aryan");  
        Student s3 = new Student(333, "Sonoo");  
        //calling display method  
        s1.display();  // 111 Karan CS
        s2.display();  // 222 Aryan CS
        Student.change();  // here, the major has been changed!
        s3.display();  // 333 Sonoo DS
    }  
}  
```
3. a static method can be called without creating class object

``` java
class Calculate {
    static int cube (int x) {
        return x * x * x;
    }
}

public class Test{  
    public static void main(String args[]){  
        int res = Calculate.cube(5);
        System.out.println(res);  // 125
    }
}
```
4. static methods cannot call non-static methods or use non-static data members
5. this and super cannot be used in static
6. Note that **main function is also static**, this is because we do not need any object created when we call the main function. If main is non-static, then JVM needs to create an object before executing main function, which will lead to extra memory allocation.

### Static Block

1. it is used to initialize the static data member
2. it is executed before the main method at the time of loading a class

``` java
class A2 {  
    static {System.out.println("static block is invoked");}  
    public static void main(String args[]){  
        System.out.println("Hello main");  
    }  
}  
// output: 
// static block is invoked
// Hello main
```

Reference: https://www.javatpoint.com/static-keyword-in-java

## ArrayList Operation

``` java
import java.util.*;
// create
List<List<Integer>> res = new ArrayList<List<Integer>>();
// add element
res.add(Arrays.asList(1,2,3,4));
// get the size
int len = res.size();

// higher-dimensional arraylist
List<List<Integer>> arr = new ArrayList<>();
// add new sub-arraylist
arr.add(new ArrayList<>(Arrays.asList(1,3,5)));
arr.add(new ArrayList<>(Arrays.asList(2,4,6)));
System.out.println(arr); // the arraylist is [[1, 3, 5], [2, 4, 6]]
// change an element in the arraylist within arraylist, using a combination of get and set
arr.get(0).set(1,100);
System.out.println(arr); // the arraylist is [[1, 100, 5], [2, 4, 6]]
```

## HashMap Operation

``` java
// initialize a hashmap with pre-set key-value pairs
Map<Integer, Integer> m = new HashMap() {{put(0,0); put(1,1);}};
// print out the elements in hashmap
Map<String, Integer> memory = new HashMap();
System.out.println(Arrays.asList(memory));
// getOrDefault: a good approach to simplify the "counter dictionary" in hashmap
for (int i : arr) {
    map.put(i, map.getOrDefault(i, 0) + 1);
}
// iterate through key-value pairs
for (Map.Entry<key-type, value-type> entry: map.entrySet()) {
    // get value
    value-type val = entry.getValue();
    // get key
    key-type k = entry.getKey();
}
// iterate through keys
for (key-type key: map.keySet()) {
    ...
}
// iterate through values
for (value-type v: map.values()) {
    ...
}
```

## HashSet Operation
``` java
// convert a hashset to arraylist
Set<Integer> s = new HashSet<>();
for (int n: nums) s.add(n);
List<Integer> lst = new ArrayList<>(s);
```

## TreeMap Operation

- The search and insert in TreeMap only costs `O(logn)` time

``` java
Map<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
// ceiling key: get the the smallest key that is >= the given key
treemap.ceilingKey(5);
// floor key: get the the largest key that is <= the given key
treemap.floorKey(5);
// if the keys are not found, then it will be null (if null, then the type cannot be int, but Integer)
```
