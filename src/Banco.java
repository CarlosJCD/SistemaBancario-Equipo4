import java.io.*;

class Banco {

    private String nombre;
    private Cliente[] clientes = new Cliente[2];

    private final String path = "../ClientesFMAT.txt";

    public Banco(String nombre) {
        this.nombre = nombre;
    }

    public void generarReporte() {
        System.out.println("Banco " + nombre);

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void unirCliente(Cliente nuevoCliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = nuevoCliente;
                guardarCliente(nuevoCliente);
                return;
            }
        }
    }

    public void guardarCliente(Cliente nuevoCliente) {
        
        File file = new File(path);

        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("El archivo de registro de los clientes no se ha podido crear.");
            }
        }

        try {
            FileWriter writer = new FileWriter(path, true);

            for (int i = 0; i <= nuevoCliente.toString().length() - 1; i++) {
                writer.write(nuevoCliente.toString().charAt(i));
            }

            writer.close();
        } catch(Exception e) {
            System.out.println("No se ha podido escribir en el archivo de registro.");
        }
    }
}