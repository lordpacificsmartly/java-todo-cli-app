package todoapp;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        while (true){
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. List Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> updateTask();
                case 3 -> deleteTask();
                case 4 -> taskManager.listTasks();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void addTask() {
        System.out.println("Adding a new task:");
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task category (PERSONAL, WORK, HOBBY, OTHER): ");
        String categoryStr = scanner.nextLine().toUpperCase();
        Category category = Category.valueOf(categoryStr);
        Task task = new Task(taskManager.getNextId(), description, category);
        taskManager.addTask(task);
        System.out.println("Task added successfully.");
    }

    private static void updateTask() {
        System.out.println("Updating an existing task:");
        System.out.print("Enter task ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new category (PERSONAL, WORK, HOBBY, OTHER): ");
        String categoryStr = scanner.nextLine().toUpperCase();
        Category category = Category.valueOf(categoryStr);
        System.out.print("Is the task completed? (true/false): ");
        boolean isCompleted = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        taskManager.updateTask(id, description, category, isCompleted);
        System.out.println("Task updated successfully.");
    }

    private static void deleteTask() {
        System.out.println("Deleting an existing task:");
        System.out.print("Enter task ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        taskManager.deleteTask(id);
        System.out.println("Task deleted successfully.");
    }
}
