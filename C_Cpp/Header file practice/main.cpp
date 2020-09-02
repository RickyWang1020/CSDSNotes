#include <iostream>
// option 1: use #include to include the header file containing the function
#include "log.h"

// option 2: paste the first line of the function to indicate the existence of the function
// void login(const char* message);

// use "gcc main.cpp log.cpp -o main" to link main.cpp and log.cpp
// then open the exec file of main to see the output

void login(const char* message){
    printf("%s\n", message);
}

int main(){
    initlog();
    login("Hello world!");
    return 0;
}