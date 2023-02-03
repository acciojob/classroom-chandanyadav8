package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student)
    {

        return studentRepository.addStudent(student);
    }
    public String addTeacher(Teacher teacher)
    {

        return studentRepository.addTeacher(teacher);
    }
    public String addStudentTeacherPair(String student,String teacher)
    {

        return studentRepository.addStudentTeacherPair(student,teacher);
    }
    public Student getStudentByName(String name)
    {
        return studentRepository.getStudentByName(name);
    }
    public Teacher getTeacherByName(String name)
    {
        return studentRepository.getTeacherByName(name);
    }
    public List<String> getStudentsByTeacherName(String name)
    {
        return studentRepository.getStudentsByTeacherName(name);

    }
    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public String deleteTeacherByName(String name)
    {
        return studentRepository.deleteTeacherByName(name);
    }
    public String deleteAllTeachers()
    {
        return studentRepository.deleteAllTeachers();
    }
}
