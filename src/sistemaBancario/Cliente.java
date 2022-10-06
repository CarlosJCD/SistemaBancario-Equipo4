package sistemaBancario;

import java.io.*;
import java.util.Scanner;

public class Cliente {

    private String nombre;
    private String idCliente;
    private File registroCuentas;
    private Cuenta[] cuentas = new Cuenta[3];

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.idCliente = Utileria.generarId();
        this.registroCuentas = new File(this.nombre + "_" + this.idCliente + ".txt");
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroDeCliente() {
        return idCliente;
    }

    public void añadirCuenta(Cuenta nuevaCuenta) {
        try {
            if (!this.registroCuentas.exists()) {
                this.registroCuentas.createNewFile();
                FileWriter escritor = new FileWriter(this.registroCuentas);
                escritor.write(nuevaCuenta.toString());
                escritor.close();
                agregarCuenta(nuevaCuenta);
            } else {
                Scanner lector = new Scanner(this.registroCuentas);
                while (lector.hasNextLine()) {
                    if (lector.nextLine().contains("Numero de cliente: " + nuevaCuenta.getNumeroDeCliente())) {
                        agregarCuenta(nuevaCuenta);
                        lector.close();
                        break;
                    } else if (!lector.hasNextLine()) {
                        FileWriter escritor = new FileWriter(this.registroCuentas, true);
                        escritor.write(nuevaCuenta.toString());
                        escritor.close();
                        lector.close();
                        agregarCuenta(nuevaCuenta);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al registrar la cuenta");
        }
    }

    private void agregarCuenta(Cuenta nuevaCuenta) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = nuevaCuenta;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Numero de cliente: " + idCliente + ", Cliente: " + nombre + "\n";
    }
}
