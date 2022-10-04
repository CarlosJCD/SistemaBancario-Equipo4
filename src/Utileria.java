import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utileria {    
    static String generarId() {
        return UUID.randomUUID().toString();
    }

    static String generarFecha() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now());
    }
}
