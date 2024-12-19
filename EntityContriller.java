package MVC.EntityController;



import MVC.EntityModel.EntityModel;
import MVC.EntityView.EntityView;
import java.sql.SQLException;
import java.time.LocalDate;

public class EntityController {
    private EntityModel em;
    private EntityView ev;

    public EntityController(EntityModel em, EntityView ev) {
        this.em = em;
        this.ev = ev;
    }
    public void delete(int id) throws SQLException {
        int rowsAffected = em.deleteEntity(id);
        if(rowsAffected > 0)
        ev.showmsg("Сущность с id " + id + " была удалена");
        else
            ev.showmsg("Сущность с id " + id + " не найдена");
    }
    public void insert(int id, String name, String description, LocalDate createdAt) throws SQLException {
        int rowsAffected = em.insertEntity(id,name,description,createdAt);
        if(rowsAffected > 0){
            ev.showmsg("Добавление произшло успешно");
        }
        else{
            ev.showmsg("Не удалось выполнить запрос на создание новой сущности");
        }

    }
    public void update(int id, String name, String description, LocalDate createAt) throws SQLException {
        int rowsAffected = em.updateEntity(id,name,description,createAt);
        if(rowsAffected > 0){
            ev.showmsg("Обновление произошло успешно");
        }
        else{
            ev.showmsg("Не удалось выполнить обновление");
        }
    }
}
