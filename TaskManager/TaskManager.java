package tasks;

import java.util.ArrayList;
import java.util.List;

class TaskManager {
    private List<Task> tasks;

    // Constructor, getter, and setter
    public TaskManager () {
        tasks = new ArrayList<>();
    }
    
    public void addTask (Task task) {
        tasks.add(task);
    }
    
    // getSizeTaskManager() – a method that returns the size of the 'tasks' ArrayList
    public int getSizeTaskManager() {
        return tasks.size();
    }
    
    public Task getTask(int i) {
        return tasks.get(i);
    }

    // markTaskAsCompleted() - a method that searches for and marks a task as complete
    public void markTaskAsCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.markAsCompleted();
                break;
            }
        }
    }
    
    // listAllTasks() – a method that displays all tasks from the 'tasks' ArrayList
    public void listAllTasks() {
        for (Task task : tasks) {
            task.displayTask();
        }
    }
    
    // listAllCompletedTasks() – a method that displays completed tasks from the 'tasks' ArrayList
    public void listAllCompletedTasks() {
        int ctr = 0;
        for (Task task : tasks) {
            if (task.isCompleted() && !task.getDescription().equals("TaskRemoved")) {
                task.displayTask();
                ctr++;
            }
        }
        System.out.println("There are " + ctr + " tasked that has been completed!");
    }
    
    public void listAllNotCompletedTasks() {
        int ctr = 0;
        for (Task task : tasks) {
            if (!task.isCompleted() && !task.getDescription().equals("TaskRemoved")) {
                task.displayTask();
                ctr++;
            }
        }
        System.out.println("There are " + ctr + " tasked that has not been completed!");
    }
    
    // removeTask() – a method that changes a specific task's description to "TaskRemoved"
    public void removeTask(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.removeTask();
                break;
            }
        }
    }
}
