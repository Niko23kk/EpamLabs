package model;

public class Group {
    private Faculty faculty;
    private int id;

    public Faculty getFaculty() {
        return faculty;
    }

    public int getId() {
        return id;
    }

    public Group(Faculty faculty, int id){
        this.faculty = faculty;
        this.id = id;
    }
}
