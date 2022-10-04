package sistemaBancario;

public class Retiro extends Movimiento {

    public Retiro(String numeroDeCuenta, double monto) {
        super(numeroDeCuenta, monto);

        guardarMovimiento();
    }

    @Override
    public String toString() {
        return "Fecha: " + this.fecha + ", $" + this.monto + ", Retiro - " + this.id + ",Cuenta de origen: "
                + this.numeroDeCuenta + "\n";
    }
}
