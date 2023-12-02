// Cliente.java
package RNG.modelo;

public class Cliente {
    private String correoElectronicoCliente;
    private String nombre;
    private String direccion;
    private boolean premium;

    public String getCorreoElectronicoCliente() {
        return this.correoElectronicoCliente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public boolean esPremium() {
        return this.premium;
    }

    public Cliente(String correoElectronicoCliente, String nombre, String direccion, boolean esPremium) {
        this.correoElectronicoCliente = correoElectronicoCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.premium = esPremium;
    }

    // Otros métodos y setters

    @Override
    public String toString() {
        return "Cliente{" +
                "correoElectronicoCliente='" + correoElectronicoCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
