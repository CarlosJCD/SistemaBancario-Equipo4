public abstract class Cuenta {
    
    private String numeroDeCuenta;
    private String numeroDeCliente;
    private double saldo;

    public Cuenta(String numeroDeCliente) {
        this.numeroDeCuenta = Utileria.generarId();
        this.numeroDeCliente = numeroDeCliente;
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double deposito) {
        this.saldo += deposito;

        new Deposito(numeroDeCuenta, deposito);
    }

    public void retirar(double retiro) {
        if (retiro <= this.saldo) {
            this.saldo -= retiro;

            new Retiro(numeroDeCuenta, retiro);
        }
    }

    public void transferir(Cuenta destino, double monto, String concepto) {
        if (monto <= this.saldo) {
            this.saldo -= monto;

            try {
                destino.depositar(monto);
            } catch (Exception e) {
                System.out.println("La cuenta a la que intenta depositar no existe.");
            }
            
            new Transferencia(numeroDeCuenta, destino.numeroDeCliente, monto, concepto);
        }
    }

    @Override
    public String toString() {
        return "\nCuenta: "+ numeroDeCuenta + " - Saldo: $" + saldo;
    }
}