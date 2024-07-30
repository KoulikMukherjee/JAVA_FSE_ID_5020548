public class StudentController {
    private Student student;
    private StudentView view;
    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void setName(String name) {
        student.setName(name);
    }

    public void setId(int id) {
        student.setId(id);
    }

    public void setGrade(String grade) {
        student.setGrade(grade);
    }
    public void displayDetails(){
        view.displayStudentDetails(student);
    }
}
