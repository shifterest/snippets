class Task {
    private String taskId; // Autogenerated task ID
    private String description;
    private boolean completed;
    
    // Constructors, getters, and setters
    public Task (String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.completed = false;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void displayTask() {
        System.out.println ("Task ID: " + taskId);
        System.out.println ("Description: " + description);
        System.out.println ("Completed: " + completed + "\n");
    }
    
    // markAsCompleted() – a method that changes the 'completed' attribute to true
    public void markAsCompleted() {
        completed = true;
    }
    
    // isCompleted() – a method that returns the 'completed' attribute's value
    public boolean isCompleted() {
        return completed;
    }
    
    // removeTask() – a method that changes the 'description' value to "TaskRemoved"
    public void removeTask() {
        description = "TaskRemoved";
    }
}