// if-else structure
// computing the larger number within 2 numbers
#include <stdio.h>
int main()
{
    // allocate every variable before using
    int m, n, max;
    printf("Enter 2 numbers: ");
    scanf("%d%d", &n, &m);

    // large brackets after boolean condition
    if (m>n){
        max = m;
    }
    else {
        max = n;
    }
    printf("The larger number is %d\n", max);
    return 0;
}

// simplifying if-else structure
#include <stdio.h>
int main(){
    int m,n;

    printf("Enter 2 numbers: ");
    scanf("%d%d", &m, &n);

    // m > n? If so, return m; otherwise, return n
    printf("The larger number is %d\n", (m>n)? m:n);
    return 0;
}

// for loop
// computing the first 10 square numbers
#include <stdio.h>
int main(){
    int i,square;

    for (i=1; i<=10; i=i+1){
        // square is i*i, not i^2
        square = i*i;
        printf("The square of %d is %d\n", i, square);
    }
    return 0;
}
// computing the sum of the first n numbers
#include <stdio.h>
int main(){
    int i,n,sum = 0;

    // if enter negative number, the sum will be 0
    printf("Enter a positive number: ");
    scanf("%d", &n);

    for (i=1; i<=n; i++){
        sum = sum + i;
    }
    printf("The sum is: %d\n", sum);
    return 0;
}

// while loop
// computing the first power of 2 greater than 10000
#include <stdio.h>
int main(){
    int power = 1, n = 0;

    while (power < 10000){
        power = power * 2;
        n++;
    }
    printf("The first power of 2 greater than 10000 is: %d\n",power);
    return 0;
}

// do-while loop
// continually asking for a positive number until get one
#include <stdio.h>
int main(){
    int n;

    // the do part will be executed once before entering while
    do {
        printf("Enter a positive number: ");
        scanf("%d", &n);
        if (n < 0) {printf("Positive Number!\n");
        }
    } while (n < 0);
    return 0;
}

// switch statement
// calculating the slices of pizza and give corresponding feedback
#include <stdio.h>
int main(){
    int slices;
    printf("How many slices of pizza do you want?");
    scanf("%d", &slices);

    switch(slices){
        // one slice of pizza
        case 1:
            printf("Too few pizza!\n");
            // the break is important!
            break;
        // two slices of pizza
        case 2:
            printf("Still not many pizza!\n");
            break;
        // three slices of pizza
        case 3:
            printf("That's great!\n");
            break;
        // default: slice = other than 1,2,3
        default:
            printf("Alright.\n");
            break;
    }
    return 0;
}
// keeping track of the number of numbers, whitespaces and other characters in a file
#include <stdio.h>
int main(){
    int c, i, nwhite, nother, ndigit[10];

    // initializing the integer variables
    nwhite = nother = 0;
    // initializing the array numbers
    for (i=0; i<10; i++){
        ndigit[i] = 0;
    }
    while ((c = getchar()) != '\n' && c != EOF){
        switch(c){
            // counting the number of numbers
            // '' is char; "" is string!!!
            case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
                ndigit[c-'0'] = ndigit[c-'0'] + 1;
                break;
            // counting the number of whitespaces
            case ' ': case '\n': case '\t':
                nwhite ++;
                break;
            // counting the number of other characters
            default:
                nother ++;
                break;
        }
    }
    printf("Digits:");
    for (i=0; i<10; i++){
        printf(" %d: %d; ", i, ndigit[i]);
    }
    printf("whitespaces: %d; others: %d\n", nwhite, nother);
    return 0;
}

// exercise: factorial
#include <stdio.h>
int main(){
    // key point: Long (integer will outflow...)
    long i, factorial=1;
    for (i=1; i<=20; i++){
        factorial = factorial * i;
        printf("%ld! = %ld\n", i, factorial);
    }
    return 0;
}
