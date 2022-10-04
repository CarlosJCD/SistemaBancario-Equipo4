public class Transferencia extends Movimiento {

    private String destino;
    private String concepto;

    public Transferencia(String numeroDeCuenta, String destino, double monto, String concepto) {
        super(numeroDeCuenta, monto);
        this.destino = destino;
        this.concepto = concepto;

        guardarMovimiento();
    }

    @Override
    public String toString() {
        return "\nFecha: " + fecha + " - $" + monto + "\n" +
                "Transferencia - " + id + "\n" +
                "Concepto: " + concepto + "\n" +
                "Cuenta de origen: " + numeroDeCuenta + "\n" +
                "Cuenta de destino: " + destino + "\n";
    }
}
