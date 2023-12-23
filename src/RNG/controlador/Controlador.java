package RNG.controlador;

import RNG.modelo.*;

public class Controlador {

    private final ClienteDAO clienteDAO;
    private final ArticuloDAO articuloDAO;
    private final PedidoDAO pedidoDAO;
    private final Datos datos;

    public Controlador() {
        // Puedes usar una fábrica de DAOs para obtener instancias específicas según el tipo de base de datos
        clienteDAO = DAOFactory.getClienteDAO();
        articuloDAO = DAOFactory.getArticuloDAO();
        pedidoDAO = DAOFactory.getPedidoDAO();
        datos = new Datos();
    }

    // Métodos para interactuar con los datos

    public void agregarArticulo(Articulo articulo) {
        articuloDAO.agregarArticulo(articulo);
    }

    public ListaPedidos getListaPedidosPendientes() {
        ListaPedidos lista = pedidoDAO.obtenerPedidosPendientes();
        ListaPedidos lista2 = new ListaPedidos();

        for (int i = 0; i < lista.getSize(); i++) {
            if (!lista.getAt(i).pedidoEnviado()) {
                lista2.add(lista.getAt(i));
            }
        }
        return lista2;
    }

    public void eliminarArticulo(Articulo articulo) {
        articuloDAO.eliminarArticulo(articulo.getCodigoArticulo());
    }

    public void agregarCliente(Cliente cliente) {
        clienteDAO.agregarCliente(cliente);
    }

    public void eliminarCliente(String correoElectronicoCliente) {
        clienteDAO.eliminarCliente(correoElectronicoCliente);
    }

    public Datos getDatos() {
        return datos;
    }

    public void agregarPedido(Pedido pedido) {
        pedidoDAO.agregarPedido(pedido);
    }

    public void eliminarPedido(int numeroPedido) {
        pedidoDAO.eliminarPedido(numeroPedido);
    }

    public Cliente buscarClientePorCorreo(String correo) {
        return clienteDAO.buscarClientePorCorreo(correo);
    }

    public Articulo buscarArticuloPorCodigo(String codigoArticulo) {
        return articuloDAO.buscarArticuloPorCodigo(codigoArticulo);
    }

    public void update() {
    }
}
