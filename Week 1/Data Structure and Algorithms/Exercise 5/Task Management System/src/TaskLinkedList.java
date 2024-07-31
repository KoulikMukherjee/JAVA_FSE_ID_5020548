class TaskLinkedList {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public Task searchTaskById(String taskId) {
        Node curr = head;
        while (curr != null) {
            if (curr.task.getTaskId().equals(taskId)) {
                return curr.task;
            }
            curr = curr.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.task);
            curr = curr.next;
        }
    }

    public void deleteTaskById(String taskId) {
        Node curr = head;
        Node prev = null;
        boolean found = false;

        while (curr != null) {
            if (curr.task.getTaskId().equals(taskId)) {
                String temp = curr.task.getTaskId();
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                found = true;
                System.out.println("Task deleted: " + temp);
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if(!found) {
            System.out.println("Task not found");
        }


    }
}