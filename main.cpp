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
    cout << "Grade: " << student.get_grade() << endl;
    cout << "Email: " << student.get_email() << endl;
    cout << endl;
}

void read_mode(Student_list stu_list){
    while (true){
        char choice;
        cout << "Reading Mode:\nType in:\n'1' - Check the top student;\n'2' - Check excellent student(s);\n'3' - Check failed student(s);\n'b' - Back to the main menu" << endl;
        cin >> choice;
        switch (choice){
            case '1':
                try {
                    cout << "The Top Student:" << endl;
                    printstudent(stu_list.get_top_student());
                } catch (NoTopStudentException &e) {
                    cout << "An Exception was Caught:\n" << e.what() << endl;
                }
                break;
            case '2':
                try {
                    cout << "The Excellent Student(s) List:" << endl;
                    for (Student s: stu_list.get_excellent_students())
                        printstudent(s);
                } catch (NoExcellentStudentsException &e) {
                    cout << "An Exception was Caught:\n" << e.what() << endl;
                }
                break;
            case '3':
                try {
                    cout << "The Failed Student(s) List:" << endl;
                    for (Student s: stu_list.get_fail_students())
                        printstudent(s);
                } catch (NoFailStudentsException &e) {
                    cout << "An Exception was Caught:\n" << e.what() << endl;
                }
                break;
            case 'b':
                return;
                break;
            default:
                cout << "Invalid input, try again" << endl;
                read_mode(stu_list);
                break;
        }
    }
}

void main_loop(){
    while (true){
        char output;
        cout << "Student Grade System\nType in:\n'r' - Read a student grade file;\n'w' - Write on a student grade file;\n'q' - Quit the system" << endl;
        cin >> output;
        switch (output){
            case 'r':
                // the path of the file must be the full directory of the file on computer
                // recommend copy & paste the full path
            {   cout << "Type in the full path of the student grade .txt file in your computer: " << endl;
                string r_path;
                // balance out the '\n' typed in the previous output
                getchar();
                getline(cin, r_path);
                cout << r_path << endl;
                Student_list stu_list(r_path);
                read_mode(stu_list);
                break;
            }
            case 'w':
                // the path of the file must be the full directory of the file on computer
            {   cout << "Type in the full path of the student grade .txt file in your computer: " << endl;
                string w_path;
                // balance out the '\n' typed in the previous output
                getchar();
                getline(cin, w_path);
                ofstream write_file;
                write_file.open(w_path, ios::out);
                char choice = 'y';
                while (choice != 'n'){
                    string First, Last, Email;
                    double Grade;
                    // get first name
                    cout << "Enter the student's first name: " << endl;
                    getline(cin, First);
                    // get last name
                    cout << "Enter the student's last name: " << endl;
                    getline(cin, Last);
                    // get email
                    cout << "Enter the student's email: " << endl;
                    getline(cin, Email);
                    // get grade
                    cout << "Enter the student's grade: " << endl;
                    cin >> Grade;
                    write_file << First << " " << Last << " " << Email << " " << Grade << endl;
                    cout << "Continue writing into the file? [y/n]" << endl;
                    cin >> choice;
                    getchar();
                }
                write_file.close();
                break;
            }
            case 'q':
            {    cout << "See you next time!" << endl;
                return;
                break;
            }
            default:
            {   cout << "Invalid input, try again" << endl;
                main_loop();
                break;
            }
        }
    }
}

int main() {
    main_loop();
    
    return 0;
}
