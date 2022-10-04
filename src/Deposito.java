public class Deposito extends Movimiento {

    public Deposito(String numeroDeCuenta, double monto) {
        super(numeroDeCuenta, monto);

        guardarMovimiento();
    }

    @Override
    public String toString() {
        return "\nDeposito - " + id + "\n" + 
               "Fecha: " + fecha + " - $" + monto + "\n" +
               "Cuenta de destino: " + numeroDeCuenta + "\n";
    }
}
