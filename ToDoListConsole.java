import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✔] " : "[ ] ") + description;
    }
}

public class ToDoListConsole {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nTo-Do List:");
            displayTasks();
            System.out.println("\nOptions: 1. Add Task | 2. Mark Completed | 3. Remove Task | 4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    tasks.add(new Task(scanner.nextLine()));
                    break;
                case 2:
                    System.out.print("Enter task number to mark as completed: ");
                    int index = scanner.nextInt() - 1;
                    if (index >= 0 && index < tasks.size()) tasks.get(index).markCompleted();
                    break;
                case 3:
                    System.out.print("Enter task number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    if (removeIndex >= 0 && removeIndex < tasks.size()) tasks.remove(removeIndex);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
