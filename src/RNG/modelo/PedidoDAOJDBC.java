package RNG.modelo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOJDBC implements PedidoDAO {

    @Override
    public void agregarPedido(Pedido pedido) {
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "INSERT INTO Pedido (numeroPedido, fechaHoraPedido, correoElectronicoCliente, codigoArticulo, cantidad, enviado) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, pedido.getNumeroPedido());
                preparedStatement.setTimestamp(2, Timestamp.valueOf(pedido.getFecha()));
                preparedStatement.setString(3, pedido.getCliente().getCorreoElectronicoCliente());
                preparedStatement.setString(4, pedido.getArticulo().getCodigoArticulo());
                preparedStatement.setInt(5, pedido.getCantidad());
                preparedStatement.setBoolean(6, pedido.pedidoEnviado());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarPedido(int numeroPedido) {
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "DELETE FROM Pedido WHERE numeroPedido = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, numeroPedido);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido buscarPedidoPorNumero(int numeroPedido) {
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "SELECT * FROM Pedido WHERE numeroPedido = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, numeroPedido);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Pedido(
                                resultSet.getInt("numeroPedido"),
                                resultSet.getTimestamp("fechaHoraPedido").toLocalDateTime(),
                                new ClienteDAOJDBC().buscarClientePorCorreo(resultSet.getString("correoElectronicoCliente")),
                                new ArticuloDAOJDBC().buscarArticuloPorCodigo(resultSet.getString("codigoArticulo")),
                                resultSet.getInt("cantidad")
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
    public ListaPedidos obtenerPedidosPendientes() {
        ListaPedidos pedidosPendientes = new ListaPedidos();

        try (Connection connection = UtilidadBD.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Pedido WHERE enviado = 0");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int numeroPedido = resultSet.getInt("numeroPedido");
                LocalDateTime fechaHoraPedido = resultSet.getObject("fechaHoraPedido", LocalDateTime.class);

                // Obtener cliente del ResultSet
                Cliente cliente = new ClienteDAOJDBC().buscarClientePorCorreo(resultSet.getString("correoElectronicoCliente"));

                // Obtener artículo del ResultSet
                Articulo articulo = new ArticuloDAOJDBC().buscarArticuloPorCodigo(resultSet.getString("codigoArticulo"));

                // Otros campos del pedido
                int cantidad = resultSet.getInt("cantidad");

                // Crear instancia de Pedido y agregarlo a la lista
                Pedido pedido = new Pedido(numeroPedido, fechaHoraPedido, cliente, articulo, cantidad);
                pedidosPendientes.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Manejo adecuado de excepciones en una aplicación real
        }

        return pedidosPendientes;
    }

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        try (Connection connection = UtilidadBD.obtenerConexion()) {
            String query = "SELECT * FROM Pedido";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Pedido pedido = new Pedido(
                            resultSet.getInt("numeroPedido"),
                            resultSet.getTimestamp("fechaHoraPedido").toLocalDateTime(),
                            new ClienteDAOJDBC().buscarClientePorCorreo(resultSet.getString("correoElectronicoCliente")),
                            new ArticuloDAOJDBC().buscarArticuloPorCodigo(resultSet.getString("codigoArticulo")),
                            resultSet.getInt("cantidad")
                    );
                    pedidos.add(pedido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

}
