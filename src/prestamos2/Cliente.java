package prestamos2;

public class Cliente {

    private int cedula;
    private char nacionalidad;
    private String nombre;
    private String apellido;
    private String telefFijo;
    private String telefMovil;

    public Cliente(int ceduLa, char nacionalidad, String nombre, String apellido, String telefFijo, String telefMovil) {
        this.cedula = ceduLa;
        this.nacionalidad = nacionalidad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefFijo = telefFijo;
        this.telefMovil = telefMovil;
    }
    //const para pruebas

    public Cliente(int ceduLa, char nacionalidad, String nombre, String apellido, String telefFijo) {
        this.cedula = ceduLa;
        this.nacionalidad = nacionalidad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefFijo = telefFijo;
    }

    public Cliente() {
    }
    

    public int getCeduLa() {
        return cedula;
    }

    public void setCeduLa(int ceduLa) {
        this.cedula = ceduLa;
    }

    public char getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(char nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefFijo() {
        return telefFijo;
    }

    public void setTelefFijo(String telefFijo) {
        this.telefFijo = telefFijo;
    }

    public String getTelefMovil() {
        return telefMovil;
    }

    public void setTelefMovil(String telefMovil) {
        this.telefMovil = telefMovil;
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            System.out.println("hola");
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            //return;
        }

    }
}
