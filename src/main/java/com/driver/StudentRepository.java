package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class StudentRepository {
    Map<String,Student>st=new HashMap<>();
    Map<String,Teacher>tc=new HashMap<>();
    Map<String, List<String>> pairDb = new HashMap<>();
    public String addStudent(Student student)
    {
        st.put(student.getName(),student);
        return "New student added successfully";
    }
    public String addTeacher(Teacher teacher)
    {
        tc.put(teacher.getName(),teacher);
        return "Teacher added succesfully";
    }
    public String addStudentTeacherPair(String student,String teacher)
    {
        List<String> studentList = pairDb.getOrDefault(teacher,new ArrayList<>());
        studentList.add(student);
        pairDb.put(teacher,studentList);
        return "pair added succesfully";
    }
    public Student getStudentByName(String name)
    {
        if(!st.containsKey(name))
            return null;
        return st.get(name);
    }
    public Teacher getTeacherByName(String name)
    {
        if(!tc.containsKey(name))
            return null;
        return tc.get(name);
    }
    public List<String> getStudentsByTeacherName(String teacher){
        List<String> studentList = new ArrayList<String>();
        if(pairDb.containsKey(teacher)) studentList = pairDb.get(teacher);
        return studentList;
    }
    public List<String> getAllStudents(){
        List<String>ans=new ArrayList<>();
        for(String i:st.keySet())
        {

                ans.add(i);
        }
        return ans;
    }
    public String deleteTeacherByName(String name)
    {
        List<String> studentList = pairDb.get(name);
        for(String student : studentList){
            if(st.containsKey(student)){
                st.remove(student);
            }
        }
        pairDb.remove(name);
        return "deleted succesfully";
    }
    public String deleteAllTeachers()
    {
        tc.clear();
        return "All teachers deleted successfully";
    }
}







