public class App {
    public static void main(String[] args) {

        Banco fmatBank = new Banco("FMAT Bank");

        Cliente abraham = new Cliente("Abraham", "Espinosa");

        Cuenta1 c1 = new Cuenta1(abraham.getNumeroDeCliente());
        Cuenta2 c2 = new Cuenta2(abraham.getNumeroDeCliente());

        c1.depositar(3000);
        c1.transferir(c2, 200, "Transferencia entre cuentas");

        abraham.agregarCuenta(c1);
        abraham.agregarCuenta(c2);

        fmatBank.unirCliente(abraham);
    }
}