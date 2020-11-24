package model;

import java.util.HashMap;

public class Student {
    private int id;
    private String name;
    private Group group;
    private HashMap<String, Integer> grades;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public Student(String name, Group group, int id) {
        this.name = name;
        this.group = group;
        this.id = id;
        grades = new HashMap<String, Integer>();
    }

    public HashMap<String, Integer> getGrades(){
        return new HashMap<String, Integer>(grades);
    }

    public void putNote(String discipline, int note) {
        if(discipline!=null && note>=1 && note<=10)
        grades.put(discipline, note);
    }
}
