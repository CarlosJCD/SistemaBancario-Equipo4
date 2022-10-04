package sistemaBancario;

public class App {
    public static void main(String[] args) {

        System.out.println();
        Banco fmatBank = new Banco("FMAT Bank");

        Cliente abraham = new Cliente("Abraham", "Espinosa");

        Cuenta1 c1 = new Cuenta1(abraham.getNumeroDeCliente());
        Cuenta2 c2 = new Cuenta2(abraham.getNumeroDeCliente());

        fmatBank.unirCliente(abraham);

        abraham.agregarCuenta(c1);
        abraham.agregarCuenta(c2);

        c1.depositar(30000);
        c1.transferir(c2, 400, "Despensa");

        c1.getEstadoDeCuenta("04/10/2022", "04/10/2022");
    }

}