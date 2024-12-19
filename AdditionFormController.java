import MVC.EntityController.EntityController;
import MVC.EntityModel.EntityModel;
import MVC.EntityView.EntityView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.time.LocalDate;

public class AdditionFormController {
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    public void onInsertButtonClick() throws SQLException {
        EntityController ec = new EntityController(new EntityModel(),new EntityView());
        int id = Integer.parseInt(tf1.getText());
        String name = tf2.getText();
        String description = tf3.getText();
        if(name.length()<3){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("ОШИБКА! Минимальная длина названия сущности 3!");
            alert.show();
        }
        else {
            ec.insert(id, name, description, LocalDate.now());
        }
    }
}
