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

## Array Operation

- For primitive types like `int`, we cannot turn an array of `int` into arrayList of `int`; but we can make it arrayList of `Integer`

``` java 
// turn an array of int into an arraylist
Integer[] lst = new Integer[] {1, 2, 3};
List<Integer> arrlst = Arrays.asList(lst);
// or just create a new arrayList and put everything in
List<Integer> arrlst2 = new ArrayList<Integer>();
for (int i: lst) {
    arrlst2.add(i);
}
```

- For non-primitive types like `String`, we can freely convert between array and arrayList

``` java
// convert array to arrayList
String[] strArr = {"1", "2", "3", "4"};
List<String> strList = Arrays.asList(strArr);
// convert arrayList to array
String[] newStrArr = new String[strList.size()];
strList.toArray(newStrArr);
// or a one-line way
String[] result = strList.toArray(new String[strList.size()]);

// converting list of int[] to int[][] array
// important: it is int[result.size()][], not int[][result.size()]!
int[][] ans = result.toArray(new int[result.size()][])
```

- Print the array

``` java
System.out.println(Arrays.toString(array));
```

- Make a copy of an array

``` java
// approach 1
int[] secondArray = Arrays.copyOf (firstArray, firstArray.length);
// approach 2
int[] secondArray = new int[firstArray.length];
System.arraycopy(firstArray, 0, secondArray, 0, firstArray.length);
```

## String Operation

- Get the length of a string

``` java
String s1 = "ilovejava";
int len1 = s1.length();
```

- Char Array and String Conversion

``` java
String s = "hello";
char[] arr = s.toCharArray();
String s1 = String.valueOf(arr);
```

- Remove the spaces in the beginning and end of the string

``` java
String st = s.trim();
```

- Join an ArrayList of Strings into a whole String

``` java
List<String> lst = Arrays.asList(new String[] {"hello", "helo", "world"});
String join_str = String.join(" ", lst);
```

- Split a string using giving delimiter (can also use regex as delimiter!)

``` java
String str = new String("Welcome-to-Runoob");
System.out.println("- 分隔符返回值 :" );
for (String retval: str.split("-")){
    System.out.println(retval);
}

System.out.println("");
System.out.println("- 分隔符设置分割份数返回值 :" );
for (String retval: str.split("-", 2)){
    System.out.println(retval);
}

System.out.println("");
String str2 = new String("www.runoob.com");
System.out.println("转义字符返回值 :" );
for (String retval: str2.split("\\.", 3)){
    System.out.println(retval);
}

System.out.println("");
String str3 = new String("acount=? and uu =? or n=?");
System.out.println("多个分隔符返回值 :" );
for (String retval: str3.split("and|or")){
    System.out.println(retval);
}
```

Reference: https://www.runoob.com/java/java-string-split.html

- StringBuilder: a good way to build and edit a string
    - StringBuilder不线程安全，但是速度更快；如果需要线程安全则需要使用StringBuffer
    
``` java
// initiate
StringBuilder sb = new StringBuilder();
// append, can be char or string
sb.append("abcde");
sb.append('f');
// remove element
result.deleteCharAt(result.length() - 1);
// take a selected slice of the Stringbuilder
Stringbuilder new_sb = result.substring(1, result.length() - 1);
// reverse the stringbuilder object
StringBuilder reverseStr = sb.reverse();
// convert Stringbuilder back to String
String s = sb.toString();
```

- Check whether a String is Numeric

``` java
// method 1: brute force conversion and check
public static boolean isNumeric(String str) { 
  try {  
    Double.parseDouble(str);  
    return true;
  } 
  catch (NumberFormatException e) {  
    return false;  
  }  
}

// method 2: regular expression to match a number with optional '-' and decimal
public static boolean isNumeric(String str) {
  return str.matches("-?\\d+(\\.\\d+)?");
}
```

- Conversion between Int and String

``` java
// convert string to int (also works for negative int)
String s = "100";
int x = Integer.parseInt(s);
// convert int to string, method 1
String s1 = String.valueOf(x);
// method 2
String s2 = Integer.toString(x);
```

## ArrayList Operation

- We cannot have List of primitive types!

- Bulk add multiple elements to an arrayList

``` java
// approach 1
Integer[] otherList = new Integer[] {1, 2, 3, 4, 5};
arList.addAll(Arrays.asList(otherList));
// approach 2
arList.addAll(Arrays.asList(1, 2, 3, 4, 5));
```

- Higher-dimensional arrayList:

``` java
// create
List<List<Integer>> arr = new ArrayList<List<Integer>>();
// add new sub-arraylist
arr.add(new ArrayList<>(Arrays.asList(1,3,5)));
arr.add(new ArrayList<>(Arrays.asList(2,4,6)));
System.out.println(arr); // the arraylist is [[1, 3, 5], [2, 4, 6]]
// get the size
int len = arr.size();
// change an element in the arraylist within arraylist, using a combination of get and set
arr.get(0).set(1,100);
System.out.println(arr); // the arraylist is [[1, 100, 5], [2, 4, 6]]
```

## HashMap Operation

- Initialize a hashmap with pre-set key-value pairs

``` java
Map<Integer, Integer> m = new HashMap() {{put(0,0); put(1,1);}};
```

- Print out the elements in hashmap

``` java
Map<String, Integer> memory = new HashMap();
System.out.println(Arrays.asList(memory));
```

- getOrDefault: a good approach to simplify the "counter dictionary" in hashmap

``` java
for (int i : arr) {
    map.put(i, map.getOrDefault(i, 0) + 1);
}
```

- computeIfAbsent: 如果 key 对应的 value 不存在，则使用获取 remappingFunction 重新计算后的值，并保存为该 key 的 value，否则返回 value

``` java
for (int i = 0; i < N; ++i) {
    map.computeIfAbsent(i, x-> new ArrayList<Integer>());
}
```

- Iterate through hashmaps

``` java
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

- Convert a hashset to arraylist

``` java
Set<Integer> s = new HashSet<>();
for (int n: nums) s.add(n);
List<Integer> lst = new ArrayList<>(s);
```

- Initiate a hashset with initialized values

``` java
Set<String> h = new HashSet<>(Arrays.asList("a", "b"));
```

## TreeMap Operation

- The search and insert in TreeMap only costs `O(logn)` time
- Floor and Ceiling Keys

``` java
Map<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
// ceiling key: get the the smallest key that is >= the given key
treemap.ceilingKey(5);
// floor key: get the the largest key that is <= the given key
treemap.floorKey(5);
// if the keys are not found, then it will be null (if null, then the type cannot be int, but Integer)
```

## ArrayDeque Operation

- 双端队列接口，包含“头端”和“尾端”，可以用来模拟stack和queue的数据结构
- 从尾部的操作：一般是queue的add端
    - add()：尾部插入
    - addLast()：尾部插入
    - addAll()：尾部插入一个iterator内的所有元素
    - offer()：尾部插入
    - offerLast()：尾部插入
    - getLast()：获取尾部元素
    - peekLast()：获取尾部元素
    - removeLast()：获取并删除尾部元素
    - pollLast()：获取并删除尾部元素

- 从头部的操作：头部是stack的push、pop、peek端，一般也是queue的pop端
    - addFirst()：头部插入
    - offerFirst()：头部插入
    - push()：头部插入
    - element()：获取头部元素
    - getFirst()：获取头部元素
    - peek()：获取头部元素
    - peekFirst()：获取头部元素
    - poll()：获取并删除头部元素
    - pollFirst()：获取并删除头部元素
    - pop()：获取并删除头部元素
    - remove()：获取并删除头部元素
    - removeFirst()：获取并删除头部元素
