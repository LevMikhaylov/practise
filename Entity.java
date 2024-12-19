package MVC.EntityModel;

import java.time.LocalDate;

public class Entity {
    private int id;
    private String name;
    private String decription;
    private LocalDate createAt = LocalDate.now();
    private LocalDate updatedAt;

    public Entity(String name, int id, String decription, LocalDate updatedAt) {
        this.name = name;
        this.id = id;
        this.decription = decription;
        this.updatedAt = updatedAt;
    }

    public Entity(int id, String name, String decription) {
        this.id = id;
        this.name = name;
        this.decription = decription;
    }

    public Entity(int id, String name, String decription, LocalDate createAt) {
        this.id = id;
        this.name = name;
        this.decription = decription;
        this.createAt = createAt;
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
