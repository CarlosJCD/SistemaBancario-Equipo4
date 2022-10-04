import java.io.*;

public abstract class Movimiento {

    protected String id;
    protected String fecha;
    protected double monto;
    protected String numeroDeCuenta;

    private final String path = "../MovimientosFMAT.txt";

    public Movimiento(String numeroDeCuenta, double monto) {
        this.id = Utileria.generarId();
        this.fecha = Utileria.generarFecha();
        this.numeroDeCuenta = numeroDeCuenta;
        this.monto = monto;
    }

    public void guardarMovimiento() {
        
        File file = new File(path);

        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("El archivo de registro de los movimientos no se ha podido crear.");
            }
        }

        try {
            FileWriter writer = new FileWriter(path, true);

            for (int i = 0; i <= toString().length() - 1; i++) {
                writer.write(toString().charAt(i));
            }

            writer.close();
        } catch(Exception e) {
            System.out.println("No se ha podido escribir en el archivo de registro.");
        }
    }
}