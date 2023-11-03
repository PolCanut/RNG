package RNG.vista;

import RNG.controlador.Controlador;
import RNG.modelo.*;

import java.util.Scanner;
public class GestionOS {
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in);
    ListaArticulos listadoarticulos = new ListaArticulos();
    ListaClientes listadoclientes = new ListaClientes();
    ListaPedidos listadopedidos = new ListaPedidos();

    public GestionOS() {
        controlador = new Controlador();
    }
    public void inicio() {
        boolean salir = false;
        int opcio;

        do {
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcio = teclado.nextInt();
            switch (opcio) {
                case 1:
                    mostrarMenuGestionArticulos();
                    break;
                case 2:
                    mostrarMenuGestionClientes();
                    break;
                case 3:
                    mostrarMenuGestionPedidos();
                    break;
                case 0:
                    salir = true;
            }
        } while (!salir);
    }

    public void mostrarMenuGestionArticulos(){

        int opcion;
       do{
           System.out.println("¿Que acción deseas realizar?\n1.-Dar de alta un articulo\n2.-Mostrar articulos\n3.-Volver al menu principal\n0.-Cerrar el programa");
           opcion = teclado.nextInt();
       switch(opcion){
           case 1:
               System.out.println("Introduce el nombre del articulo");
               teclado.nextLine();
                        String nombre = teclado.nextLine();

               System.out.println("Introduce el precio del articulo");
                        double precio = teclado.nextDouble();
               Articulo articulo = new Articulo(nombre, precio);
               listadoarticulos.add(articulo);
               break;
           case 2:
               ListaArticulos.mostrarArticulos(listadoarticulos);
           case 3: return;
       }
       }while(opcion!=3);
    }
    public void mostrarMenuGestionClientes(){

        int opcion;
        do{
            System.out.println("¿Que acción deseas realizar?\n1.-Dar de alta un cliente\n2.-Mostrar clientes\n3.-Mostrar clientes premium\n4.-Mostrar clientes estandar\n5.-Volver al menu principal\\n0.-Cerrar el programa\"");
            opcion = teclado.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Introduce el nombre del cliente");
                teclado.nextLine();
                String nombre = teclado.nextLine();
                System.out.println("Introduce la direccion del cliente");
                String direccion = teclado.nextLine();
                System.out.println("Introduce el email del cliente");
                String email = teclado.nextLine();
                System.out.println("Es el cliente premium");
                boolean premium = teclado.nextBoolean();

                Cliente cliente = new Cliente(nombre, direccion, email, premium);
                listadoclientes.add(cliente);
                break;
            case 2:
                ListaClientes.mostrarClientes(listadoclientes);
            case 3:
                ListaClientes.mostrarClientes(listadoclientes, true);
            case 5: return;
        }
    }while(opcion!=3);
    }
    public void mostrarMenuGestionPedidos(){

        int opcion;
        do{
            System.out.println("¿Que acción deseas realizar?\n1.-Dar de alta un pedido\n2.-Eliminar un pedido\n3.-Mostrar un pedido\n4.-Mostrar pedidos pendientes\n5.-Mostrar pedidos enviados");
            opcion = teclado.nextInt();
        switch(opcion) {
            case 1:
                System.out.println("Introduce la posicion del articulo");
                teclado.nextLine();
                int posicionArticulo = teclado.nextInt();
                System.out.println("Introduce la posicion del cliente");
                int posicionCliente = teclado.nextInt();
                System.out.println("El pedido esta pendiente?");
                boolean pendiente = teclado.nextBoolean();

                Pedido pedido = new Pedido(listadoclientes.getArrayList().get(posicionCliente), listadoarticulos.getArrayList().get(posicionArticulo), pendiente);
                listadopedidos.add(pedido);
                break;
            case 2:
                ListaPedidos.mostrarPedido(listadopedidos);
            case 3: return;
        }
    }while(opcion!=3);
    }
// asdads
}
