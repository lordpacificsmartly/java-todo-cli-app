package todoapp;

import java.io.Serializable;

public class Task implements Serializable {

    public static final long serialVersionUID = 1L;

    private int id;
    private String description;
    private Category category;
    private boolean isCompleted;

    public Task(int id, String description, Category category) {
        this.id = id;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
