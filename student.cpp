//
//  student.cpp
//  Student_Grade_System
//
//  Created by Ricky Lahm Wang on 2020/6/23.
//  Copyright © 2020 Ricky Lahm Wang. All rights reserved.
//

#include "student.hpp"

using namespace std;

// convert the received string into the class instances
Student::Student(string student_info){
    stringstream student_stream(student_info);
    student_stream >> _first_name;
    student_stream >> _last_name;
    student_stream >> _student_email;
    student_stream >> _grade;
}

// define the getter functions
string Student::get_firstname(){
    return _first_name;
}

string Student::get_lastname(){
    return _last_name;
}

string Student::get_name(){
    return _first_name + " " + _last_name;
}

string Student::get_email(){
    return _student_email;
}

double Student::get_grade(){
    return _grade;
}
