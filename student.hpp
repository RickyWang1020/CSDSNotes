//
//  student.hpp
//  Student_Grade_System
//
//  Created by Ricky Lahm Wang on 2020/6/23.
//  Copyright © 2020 Ricky Lahm Wang. All rights reserved.
//

#ifndef student_hpp
#define student_hpp

#include <string>
#include <sstream>

class Student{
    
    public:
        // the class receives a string
        Student(std::string student_info);
        // the getter functions
        std::string get_firstname();
        std::string get_lastname();
        std::string get_name();
        std::string get_email();
        double get_grade();
        
    private:
        // the class instances of student information
        std::string _first_name;
        std::string _last_name;
        std::string _student_email;
        double _grade;
};

#endif /* student_hpp */
