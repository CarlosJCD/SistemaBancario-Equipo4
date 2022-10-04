public class Retiro extends Movimiento {

    public Retiro(String numeroDeCuenta, double monto) {
        super(numeroDeCuenta, monto);

        guardarMovimiento();
    }

    @Override
    public String toString() {
        return "\nRetiro - " + id + "\n" + 
               "Fecha: " + fecha + " - $" + monto + "\n" +
               "Cuenta de origen: " + numeroDeCuenta + "\n";
    }
}
