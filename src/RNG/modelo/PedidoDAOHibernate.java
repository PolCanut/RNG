package RNG.modelo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PedidoDAOHibernate implements PedidoDAO {
    @Override
    public void agregarPedido(Pedido pedido) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(pedido);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarPedido(int numeroPedido) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Pedido pedido = session.get(Pedido.class, numeroPedido);
            if (pedido != null) {
                session.delete(pedido);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Pedido buscarPedidoPorNumero(int numeroPedido) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Pedido.class, numeroPedido);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Pedido", Pedido.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
