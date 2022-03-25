# Notes

## Increment in Java: post and pre methods

1) Post-Increment (i++): we use i++ in our statement if we want to use the current value, and then we want to increment the value of i by 1.

2) Pre-Increment (++i): We use ++i in our statement if we want to increment the value of i by 1 and then use it in our statement.

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
