package com.example.crudapp;

import MVC.EntityView.EntityView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class HelloController {
    @FXML
    private TableView<ObservableList<String>> entities;
    private final EntityView ev = new EntityView();
    @FXML
    protected void onCreateButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addition form.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    protected void onUpdateButtonClick() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Update form.fxml"));
        Parent root;
        root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    protected void onDeleteButtonClick() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Delete form.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    protected void onShowButtonClick(){
        List<String> columnNames = Arrays.asList("id", "name", "description", "createdat", "updatedat");
        try {
            ev.getEntities(columnNames, entities);
        } catch (SQLException e) {
            ev.showmsg("Ошибка при загрузке данных: " + e.getMessage());
        }
    }
}
