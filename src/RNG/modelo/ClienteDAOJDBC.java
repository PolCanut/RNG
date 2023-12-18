// ClienteDAOJDBC.java
package RNG.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOJDBC implements ClienteDAO {

    @Override
    public void agregarCliente(Cliente cliente) {
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "INSERT INTO Cliente (correoElectronicoCliente, nombre, direccion, esPremium) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, cliente.getCorreoElectronicoCliente());
                preparedStatement.setString(2, cliente.getNombre());
                preparedStatement.setString(3, cliente.getDireccion());
                preparedStatement.setBoolean(4, cliente.esPremium());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarCliente(String correoElectronicoCliente) {
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "DELETE FROM Cliente WHERE correoElectronicoCliente = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, correoElectronicoCliente);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente buscarClientePorCorreo(String correoElectronicoCliente) {
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "SELECT * FROM Cliente WHERE correoElectronicoCliente = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, correoElectronicoCliente);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Cliente(
                                resultSet.getString("correoElectronicoCliente"),
                                resultSet.getString("nombre"),
                                resultSet.getString("direccion"),
                                resultSet.getBoolean("esPremium")
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
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "SELECT * FROM Clientes";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Cliente cliente = new Cliente(
                            resultSet.getString("correoElectronicoCliente"),
                            resultSet.getString("nombre"),
                            resultSet.getString("direccion"),
                            resultSet.getBoolean("esPremium")
                    );
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
