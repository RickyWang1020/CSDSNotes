//
//  student_list.cpp
//  Student_Grade_System
//
//  Created by Ricky Lahm Wang on 2020/6/24.
//  Copyright © 2020 Ricky Lahm Wang. All rights reserved.
//

#include "student_list.hpp"

using namespace std;

Student_list::Student_list(string file_path){
    // the input file stream, to read the file
    ifstream student_file(file_path);
    // declare a string to store the line's content
    string line;
    if (student_file){
        // read the file one line at a time
        while (getline(student_file, line)){
            // store the line's content to the student class to creat one student profile
            Student stu(line);
            // store the student profile to the student list
            _students.push_back(stu);
        }
    }
    
    // sort the students by their score
    sort(_students.begin(), _students.end(), [](Student &s1, Student &s2)
         {
        return s1.get_grade() > s2.get_grade();
    });

    student_file.close();
}


Student Student_list::get_top_student(){
    if (_students.size() == 0 || _students.at(0).get_grade() < 60)
        throw NoTopStudentException();
    else
        return _students.at(0);
}

vector <Student> Student_list::get_excellent_students(){
    vector <Student> excellent_students;
    for (Student stu: _students){
        // since the students are sorted in descending grade, break after we find the first under 85 student
        if (stu.get_grade() < 85)
            break;
        else
            excellent_students.push_back(stu);
    }
    
    if (excellent_students.size() == 0)
        throw NoExcellentStudentsException();
    else
        return excellent_students;
}

vector <Student> Student_list::get_fail_students(){
    vector <Student> fail_students;
    // reversely loop through the students
    for (vector <Student>::reverse_iterator iter = _students.rbegin(); iter < _students.rend(); iter++){
        if (iter -> get_grade() >= 60)
            break;
        else
            fail_students.push_back(*iter);
    }
    
    if (fail_students.size() == 0)
        throw NoFailStudentsException();
    else
        return fail_students;
}
