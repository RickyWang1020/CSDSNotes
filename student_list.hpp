//
//  student_list.hpp
//  Student_Grade_System
//
//  Created by Ricky Lahm Wang on 2020/6/24.
//  Copyright © 2020 Ricky Lahm Wang. All rights reserved.
//

#ifndef student_list_hpp
#define student_list_hpp

#include <stdio.h>
#include <string>
#include <vector>
#include <fstream>
#include "student.hpp"

class Student_list{
    public:
        // the class receives a string: file path
        Student_list(std::string file_path);
        // class methods
        Student get_top_student();
        std::vector <Student> get_excellent_student();
        std::vector <Student> get_fail_student();
    
    private:
        // the list of students
        std::vector <Student> _students;
};

#endif /* student_list_hpp */
