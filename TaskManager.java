import java.util.Scanner;
import java.util.ArrayList;

class Task{
    private String name ;
    private String description ;
    private String dueDate ;

    public Task(String name,String description,String dueDate ){
        this.name=name;
        this.description=description;
        this.dueDate=dueDate;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

}
class TaskManager{
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }
    public void addTask(String name,String description,String dueDate){
        Task task=new Task(name,description,dueDate);
        tasks.add(task);
        System.out.println("Tasks added successfully.");
    }
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task index.");
        }
    }
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". Name: " + task.getName() + ", Description: " + task.getDescription() + ", Due Date: " + task.getDueDate());
            }
        }
    }
    public static void main(String args[]){
        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine()); // Read the input as a string and parse it to an integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter task name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter task description: ");
                    String description = sc.nextLine();
                    System.out.println("Enter due date: ");
                    String dueDate = sc.nextLine();
                    taskManager.addTask(name, description, dueDate);
                    break;
                case 2:
                    System.out.print("Enter index of task to remove: ");
                    int index;
                    try {
                        index = Integer.parseInt(sc.nextLine()) - 1; // Adjust for 0-based index
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid input. Please enter a number.");
                        continue;
                    }
                    taskManager.removeTask(index);
                    break;
                case 3:
                    taskManager.listTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

    }
}