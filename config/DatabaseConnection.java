package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/farmaciateste"; 

    private static final String USER = "postgres";

    private static final String PASSWORD = "niver2500"; 

    private DatabaseConnection() {
    }

 
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro Crítico: Não foi possível conectar ao banco de dados.\n" + e.getMessage(),
                "Erro de Conexão",
                JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();

            System.exit(1);
            
            return null;
        }
    }
}