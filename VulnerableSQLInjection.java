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

        Statement stmt = con.createStatement();

        String query =
                "SELECT * FROM users WHERE username='"
                        + username + "'";

        stmt.executeQuery(query);

        con.close();
        sc.close();

    }

}
