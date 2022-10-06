package sistemaBancario;

public class Deposito extends Transaccion {

    public Deposito(String numeroDeCuenta, double monto) {
        super(numeroDeCuenta, monto);

        guardarMovimiento();
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Deposito - " + id + ",$" + monto + ",Cuenta de destino: " + numeroDeCuenta + "\n";
    }
}
