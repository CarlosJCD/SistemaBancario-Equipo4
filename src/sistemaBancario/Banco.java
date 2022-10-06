package sistemaBancario;

import java.io.*;
import java.util.Scanner;

class Banco {

    private String nombre;
    private Cliente[] clientes = new Cliente[2];
    private File registroBancos;
    private File registroClientes;
    private final String registroBancos_path = "src/registroBancos.txt";
    private final String clientes_path;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes_path = "src/" + this.nombre + "_Clientes.txt";
        registrarBanco();

    }

    private void registrarBanco() {
        this.registroBancos = new File(this.registroBancos_path);
        if (!this.registroBancos.exists()) {
            try {
                this.registroBancos.createNewFile();
                FileWriter escritorBancos = new FileWriter(this.registroBancos);
                escritorBancos.write(this.nombre);
                escritorBancos.close();
                crearRegistroClientes();
            } catch (Exception e) {
                System.out.println("Error creando el registro de archivos: " + e.getLocalizedMessage());
            }
        } else {
            try {
                Scanner lector = new Scanner(registroBancos);
                while (lector.hasNextLine()) {
                    if (lector.nextLine().equals(this.nombre)) {
                        break;
                    }
                    if (!lector.hasNextLine()) {
                        FileWriter escritor = new FileWriter(registroBancos, true);
                        escritor.append(this.nombre);
                        escritor.close();
                        lector.close();
                        crearRegistroClientes();
                    }
                }
            } catch (Exception e) {
                System.out.println("Error leyendo el registro de bancos: " + e.getLocalizedMessage());
            }
        }
    }

    private void crearRegistroClientes() {
        this.registroClientes = new File(this.clientes_path);
        try {
            this.registroClientes.createNewFile();
        } catch (Exception e) {
            System.out.println("Error creando el directorio del banco " + this.nombre + ": " + e.getLocalizedMessage());
        }
    }

    public void generarReporte() {
        System.out.println("Banco " + this.nombre);
        if (this.registroClientes != null) {
            try {
                Scanner lector = new Scanner(this.registroClientes);
                while (lector.hasNextLine()) {
                    System.out.println(lector.nextLine());
                }
                lector.close();
            } catch (Exception e) {
                System.out.println("Error generando el reporte de clientes del banco " + this.nombre + " : "
                        + e.getLocalizedMessage());
            }
        } else {
            System.out.println("El banco " + this.nombre + " no tiene ningun cliente registrado.");
        }
    }

    public void unirCliente(Cliente nuevoCliente) {
        if (this.registroClientes.length() == 0) {
            try {
                FileWriter escritorClientes = new FileWriter(this.registroClientes);
                escritorClientes.write(nuevoCliente.toString());
                escritorClientes.close();
                agregarCliente(nuevoCliente);
            } catch (Exception e) {
                System.out.println("Error registrando el cliente :" + e.getLocalizedMessage());
            }
        } else {
            try {
                Scanner lector = new Scanner(this.registroClientes);
                while (lector.hasNextLine()) {
                    if (lector.nextLine().equals(nuevoCliente.toString())) {
                        lector.close();
                        break;
                    }
                    if (!lector.hasNextLine()) {
                        FileWriter escritor = new FileWriter(this.registroClientes, true);
                        escritor.write(nuevoCliente.toString());
                        escritor.close();
                        lector.close();
                        agregarCliente(nuevoCliente);
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error registrando el cliente :" + e.getLocalizedMessage());
            }
        }
    }

    private void agregarCliente(Cliente nuevoCliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = nuevoCliente;
            }
        }
    }

    @Override
    public String toString() {
        return "Banco: " + this.nombre;
    }
}