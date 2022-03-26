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
arr[idx++] = arr[idx+2]; // left part: arr[1], right part: arr[2+2], so the left part is before idx+1, and the right part is already after idx+1
for (int n:arr) {
    System.out.println(n); // 2,6,4,5,6
}
System.out.println(idx); // 2
```

## Static Variable

