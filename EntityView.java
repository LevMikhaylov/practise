import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;
import java.util.List;

public class EntityView {
    public void getEntities(List<String> columnNames, TableView<ObservableList<String>> tableView) throws SQLException {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

        Connection connection  = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/IIIPIIXXIIMikhaylovPractice",
                "postgres", "Pa$$w0rd");

        String sql = "SELECT * FROM entities";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (String columnName : columnNames) {
                    row.add(resultSet.getString(columnName));
                }
                data.add(row);
            }
        } finally {
            connection.close();
        }

        // Установка данных в TableView
        tableView.setItems(data);
        for (int i = 0; i < tableView.getColumns().size(); i++) {
            TableColumn<ObservableList<String>, String> column = (TableColumn<ObservableList<String>, String>) tableView.getColumns().get(i);
            final int columnIndex = i;
            column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(columnIndex)));
        }
    }
    public void showmsg(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
    }
}
