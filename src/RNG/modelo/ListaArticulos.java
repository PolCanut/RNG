package RNG.modelo;

public class ListaArticulos extends Lista<Articulo> {

    public ListaArticulos() {

    }

    public static void mostrarArticulos(ListaArticulos listado){

        for (int i =0;i<listado.getSize();i++) {
            System.out.println("Nombre del articulo " + listado.getArrayList().get(i).getNombre()+ " Precio del articulo "+ listado.getArrayList().get(i).getPrecio());
            
        }
    }
}

