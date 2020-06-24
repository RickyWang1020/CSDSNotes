//
//  main.cpp
//  Student_Grade_System
//
//  Created by Ricky Lahm Wang on 2020/6/23.
//  Copyright © 2020 Ricky Lahm Wang. All rights reserved.
//

#include <iostream>
#include "student.hpp"
#include "student_list.hpp"

using namespace std;

void printstudent(Student student){
    cout << "Name: " << student.get_name() << endl;
    cout << "First: " << student.get_firstname() << endl;
    cout << "Last: " << student.get_lastname() << endl;
    cout << "Grade: " << student.get_grade() << endl;
    cout << "Email: " << student.get_email() << endl;
    cout << endl;
}

int main() {
    // the path of the file must be the full directory of the file on computer
    Student_list list("/Users/lahmwang/Desktop/C Practice/Student_Grade_System/Student_Grade_System/student.txt");
    for (Student s: list._students)
        printstudent(s);
    
    return 0;
}
