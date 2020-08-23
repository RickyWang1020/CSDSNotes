// my very first program
#include <stdio.h>
int main()
{
    printf("helloworld\n");
    return 0; 
}

// datatype size
#include <stdio.h>
int main(void)
{
    printf("size of char = %zu\n",sizeof(char));
    printf("size of short = %zu\n",sizeof(short));
    printf("size of int = %zu\n",sizeof(int));
    printf("size of unsigned int = %zu\n",sizeof(unsigned int));
    printf("size of long = %zu\n",sizeof(long));
    printf("size of unsigned long = %zu\n",sizeof(unsigned long));
    printf("size of float = %zu\n",sizeof(float));
    printf("size of double = %zu\n",sizeof(double));
}

// variable initialization and scanf
#include <stdio.h>
int main()
{
    int n;
    int m;

    printf("Enter the first number: ");
    scanf("%d", &n);

    printf("Enter the second number: ");
    scanf("%d", &m);

    printf("Their sum is equal to: %d\n", m+n);
    return 0;
}

// datatype: char
#include <stdio.h>
int main()
{
    char c;
    printf("Enter the letter: ");
    scanf(" %c", &c);
    printf("The integer associated to %c is %d\n", c, c);
    return 0;
}
