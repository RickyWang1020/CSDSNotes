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
    string one_line_content;
    while (!student_file.eof()){
        // read the file one line at a time
        getline(student_file, one_line_content);
        // store the line's content to the student class to creat one student profile
        Student stu(one_line_content);
        // store the student profile to the student list
        _students.push_back(stu);
    }
    student_file.close();
}
