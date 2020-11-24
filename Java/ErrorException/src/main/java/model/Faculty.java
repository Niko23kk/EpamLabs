package model;

public class Faculty {
    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    private int id;

    public Faculty(String name, int id){
        this.name = name;
        this.id = id;
    }
}
