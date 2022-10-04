import java.io.*;
import java.util.Scanner;

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

    public void getEstadoDeCuenta(String fechaInicio, String fechaFinal) {

        String nombreEstadoDeCuenta = "Estado de Cuenta --- " + Utileria.generarFecha();
        File nuevoEstadoDeCuenta = new File(nombreEstadoDeCuenta + ".txt");

        try {
            nuevoEstadoDeCuenta.createNewFile();
            File registro = new File("../MovimientosFMAT.txt");
            Scanner lector = new Scanner(registro);
            FileWriter escritor = new FileWriter(nuevoEstadoDeCuenta);
            boolean bandera = true;

            while (lector.hasNextLine() && bandera) {
                String linea = lector.nextLine();
                if (linea.contains("Fecha: " + fechaInicio)) {
                    while (lector.hasNextLine() && bandera) {
                        linea = lector.nextLine();
                        escritor.write(linea);
                        if (linea.contains("Fecha: " + fechaFinal)) {
                            while (lector.hasNextLine() && bandera) {
                                linea = lector.nextLine();
                                escritor.write(linea);
                                if (linea.contains("Cuenta de destino:")) {
                                    bandera = false;
                                    lector.close();
                                    escritor.close();
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }

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
        return "\nCuenta: " + numeroDeCuenta + " - Saldo: $" + saldo;
    }
}