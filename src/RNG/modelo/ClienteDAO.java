package RNG.modelo;

import java.util.List;

public interface ClienteDAO {
    void agregarCliente(Cliente cliente);
    void eliminarCliente(String correoElectronicoCliente);
    Cliente buscarClientePorCorreo(String correoElectronico);
    List<Cliente> obtenerTodosLosClientes();
}
