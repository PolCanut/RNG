package RNG.modelo;

public class ListaPedidos extends Lista<Pedido>{

    public ListaPedidos() {

    }

    public static void mostrarPedido(ListaPedidos listado){

        for (int i =0;i<listado.getSize();i++) {
            System.out.println("Articulo del pedido " + listado.getArrayList().get(i).getArticulo()+ " Cliente del pedido " + " ¿El pedido esta realizado?");

        }
    }
}
