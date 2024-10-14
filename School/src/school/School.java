/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import java.util.ArrayList;

/**
 *
 * @author delmoro-ke
 */
public class School {
    private ArrayList<StudentGrade> grades = new ArrayList<StudentGrade>();

    public School() {}
    
    public void addGrade (StudentGrade grade) {
        grades.add(grade);
    }
    
    public void clearGrades () {
        grades.clear();
    }

    public ArrayList<StudentGrade> getAllGrades() {
        return grades;
    }
    
    public ArrayList<StudentGrade> getGradesById(int id) {
        ArrayList<StudentGrade> idGrades = new ArrayList<>(); 
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i).getStudent().getId() == id)
                idGrades.add(grades.get(i));
        }
        return idGrades;
    }
    
    public ArrayList<StudentGrade> getGradesBySubject(String code) {
        ArrayList<StudentGrade> subGrades = new ArrayList<>(); 
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i).getSubject().getCode().equals(code))
                subGrades.add(grades.get(i));
        }
        return subGrades;
    }
}
