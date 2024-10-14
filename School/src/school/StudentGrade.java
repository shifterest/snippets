/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

/**
 *
 * @author delmoro-ke
 */
public class StudentGrade {
    private final Student student;
    private final Subject subject;
    private final float grade;

    public StudentGrade(Subject subject, Student student, float grade) {
        this.subject = subject;
        this.student = student;
        this.grade = grade;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public Subject getSubject() {
        return subject;
    }

    public float getGrade() {
        return grade;
    }
}
