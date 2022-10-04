public class Retiro extends Movimiento {

    public Retiro(String numeroDeCuenta, double monto) {
        super(numeroDeCuenta, monto);

        guardarMovimiento();
    }

    @Override
    public String toString() {
        return "\nFecha: " + fecha + " - $" + monto + "\n" +
                "Retiro - " + id + "\n" +
                "Cuenta de origen: " + numeroDeCuenta + "\n";
    }
}
