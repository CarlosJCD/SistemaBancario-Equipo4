package sistemaBancario;

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
        String rutaEstadoDeCuenta = "src/estadoDeCuenta" + this.numeroDeCuenta + ".txt";
        File nuevoEstadoDeCuenta = new File(rutaEstadoDeCuenta);
        File registro = new File("src/MovimientosFMAT.txt");
        try {
            Scanner lector = new Scanner(registro);
            nuevoEstadoDeCuenta.createNewFile();
            FileWriter escritor = new FileWriter(nuevoEstadoDeCuenta);

            boolean bandera = false;
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                if (bandera) {
                    escritor.write("\n" + linea);
                    if (linea.contains("Fecha: " + fechaFinal)) {
                        lector.close();
                        escritor.close();
                        break;
                    }
                }
                if (linea.contains("Fecha: " + fechaInicio)) {
                    escritor.write(linea);
                    bandera = true;
                }

            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getCause());
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

            new Transferencia(numeroDeCuenta, destino.numeroDeCuenta, monto, concepto);
        }
    }

    @Override
    public String toString() {
        return "\nCuenta: " + numeroDeCuenta + " - Saldo: $" + saldo;
    }
}