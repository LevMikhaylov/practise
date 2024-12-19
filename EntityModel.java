package MVC.EntityModel;

import java.sql.*;
import java.time.LocalDate;


public class EntityModel {
    public int deleteEntity(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/IIIPIIXXIIMikhaylovPractice",
                "postgres", "Pa$$w0rd");
        String sql = "DELETE from entities where id = ?";
        PreparedStatement s = connection.prepareStatement(sql);
        int rowToDelete = id;
        s.setInt(1, rowToDelete);
        int rowsAffected = s.executeUpdate();
        return rowsAffected;

    }
    public int insertEntity(int id, String name, String description, LocalDate createdAt) throws SQLException {
        Entity entity = new Entity(id, name, description, createdAt);
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/IIIPIIXXIIMikhaylovPractice",
                "postgres", "Pa$$w0rd");
        String sql = "INSERT INTO entities(id,name,description,createdat) values (?,?,?,?)" ;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);  // set first placeholder value
        ps.setString(2, name); // set second placeholder value
        ps.setString(3, description); // set third placeholder value
        ps.setDate(4, Date.valueOf(createdAt));
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }
    public int updateEntity(int id, String name, String description, LocalDate creaetedAt) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/IIIPIIXXIIMikhaylovPractice",
                "postgres", "Pa$$w0rd");
        LocalDate updatedAt = LocalDate.now();
        String sql = "UPDATE entities SET name = ?,description = ?,createdat = ?, updatedat = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2, description);
        ps.setDate(3, Date.valueOf(creaetedAt));
        ps.setDate(4, Date.valueOf(updatedAt));
        ps.setInt(5,id);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }
}
