public class Student {
    private String Name;
    private int id;
    private String Grade;
    public Student(String name, int id, String grade) {
        this.Name = name;
        this.id = id;
        this.Grade = grade;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        this.Grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
