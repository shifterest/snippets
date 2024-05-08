#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
using namespace std;

struct course {
    string code;
    string description;
    float units;
    string teacher;
    string schedule;
    float grade;
    
    float weightedGrade () {
        return units * grade;
    }
};

const string STUDENT_NAME = "Kenji A. Delmoro BSCS 1";

int main () {
    // Count number of courses
    ifstream grade ("grade.txt");
    if (!grade.is_open()) {
        cerr << "Grade file failed to open";
        return 1;
    }
    int totalSubjects = 0;
    string courseStr;
    while (getline (grade, courseStr)) totalSubjects++;
    // Create array to store grade data
    course courseArr[totalSubjects];
    grade.close();
    
    // Get data from grade file and calculate
    grade.open ("grade.txt");
    if (!grade.is_open()) {
        cerr << "Grade file failed to open";
        return 1;
    }
    string detailsStr[6];
    int codeW = 0, descriptionW = 0, teacherW = 0, scheduleW = 0;
    float totalWeightedGrade = 0, totalUnits = 0, GPA;
    for (int i = 0; i < totalSubjects; i++) {
        getline (grade, courseStr);
        int pos1 = 0, pos2 = 0;
        for (int j = 0; pos2 != string::npos; j++) {
            pos2 = courseStr.find_first_of (",", pos1);
            detailsStr[j] = courseStr.substr (pos1, pos2 - pos1);
            pos1 = pos2 + 1;
        }
        courseArr[i].code = detailsStr[0];
        courseArr[i].description = detailsStr[1];
        courseArr[i].units = stof (detailsStr[2]);
        courseArr[i].teacher = detailsStr[3];
        courseArr[i].schedule = detailsStr[4];
        courseArr[i].grade = stof (detailsStr[5]);
        
        // Get widths
        codeW = courseArr[i].code.length() > codeW
              ? courseArr[i].code.length() : codeW;
        descriptionW = courseArr[i].description.length() > descriptionW
                     ? courseArr[i].description.length() : descriptionW;
        teacherW = courseArr[i].teacher.length() > teacherW
                 ? courseArr[i].teacher.length() : teacherW;
        scheduleW = courseArr[i].schedule.length() > scheduleW
                  ? courseArr[i].schedule.length() : scheduleW;
        
        // Calculate remaining data
        totalWeightedGrade += courseArr[i].weightedGrade();
        totalUnits += courseArr[i].units;
    }
    grade.close();
    GPA = totalWeightedGrade / totalUnits;
    
    // Output data
    ofstream report ("report.txt");
    if (!report.is_open()) {
        cerr << "Report file failed to open";
        return 1;
    }
    report << "Final Grade Report" << endl;
    report << "Student name: " << STUDENT_NAME << endl << endl;
    report << fixed << setprecision (2);
    report << left << setw (codeW + 3) << "Subject" << setw (descriptionW + 3) 
           << "Description" << setw (8) << "Units" << setw (teacherW + 3)
           << "Teacher" << setw (scheduleW + 3) << "Schedule" << setw (8)
           << "Grade" << endl;
    for (int i = 0; i < totalSubjects; i++) {
        report << setw (codeW + 3) << courseArr[i].code
               << setw (descriptionW + 3) << courseArr[i].description
               << setw (8) << courseArr[i].units << setw (teacherW + 3)
               << courseArr[i].teacher << setw (scheduleW + 3)
               << courseArr[i].schedule << setw (8) << courseArr[i].grade
               << endl;
    }
    report << endl << "Total Units taken: " << totalUnits << endl;
    report << "Total number of subjects enrolled: " << totalSubjects << endl;
    report << "General Percentile Average (GPA): " << GPA << endl;
    
    cout << "Report saved to file.";
    
    return 0;
}
