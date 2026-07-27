import java.sql.Connection;
import user.db.DBConnection;

public class TestDB {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            System.out.println("Connected to DB: " + conn.getCatalog());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
