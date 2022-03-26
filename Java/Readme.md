# Notes

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


Reference: https://www.javatpoint.com/static-keyword-in-java

## ArrayList Operation

``` java
import java.util.*;
// create
List<List<Integer>> res = new ArrayList<List<Integer>>();
// add element
res.add(Arrays.asList(1,2,3,4));
```
