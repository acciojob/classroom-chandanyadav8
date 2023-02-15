package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    public void addStudent(Student student){
        studentRepo.addStudent(student);;
    }

    public void addTeacher(Teacher teacher){
        studentRepo.addTeacher(teacher);;
    }

    public void addStudentTeacherPair(String student,String teacher){
        studentRepo.addStudentTeacherPair(student, teacher);
    }

    public Student getStudentByName(String student){
        return studentRepo.getStudentByName(student);
    }

    public Teacher getTeacherByName(String teacher){
        return studentRepo.getTeacherByName(teacher);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepo.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents(){
        return studentRepo.getAllStudents();
    }

    public void deleteTeacherByName (String teacher){
        studentRepo.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers(){
        studentRepo.deleteAllTeachers();
    }
}

