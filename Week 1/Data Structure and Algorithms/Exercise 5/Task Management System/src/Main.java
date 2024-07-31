public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task("T1", "Open App", "Completed"));
        taskList.addTask(new Task("T2", "Edit App", "In Progress"));
        taskList.addTask(new Task("T3", "Test App", "Pending"));

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for task with Id T2:");
        Task task = taskList.searchTaskById("T2");
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting task with ID T2:");
        taskList.deleteTaskById("T2");

        System.out.println("\nAll Tasks after deletion:");
        taskList.traverseTasks();
    }
}