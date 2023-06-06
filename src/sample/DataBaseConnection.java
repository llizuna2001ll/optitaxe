package sample;


import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {


public  Connection databaseLink = null;


        public Connection getConnection () {

            String databaseName = "optitaxe";
            String databaseUser = "root";
            String databasePassword = "izuna2001";
            String url = "jdbc:mysql://localhost/" + databaseName;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

            } catch (Exception e) {

                e.printStackTrace();
                e.getCause();
         }

            return databaseLink;
        }
}












