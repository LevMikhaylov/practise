package com.example.crudapp.CUD;

import MVC.EntityController.EntityController;
import MVC.EntityModel.EntityModel;
import MVC.EntityView.EntityView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class DeleteFormController {
    @FXML
    private TextField tf4;
    @FXML
    public void onDeleteButtonClick(){
        EntityController ec = new EntityController(new EntityModel(),new EntityView());
        int id = Integer.parseInt(tf4.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("А вы уверены, что хотите удалить эту сущность?");
        ButtonType yesButton = new ButtonType("Да");
        ButtonType noButton = new ButtonType("Нет");
        alert.getButtonTypes().setAll(yesButton, noButton);
        alert.showAndWait().ifPresent((buttonType -> {
            if(buttonType==yesButton){
                try {
                    ec.delete(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setContentText("Ок. Не удаляем.");
                alert1.show();
            }
        }));
    }
}
