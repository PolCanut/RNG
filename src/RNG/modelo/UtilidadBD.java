// Clase para para controlar las conexiones a la Base de datos
package RNG.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilidadBD {

    private static final String URL = "jdbc:mysql://localhost:3306/RNG";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "123123";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}
