package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDB;
    HashMap<String,Teacher> teacherDB;
    HashMap<String,List<String>> teacherStudentPair;

    public StudentRepository() {
        this.studentDB = new HashMap<String,Student>();
        this.teacherDB = new HashMap<String,Teacher>();
        this.teacherStudentPair = new HashMap<String,List<String>>();
    }
    public void addStudent(Student student){
        studentDB.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        teacherDB.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student,String teacher){
        if(studentDB.containsKey(student) && teacherDB.containsKey(teacher)){
            List<String> studentList = new ArrayList<>();
            if(teacherStudentPair.containsKey(teacher))
                studentList = teacherStudentPair.get(teacher);
            studentList.add(student);
            teacherStudentPair.put(teacher,studentList);
        }
    }

    public Student getStudentByName(String student){
        return studentDB.get(student);
    }

    public Teacher getTeacherByName(String teacher){
        return teacherDB.get(teacher);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        List<String> studentList= new ArrayList<>();
        if(teacherStudentPair.containsKey(teacher)){
            studentList = teacherStudentPair.get(teacher);
        }

        return studentList;
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(studentDB.keySet());
    }

    public void deleteTeacherByName (String teacher){
        if(teacherStudentPair.containsKey(teacher)){
            List<String> studentList = teacherStudentPair.get(teacher);
            for(String student:studentList){
                if(studentDB.containsKey(student)){
                    studentDB.remove(student);
                }
            }
            teacherStudentPair.remove(teacher);
        }

        if(teacherDB.containsKey(teacher)){
            teacherDB.remove(teacher);
        }
    }

    public void deleteAllTeachers() {
        teacherDB = new HashMap<>();
        for (String teacher : teacherStudentPair.keySet()) {
            for (String student : teacherStudentPair.get(teacher)) {
                if (studentDB.containsKey(student)) {
                    studentDB.remove(student);
                }
            }
        }
    }}







