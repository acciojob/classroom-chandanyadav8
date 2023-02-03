package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class StudentRepository {
    Map<String,Student>st=new HashMap<>();
    Map<String,Teacher>tc=new HashMap<>();
    Map<String,String>pair=new HashMap<>();
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
        pair.put(student,teacher);
        return "Pair added succesfully";
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
    public List<String> getStudentsByTeacherName(String name)
    {
        List<String>ans=new ArrayList<>();
        for(Map.Entry<String,String> i:pair.entrySet())
        {
            if(i.getValue().equals(name))
                ans.add(i.getKey());
        }
        return ans;

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
        if(!tc.containsKey(name))
           return  "Teacher is not present";
        tc.remove(name);
        return "removed successfully";
    }
    public String deleteAllTeachers()
    {
        tc.clear();
        return "All teachers deleted successfully";
    }
}
