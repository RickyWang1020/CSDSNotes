// explicit allocation of memory
#include <stdio.h>
#include <stdlib.h>

int main(){
    int *p;

    // allocate a memory block of 10 * size_of_int
    // and store the address of the memory block in pointer p
    p = malloc(10 * sizeof(int));

    p[0] = 38;
    p[1] = 42;
    p[2] = p[1]+3;

    // free the allocation of memory when the contents are not useful any more
    free(p);
    return 0;
}

// an error of memory leak
p = malloc(10 * sizeof(int));
// no free(p) between two mallocs
p = malloc(10 * sizeof(int));
// in this case, the memory block of the first malloc will be lost and cannot be freed by the end of execution
// too much memory allocated and not freed will lead to insufficent memory!

// failure of memory allocation: when there is not enough memory
// it will return NULL pointer
// treat the failure case
p = malloc(10 * sizeof(int));
if (p == NULL){
    printf("Error of allocation\n");
    exit(EXIT_FAILURE);
}

// calloc: initialize all the allocated memories' values to null values
// first argument: number of elements; second argument: size of each element
p = calloc(10, sizeof(int));
// realloc: resize the allocated memory block
// if the new size is bigger, keep the original data and expand the size
// if the new size is smaller, cut off the excess data
// example: expand the size of p from 40 bytes to 80 bytes
p = malloc(10 * sizeof(int));
p = realloc(p, 20 * sizeof(int));
