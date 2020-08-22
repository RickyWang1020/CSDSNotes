#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main(){

    ifstream infile("../student.txt");
    string line;
    
    if (infile){
        while (getline(infile, line)){
            cout << line << endl;
        }
    }
    else{
        cout << "No file" << endl;
    }

    return 0;
}
