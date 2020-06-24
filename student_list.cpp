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

    student_file.close();
}
