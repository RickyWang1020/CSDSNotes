// creating an array
// the four integer values are declared but not initialized
int t[4];
// the four integer values are declared and initialized
int t[] = {12, 2, 4, 7};
// t[0] = 12, t[1] = 4, t[2] = 0, t[3] = 0
int t[4] = {12, 4};
// all 10 elements of the array are initialized to 0
int t[10] = {}

// creating a higher-dimensional array
// declaration
int m[3][4];
// declaring and initializing the value (CURLY PARANTHESES!!!)
int m[3][4] = {{0,1,0,0}, {1,0,0,0},{0,0,1,0}};
// m[0][2] and m[0][3] are 0, m[1][1], m[1][2] and m[1][3] are 0, m[2] has four 0
int m[3][4] = {{0,1},{1}}
// test the array initialization
#include <stdio.h>
int main(){
    int m[3][4] = {{0,1}, {1}};
    int i,j;
    for (i=0;i<3;i++){
        for (j=0;j<4;j++){
            printf("%d ",m[i][j]);
        }
    }
    return 0;
}

// character arrays and strings
// printing "Hello world" using character array
#include <stdio.h>
int main(){
    char u[100];

    // storing the ascii code of the character
    // '' is char; "" is string!!!
    u[0] = 'H';
    u[1] = 'e';
    u[2] = u[3] = u[9] = 'l';
    u[4] = u[7] = 'o';
    u[5] = ' ';
    u[6] = 'W';
    u[8] = 'r';
    u[10] = 'd';
    // the ascii code of "!"
    u[11] = 33;
    u[12] = '\n';
    // null character, ascii code is 0, indicating the end of string
    u[13] = '\0';

    // prints all the characters between u[0] and '\0' as a string
    printf("%s", u);
    return 0;
}

// initializing a character array
// u[0] = 'a', u[1] = 'b', u[2] = 'c', u[3] = u[4] =...=u[100] = '\0'
char u[100] = "abc";
// 4 elements in u, u[3] = '\0'
char u[] = "abc";

// exercise 1: length of a string
#include <stdio.h>
int main(){
    char c[100];
    int i;

    printf("Enter a string: ");
    scanf("%s", c);

    for (i=0; c[i] != '\0'; i++);
    printf("The length of string is: %d\n", i);
    return 0;
}

// exercise 2: count the appearence of a character in a string
#include <stdio.h>
int main(){
    char str[100], c;
    int i, appearance = 0;

    printf("Enter a string: ");
    // no & because str is the address of the array
    scanf("%s", str);
    printf("Enter a character: ");
    // has &
    scanf(" %c", &c);

    // can be simplified: for (i=0; u[i] != '∖0'; i++){counter += (u[i]==c);}
    for (i=0;str[i] != '\0';i++){
        if (str[i] == c){
            appearance ++;
        }
    }
    printf("%c appears in %s %d times\n", c, str, appearance);
    return 0;
}

// exercise 3: reversely print a string
#include <stdio.h>
int main(){
    int len, i;
    char u[100];

    printf("Enter a string: ");
    scanf("%s", u);

    for (len=0; u[len] != '\0'; len++);

    for (i=len; i >= 0; i=i-1){
        // just to print reversely, not to reverse the string...
        printf("%c", u[i]);
    }
    printf("\n");
    return 0;
}

// exercise 4: reverse a string
#include <stdio.h>
int main(){
    int left=0, right;
    char front, back, str[100];

    printf("Enter a string: ");
    scanf("%s", str);

    for (right=0; str[right] != '\0'; right++);
    right = right - 1;

    while (left < right) {
        front = str[left];
        back = str[right];
        str[left] = back;
        str[right] = front;
        left = left + 1; right = right - 1;
    }
    printf("%s\n", str);
    return 0;
}
// exercise 4: simpler
#include <stdio.h>
int main(){
    int len, i;
    char str[100], temp;

    printf("Enter a string: ");
    scanf("%s", str);

    for (len=0; str[len] != '\0'; len++);

    for (i=0; i < len/2; i++){
        temp = str[i];
        str[i] = str[len-i-1];
        str[len-i-1] = temp;
    }
    printf("%s\n", str);
    return 0;
}

// exercise 5: left rotation - putting the first character to the end of string
#include <stdio.h>
int main(){
    int i;
    char str[100], first;

    printf("Enter a string: ");
    scanf("%s", str);

    first = str[0];

    for (i=1; str[i] != '\0'; i++){
        str[i-1] = str[i];
    }
    str[i-1] = first;
    
    printf("%s\n", str);
    return 0;
}

// exercise 6: compute the number of words in a string
#include <stdio.h>
int main(){
    char str[100];
    int i, num = 0;

    printf("Enter a string: ");
    // use [^\n] to read input with spaces
    scanf("%[^\n]s", str);

    for (i=0; str[i] != '\0'; i++){
        // u[i] does not contain a space character (hence it is on a word)
        // u[i+1] contains either a space character ' ' or the null character '∖0'
        if (str[i] != ' ' && (str[i+1] == ' ' || str[i+1] == '\0')){
            num ++;
        }
    }
    printf("%d\n", num);
    return 0;
}

// exercise 7: right rotation - putting the last character to the start of string
#include <stdio.h>
int main(){
    int i;
    char str[100], temp, temp2;

    printf("Enter a string: ");
    scanf("%s", str);

    temp = str[0];

    for (i=1; str[i] != '\0'; i++){
        temp2 = str[i];
        str[i] = temp;
        temp = temp2;
    }
    str[0] = temp;
    
    printf("%s\n", str);
    return 0;
}

// exercise 8: randomly select a character in a string that doesn't have repetition
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
int main(){
    int len, select;
    char str[100];

    srand((int) time(NULL));

    printf("Enter a string: ");
    scanf("%s", str);

    for (len=0; str[len] != '\0'; len++);

    select = rand() % len;

    printf("The selected character of %s is %c\n", str, str[select]);
    return 0;
}

// functions
// max function version 1
int max(int m, int n){
    int res;
    if m>n {
        res = m;
    }
    else {
        res = n;
    }
    return res;
}
// max function versino 2
int max(int m, int n){
    if m>n {
        return m;
    }
    else {
        return n;
    }
}
// max function version 3
int max(int m, int n){
    if m>n return m;
    else return n;
}
// max function version 4
int max(int m, int n){
    return (m>n)? m:n;
}

// functions with array as parameters 1
#include <stdio.h>
void print_content(int a[], int size){
    int i;
    for (i=0; i<size; i++){
        printf("%d ", a[i]);
    }
}
int main(){
    int arr[] = {15,20,33,45};
    print_content(arr, 4);
    printf("\n");
    return 0;
}
// functions with array as parameters 2
#include <stdio.h>
int length(char s[]){
    int i=0;
    while (s[i] != '\0')
        i ++;
    return i;
}
int main(){
    char s[] = "abcdefg";
    printf("The length of %s is %d\n", s, length(s));
    return 0;
}

// exercise 9: write a function that:
// returns 1 when the string myword contains exactly the letters appearing in the string myletters;
// and returns 0 otherwise
int isitcorrect(char myword[], char myletters[]){
    // initialize the counter of words in myword and myletters (in ascii code)
    int myword_count[128]={}, myletters_count[128]={}, i;

    // only one sentence of code can ignore the {} of loop
    for (i=0; myword[i] != '\0'; i++)
        myword_count[myword[i]] ++;
    for (i=0; myletters[i] != '\0'; i++)
        myletters_count[myword[i]] ++;

    for (i=0; i<128; i++){
        if myword_count[i] != myletters_count[i]{
            return 0;
        }
    }
    return 1;
}