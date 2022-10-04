import java.util.Arrays;

public class Cliente {

    private String nombre;
    private String apellido;
    private String numeroDeCliente;
    private Cuenta[] cuentas = new Cuenta[3];

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeCliente = Utileria.generarId();
    }

    public String getNombreCompleto() {
        return nombre + apellido;
    }

    public String getNumeroDeCliente() {
        return numeroDeCliente;
    }

    public void agregarCuenta(Cuenta nuevaCuenta) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = nuevaCuenta;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " " + apellido + "\n" + 
               "Numero de cliente: " + numeroDeCliente + "\n" + 
               "Cuentas: " + Arrays.toString(cuentas) + "\n";
    }
}
