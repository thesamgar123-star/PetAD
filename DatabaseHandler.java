import java.sql.*;

public class DatabaseHandler {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "123456";


    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // WRITE
    public void addPet(String name, String species, int age) {
        String sql = "INSERT INTO pet(name, species, age) VALUES(?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, species);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            System.out.println("Pet added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // READ + SORT
    public void showSortedPets() {
        String sql = "SELECT * FROM pet ORDER BY age ASC";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("name") + " (" + rs.getInt("age") + " years)");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // UPDATE
    public void updatePetAge(int id, int newAge) {
        String sql = "UPDATE pet SET age = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // DELETE
    public void deletePet(int id) {
        String sql = "DELETE FROM pet WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            System.out.println("Deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}