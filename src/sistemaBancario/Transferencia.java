package sistemaBancario;

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
        return "Fecha: " + this.fecha + ", Transferencia - " + this.id + ", monto:" + this.monto + ", Concepto: "
                + this.concepto + ", Cuenta de origen: " + this.numeroDeCuenta + ", Cuenta de destino: " + this.destino
                + "\n";
    }
}
