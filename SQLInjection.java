import java.sql.*;
import java.util.Scanner;

public class SQLInjection {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");

        String username = sc.nextLine();

        Connection con =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost/test",
                        "root",
                        "password");

        PreparedStatement ps =
                con.prepareStatement(
                        "SELECT * FROM users WHERE username=?");

        ps.setString(1, username);

        ps.executeQuery();

        con.close();
        sc.close();

    }

}
