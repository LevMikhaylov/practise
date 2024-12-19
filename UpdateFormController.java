import MVC.EntityController.EntityController;
import MVC.EntityModel.Entity;
import MVC.EntityModel.EntityModel;
import MVC.EntityView.EntityView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.time.LocalDate;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
public class UpdateFormController {
    @FXML
    private TextField tf5;
    @FXML
    private TextField tf6;
    @FXML
    private TextField tf7;
    @FXML
    private DatePicker dp1;
    @FXML
    public void onUpdateButtonClick(){
        EntityController ec = new EntityController(new EntityModel(),new EntityView());
        try{
            LocalDate createdAt = dp1.getValue();
            if(createdAt.isBefore(LocalDate.now())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("ОШИБКА! Дата создания должна до текущей даты или равна ей!");
                alert.show();
            }
            else {
                Entity e = new Entity(Integer.parseInt(tf5.getText()), tf6.getText(), tf7.getText(), createdAt);
                ec.update(e.getId(), e.getName(), e.getDecription(), e.getCreateAt());
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Не удалось обновить данные");
            alert.show();
        }
    }
}
