package prestamos2;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

/**
 *
 * @author carlos
 */
public class ClienteDAO implements IfCRUD<Cliente> {

    //static final String URL = "jdbc:derby:test141637;create=true";
    static final String URL = "jdbc:derby:test300723;create=true";
    static String tableName = "Cliente";
    ///home/carlos/Development/NetBeansProjects/Prestamos2/
    static Connection conn = null;
    static Statement stmt = null;
    PreparedStatement pstmt = null;
    DatabaseMetaData dbMetadata = null;
    static ResultSet rs = null;
    static ResultSet resultSetSelect = null;
    static ResultSet rsMetadata = null;

    @Override
    public List<Cliente> listarElems() {
        List<Cliente> arrClientes = new ArrayList<>();
        final String query = "SELECT * FROM " + tableName;
        System.out.println("listarElems");
        try {
            conn = DriverManager.getConnection(URL, "app", "");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                arrClientes.add(new Cliente(
                        rs.getInt("Cedula"),
                        rs.getString("Nacionalidad").charAt(0),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("telefFijo")
                ));
                System.out.println(rs.getInt("Id") + "  " + rs.getString("Name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return arrClientes;

    }

    @Override
    public void insertarElem(Cliente cliente) {

    }

    @Override
    public Cliente buscarElem(int cedula) {
        //List<Cliente> arrClientes = new ArrayList<>();
        Cliente clienteBuscado = null;
        final String querySelect = "SELECT * FROM Person1 WHERE Cedula = " + cedula;
        //System.out.println(query);
        try {
            conn = DriverManager.getConnection(URL, "app", "");
            stmt = conn.createStatement();

            rs = stmt.executeQuery(querySelect);

            //while (rs.next()) {
            rs.next();
            //arrClientes.add(new Cliente(rs.getInt("cedula"), rs.getString("nombre")));
            clienteBuscado = new Cliente(
                    rs.getInt("Cedula"),
                    rs.getString("Nacionalidad").charAt(0),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("TelefFijo"));
            System.out.println(clienteBuscado.getCeduLa() + " " + clienteBuscado.getNombre());
            //  }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return clienteBuscado;
    }

    @Override
    public void actualizarElem(int id) {
    }

    @Override
    public void eliminarElem(int id) {
    }

    public void createTable() {
        String queryCreateT
                = "CREATE TABLE " + tableName + "( "
                + "Cedula INT PRIMARY KEY, "
                + "Nombre VARCHAR(30))"
                + "Apellido VARCHAR";
        try {
            conn = DriverManager.getConnection(URL, "app", "");
            stmt = conn.createStatement();

            //  }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }
// main solo para pruebas

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            ClienteDAO.conn = DriverManager.getConnection(URL, "app", "");
            ClienteDAO.stmt = conn.createStatement();
            ClienteDAO.rs = stmt.executeQuery("SELECT * FROM PERSON1");
            while (rs.next()) {
                //System.out.println(rs.getInt("id") + "  " + rs.getString("nombre"));
                System.out.println(rs.getInt("Id") + " " + rs.getString("Name"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

}
