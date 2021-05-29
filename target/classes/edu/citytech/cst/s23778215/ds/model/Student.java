package edu.citytech.cst.s23778215.ds.model;

import java.util.Arrays;

public class Student implements Comparable<Student>{

    public int emplid;
    public float[] grades;

    public Student(int emplid, float[] grades){
        this.emplid=emplid;
        this.grades=grades;

    }
    public int getEmplid(){ return emplid; }

    public float[] getGrades(){ return grades; }

    @Override
    public String toString(){
        return "Student{"+
                "emplid" +emplid+
                ",grades" + Arrays.toString(grades)+
                '}';
    }

    @Override
    public int compareTo(Student o){
        var allGrades = this.grades[0] + this.grades[1] + this.grades[2];
        var otherGrades = o.grades[0] + o.grades[1] + this.grades[2];
        return Float.compare(allGrades,otherGrades);
//        return  0;
    }
}
