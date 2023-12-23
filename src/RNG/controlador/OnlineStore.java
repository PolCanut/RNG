package RNG.controlador;

import RNG.vista.GestionOS;
import RNG.util.HibernateUtil;
import org.hibernate.Session;

public class OnlineStore {
    public static void main(String[] args) {
        GestionOS gestion = new GestionOS();

        // Inicializar Hibernate (puedes hacer esto al inicio de tu aplicación)
        HibernateUtil.buildSessionFactory();

        try {
            gestion.inicio();
        } finally {
            // Cerrar la sesión de Hibernate y otros recursos al finalizar la aplicación
            HibernateUtil.shutdown();
        }
    }
}
