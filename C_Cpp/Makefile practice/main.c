#include "foo.h"
#include "bar.h"
#include <stdio.h>


int main(){
    int test[] = {1,4,6,3,1};
    int ma = maximum(test, 5);
    int mi = minimum(test, 5);
    printf("maximum: %d\n", ma);
    printf("minimum: %d\n", mi);
    return 0;
}
