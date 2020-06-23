//
//  main.cpp
//  Student_Grade_System
//
//  Created by Ricky Lahm Wang on 2020/6/23.
//  Copyright © 2020 Ricky Lahm Wang. All rights reserved.
//

#include <iostream>
#include "student.hpp"

using namespace std;

int main(int argc, const char * argv[]) {
    Student student("Charlie Brown cb1234 55.2");
    cout << student.get_name() << student.get_firstname() << student.get_lastname() << student.get_grade() << student.get_id() << endl;
    return 0;
}
