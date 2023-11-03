package RNG.modelo;

public class ListaClientes extends Lista<Cliente>{

    public ListaClientes() {

    }

    public static void mostrarClientes(ListaClientes listado){

        for (int i =0;i<listado.getSize();i++) {
            System.out.println("Nombre del cliente " + listado.getArrayList().get(i).getNombre()+ " Direccion del cliente "+ listado.getArrayList().get(i).getDireccion()+ " Email del cliente "+ listado.getArrayList().get(i).getEmail()+ " Es el cliente premium "+ listado.getArrayList().get(i).getPremium());

        }
    }
    public static void mostrarClientes(ListaClientes listado, boolean premium){

        for (int i =0;i<listado.getSize();i++) {
            if (premium) {
                if (listado.getArrayList().get(i).getPremium()) {
                    System.out.println("Nombre del cliente " + listado.getArrayList().get(i).getNombre() + " Direccion del cliente " + listado.getArrayList().get(i).getDireccion() + " Email del cliente " + listado.getArrayList().get(i).getEmail() + " Es el cliente premium " + listado.getArrayList().get(i).getPremium());
                }
                if (!listado.getArrayList().get(i).getPremium()) {
                    System.out.println("Nombre del cliente " + listado.getArrayList().get(i).getNombre() + " Direccion del cliente " + listado.getArrayList().get(i).getDireccion() + " Email del cliente " + listado.getArrayList().get(i).getEmail() + " Es el cliente premium " + listado.getArrayList().get(i).getPremium());
                }
            }



        }
    }
}
