public class Test {
    public static void main(String[] args) {
        Student student = new Student("Herobrine",1234,"A+");
        StudentView view = new StudentView();
        StudentController control = new StudentController(student,view);
        control.displayDetails();
        System.out.println();

        System.out.println("Updating Details...");
        control.setName("Steve");
        control.setId(4321);
        control.setGrade("A");
        control.displayDetails();

    }
}