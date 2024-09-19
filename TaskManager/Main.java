package tasks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scan = new Scanner(System.in);
    // Implement the Task Manager Application interface using taskManager
    // with options to add tasks, mark tasks as completed, list tasks, list completed tasks,
    // list tasks not completed, pseudo-remove tasks, and exit.
    // Hey there, start typing your Java code here...
    
        System.out.println("Task Manager Application");
        System.out.println("1 - Add Task");
        System.out.println("2 - Mark a Task Completed");
        System.out.println("3 - List All Task");
        System.out.println("4 - List All Completed Task");
        System.out.println("5 - List All Not Completed Task");
        System.out.println("6 - Remove a Task");
        System.out.println("7 - Exit from Task Manager");
    
        while (true) {
            System.out.println(
                "There are "+ taskManager.getSizeTaskManager() + " tasks in the TaskManager"
            );
            
            System.out.print("Select an option: ");
            int c = scan.nextInt(); scan.nextLine();
            
            switch (c) {
                case 1:
                    System.out.print("Enter a new task: ");
                    Task newTask = new Task (
                        ("Task" + (taskManager.getSizeTaskManager() + 1)),
                        scan.nextLine()
                    );
                    taskManager.addTask(newTask);
                    break;
                case 2:
                    System.out.print("Enter a task to mark completed: ");
                    taskManager.markTaskAsCompleted(scan.nextLine());
                    break;
                case 3:
                    System.out.println("All Tasks:");
                    taskManager.listAllTasks();
                    break;
                case 4:
                    System.out.println("Completed Tasks!!!");
                    taskManager.listAllCompletedTasks();
                    break;
                case 5:
                    System.out.println("Tasks  Not Completed!!!");
                    taskManager.listAllNotCompletedTasks();
                    break;
                case 6:
                    System.out.print("Enter a task to mark removed: ");
                    taskManager.removeTask(scan.nextLine());
                    break;
                case 7: 
                    System.out.println("I am committed to becoming an expert software developer.");
                    System.out.println("I will learn new things, practice regularly, and never give up.");
                    System.exit(0);
            }
        }
    }
}
