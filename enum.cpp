#include <iostream>

enum SEASON{
    // spring = 0, summer = 3, autumn = 4, winter = 5
    spring, summer = 3, autumn, winter
};

enum WEEK{
    MON = 1, TUE, WED, THU, FRI, SAT, SUN
} week;

int main(){
    enum SEASON season = spring;
    std::cout << season << " " << summer << " " << autumn << " " << winter << std::endl;
    std::cout << week << " " << week+1 << " " << week+2 << " " << week+3 << " " << week+4 << " " << week+5 << " " << week+6 << std::endl;
    return 0;
}

