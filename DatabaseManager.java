import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;
    private String jdbcUrl = "jdbc:mysql://localhost:3306/timetable_db"; // Change to your MySQL database URL
    private String username = ""; // Change MySQL username
    private String password = ""; // Change MySQL password

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    public void addBatch(String batchName) {
        try {
            String insertQuery = "INSERT INTO batches (name) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, batchName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getBatch(String batchName) {
        try {
            String selectQuery = "SELECT name FROM batches WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, batchName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateBatch(String batchName, String newName) {
        try {
            String updateQuery = "UPDATE batches SET name = ? WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, batchName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBatch(String batchName) {
        try {
            String deleteQuery = "DELETE FROM batches WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, batchName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
