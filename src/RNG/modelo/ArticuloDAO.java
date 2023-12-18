// Interfaz ArticuloDAO.java
package RNG.modelo;

import java.util.List;
import RNG.modelo.Articulo;


public interface ArticuloDAO {
    void agregarArticulo(Articulo articulo);
    void eliminarArticulo(String codigoArticulo);
    Articulo buscarArticuloPorCodigo(String codigoArticulo);
    List<Articulo> obtenerTodosLosArticulos();
}
