package RNG.modelo;

public class Cliente {
    String nombre;
    String direccion;
    String email;
    boolean premium;


    public Cliente() {
    }

    public Cliente(String nombre, String direccion, String email, boolean premium) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.premium = premium;
    }

    public String getNombre() {
        return nombre;
    }
    public boolean getPremium() {
        return premium;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void getPremium(boolean premium) {
        this.premium = premium;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email=" + email +
                '}';
    }
}
