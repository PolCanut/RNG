// Clase ArticuloDAOJDBC.java
package RNG.modelo;

import RNG.modelo.Articulo;
import RNG.modelo.Articulo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAOJDBC implements ArticuloDAO {

    @Override
    public void agregarArticulo(Articulo articulo) {
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "INSERT INTO Articulo (codigoArticulo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, articulo.getCodigoArticulo());
                preparedStatement.setString(2, articulo.getDescripcion());
                preparedStatement.setFloat(3, articulo.getPrecioVenta());
                preparedStatement.setFloat(4, articulo.getGastosEnvio());
                preparedStatement.setInt(5, articulo.getTiempoPreparacion());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarArticulo(String codigoArticulo) {
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "DELETE FROM Articulo WHERE codigoArticulo = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, codigoArticulo);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Articulo buscarArticuloPorCodigo(String codigoArticulo) {
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "SELECT * FROM Articulo WHERE codigoArticulo = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, codigoArticulo);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Articulo(
                                resultSet.getString("codigoArticulo"),
                                resultSet.getString("descripcion"),
                                resultSet.getFloat("precioVenta"),
                                resultSet.getFloat("gastosEnvio"),
                                resultSet.getInt("tiempoPreparacion")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Articulo> obtenerTodosLosArticulos() {
        List<Articulo> articulos = new ArrayList<>();
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "SELECT * FROM Articulo";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Articulo articulo = new Articulo(
                            resultSet.getString("codigoArticulo"),
                            resultSet.getString("descripcion"),
                            resultSet.getFloat("precioVenta"),
                            resultSet.getFloat("gastosEnvio"),
                            resultSet.getInt("tiempoPreparacion")
                    );
                    articulos.add(articulo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articulos;
    }
}
