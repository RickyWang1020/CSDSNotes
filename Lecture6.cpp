// address-of operator &
#include <stdio.h>
int main(){
    int n;
    char c;
    // print the size of integer variable n, the size of the address of n
    // and the address of n's first memory cell printed in hexadecimal
    printf("%zu %zu %p\n", sizeof(n), sizeof(&n), &n);
    // print the size of char variable c, the size of the address of c
    // and the address of c's first memory cell printed in hexadecimal
    printf("%zu %zu %p\n", sizeof(c), sizeof(&c), &c);
    return 0;
}

// dereference operator *
int n=10;
// mypointer stores the address of n
mypointer = &n;
// bar stores the value that mypointer points to, which is 10
bar = *mypointer;

// declaration of pointers
// integer (size 8B)
int * mypointer_int;
// char (size 8B)
char * mypointer_char;
// double (size 8B)
double * mypointer_double;

// when the pointer p points to i, then *p and i are "equivalent"
#include <stdio.h>
int main(){
    int i=100;
    int *p;

    p = &i;

    printf("The value of i is: %d\n", i); //100
    printf("The value of i via p is: %d\n", *p); //100

    *p = 17;

    printf("The value of i is: %d\n", i); //17
    printf("The value of i via p is: %d\n", *p); //17
    return 0;
}

// two pointers can point to the same variable
#include <stdio.h>
int main(){
    int i = 10;
    int *p, *q;

    p = &i; //p points to the address of i
    q = p; //q has a copy of the address of i

    *p = *p + 1;
    *q = *q + 1;

    printf("The value of i now: %d\n", i); //12 = 10 + 1 + 1
    return 0;
}

// pointer as parameter
#include <stdio.h>
void increment (int *p){
    // access to the content of the variable whose address is stored in the pointer p
    // add 1 and store it in the same variable
    *p = *p + 1;
}
int main()
{
    int i = 17;
    // &i instead of i (because we want to change i via its address)
    // pass in i's address so that we can get the exact value corresponding to this address in increment function
    increment(&i);
    printf("i : %d\n", i);
    return 0;
}

// alternate way of increment using reference
#include <stdio.h>
// create an "alias" of val that we can have access to the value in the address
void increment(int &val){
    val++;
}
int main(){
    int a = 5;
    increment(a);
    printf("%d\n", a);
    return 0;
}

// the object of reference cannot be changed!!!
#include <stdio.h>
int main(){
    int a = 5;
    int b = 8;
    int &ref = a;
    // we want to change the reference from a to b
    // but this can only make a = b = 8
    ref = b;
    printf("%d %d\n", a, b);
    return 0;
}

// the object of pointer can be changed!!!
#include <stdio.h>
int main(){
    int a = 5;
    int b = 8;
    // set pointer pointing to the address of a
    int *p = &a;
    // change a into 10
    *p = 10;
    // set the pointer pointing to the address of b
    p = &b;
    // change b into 15
    *p = 15;
    printf("%d %d\n", a, b);
    return 0;
}

// swapping two variables' values
#include <stdio.h>
void swap(int *ptra, int *ptrb){
    int temp;

    temp = *ptra;
    *ptra = *ptrb;
    *ptrb = temp;
}
int main(){
    int a, b;
    a = 2; b = 4;
    printf("a is: %d, b is: %d\n", a, b);
    swap(&a, &b);
    printf("a is: %d, b is: %d\n", a, b);
    return 0;
}

// pointers of pointers of pointers ...
int i, // an integer i
*p, // a pointer p of integer
**q, // a pointer of pointer q of integer
***r; // a pointer of pointer of pointer r of integer

p = &i;
q = &p;
r = &q;
// *r = q = &p
// **r = *q = p = &i
// ***r = **q = *p = i

// pointer and array
#include <stdio.h>
int main(){
    int array[4], *p, i;
    // (1) automatic conversion of the name of the array in its allocated address, of type pointer of int
    // (2) store this address in p
    // important!!!
    p = array;

    // access to the elements of the array with the usual notations via the pointer p
    p[0] = 38;
    p[1] = 12;
    p[2] = 43;
    p[3] = 65;

    for (i=0; i<4; i++)
        printf("%d ", array[i]);
    // 38 12 43 65
    printf("\n");
    return 0;
}

// initialization: pointer of array
void erase(int a[], int size){}
// is equivalent to
void erase(int *a, int size){}

// pointer arithmetic
// *(p + i) = p[i]!!
// *(array + i) = array[i]!!
int array[3], *p;
// p = the address of array (also the address of array[0])
p = array;
// store 38 into array[0]
*p = 38;
// adds to p the size of one int (4 Byte)
p = p+1;
// store 17 into array[1]
*p = 17;
p = p+1;
// store 35 into array[2]
*p = 35;
// now the array contains 38 17 35

// structure data type
// type of structure to represent coordinates of the plane labelled by chars
struct coord {
  char name;
  int abs;
  int ord;
}; // the ; at the end is necessary!!!

int main(){
    struct coord a; // new variable of type struct coord
    // storing values in the fields of a
    a.name = ‘a’;
    a.abs = 10;
    a.ord = 10;
    // read and print the values of the fields of a 
    printf("%c %d %d", a.name, a.abs, a.ord); 
    return 0;
}

// initialization of structure type
// the fields of a are allocated but not initialized
struct coord a;
// the fields of a are allocated and initialized (name = 'a', abs = 15, ord = 20)
struct coord a = {'a', 15, 20};
// the first field of a is initialized, and the rest two are 0
struct coord a = {'a'};

// example of copying structure tyoe
#include <stdio.h>
struct coord{
    char name;
    int abs;
    int ord;
};
int main(){
    struct coord a = {'a', 38, 17}, b;
    b = a; // copy the values of the fields of a into the fields of b

    b.name = 'b';
    b.abs = b.abs + 10;
    b.ord = b.ord + 10;

    printf("a: %c %d %d\n", a.name, a.abs, a.ord);
    printf("b: %c %d %d\n", b.name, b.abs, b.ord);
    return 0;
}
// struct as function parameters
#include <stdio.h>
struct coord{
    char name;
    int abs;
    int ord;
};
struct coord translate(struct coord c, int var1, int var2){
    c.abs = c.abs + var1;
    c.ord = c.ord + var2;
    return c;
}
int main(){
    struct coord a = {'a', 38, 17}, b;
    printf("a: %c %d %d\n", a.name, a.abs, a.ord);
    b = translate(a, 10, 10); // has the same effect as the previous copying method
    b.name = 'b';
    printf("b: %c %d %d\n", b.name, b.abs, b.ord);
    return 0;
}

// pointer as parameter
void shifter(struct coord *ptr, int var1, int var2){
    (*ptr).abs += var1;
    (*ptr).ord += var2;
}
// in-place modifies structure a
shifter(&a, 10, 10);

// abbreviated notation
// (*ptr).name
ptr -> name;
// (*ptr).abs
ptr -> abs;
// (*ptr).ord
ptr -> ord;
// alternative code of "shifter"
void shifter(struct coord *ptr, int var1, int var2){
    (ptr -> abs) += var1;
    (ptr -> ord) += var2;
}

// printing a matrix: method 1
#include <stdio.h>
void print_matrix(int *content, int height, int width){
    int i, j;
    for (i=0; i<height; i++){
        for (j=0; j<width; j++){
            printf("%3d", content[width*i + j]);
        }
        printf("\n");
    }
}
int main(){
    int array[] = {0,1,2,3,4,5,6,7,8,9,10,11};
    print_matrix(array, 3, 4);
    return 0;
}
// printing a matrix: method 2
#include <stdio.h>
struct matrix{
    int height;
    int width;
    int *content;
};
// very brief code to return a specific value in the matrix
int element(struct matrix *pm, int i, int j){
    return pm -> content[pm -> width * i + j];
}
void print_matrix(struct matrix *mat){
    int i, j;
    for (i=0; i<(mat -> height); i++){
        for (j=0; j<(mat -> width); j++){
            // element(mat, i, j) - "mat" (not *mat) is the pointer!!!
            printf("%3d", element(mat, i, j));
        }
        printf("\n");
    }
}
int main(){
    int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    // initializing a struct...
    struct matrix m = {.height = 3, .width = 4, .content = array};
    // &m is the address of m
    print_matrix(&m);
    return 0;
}

// Warning of coping struct!!!
int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
struct m = {.height = 3, .width = 4, .content = array};
// after coping, m.content and n.content share the same address of array
// if array is changed, then m.content and n.content will both be changed
struct n = m;
