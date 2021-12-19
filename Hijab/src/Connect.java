import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    public Connection connection;

    public Connect(){
        dbUrl = "jdbc:postgresql://localhost:5433/hijabi";
        dbUser = "postgres";
        dbPassword = "123456";

        try{
            connection = DriverManager.getConnection(dbUrl,dbUser, dbPassword);
        }
        catch (SQLException e){
            System.out.println("Terdapat kesalahan: " + e.getMessage());
        }
    }

}
