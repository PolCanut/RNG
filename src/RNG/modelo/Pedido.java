package RNG.modelo;

public class Pedido {
    Cliente cliente;
    Articulo articulo;
    boolean pendiente;
    public Pedido() {
    }

    public Pedido(Cliente cliente, Articulo articulo, boolean pendiente) {
        this.cliente = cliente;
        this.articulo = articulo;
        this.pendiente = pendiente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + cliente +
                ", articulo=" + articulo +
                '}';
    }
}
