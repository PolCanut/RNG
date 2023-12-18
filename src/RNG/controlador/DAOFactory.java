package RNG.controlador;

import RNG.modelo.ClienteDAOJDBC;
import RNG.modelo.ArticuloDAOJDBC;
import RNG.modelo.PedidoDAOJDBC;
import RNG.modelo.ArticuloDAO;
import RNG.modelo.ClienteDAO;
import RNG.modelo.PedidoDAO;

public class DAOFactory {

    private static final String DATABASE_TYPE = "MySQL"; //

    public static ClienteDAO getClienteDAO() {
        // Implementa lógica específica para MySQL
        if (DATABASE_TYPE.equals("MySQL")) {
            return new ClienteDAOJDBC();
        }

        throw new UnsupportedOperationException("Tipo de base de datos no soportado: " + DATABASE_TYPE);
    }

    public static ArticuloDAO getArticuloDAO() {
        // Implementa lógica específica para MySQL
        if (DATABASE_TYPE.equals("MySQL")) {
            return new ArticuloDAOJDBC();
        }

        throw new UnsupportedOperationException("Tipo de base de datos no soportado: " + DATABASE_TYPE);
    }

    public static PedidoDAO getPedidoDAO() {
        // Implementa lógica específica para MySQL
        if (DATABASE_TYPE.equals("MySQL")) {
            return new PedidoDAOJDBC();
            // Puedes agregar más condiciones para otros tipos de bases de datos si es necesario
        }

        throw new UnsupportedOperationException("Tipo de base de datos no soportado: " + DATABASE_TYPE);
    }
}
