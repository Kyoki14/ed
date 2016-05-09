package ejercicio14UML;

import java.util.List;
import java.util.ArrayList;

public class Historial {
    
    List<String> enfermedad;
    List<String> fecha_enfermedad;
    Mascota mascota;
    
    public Historial() {       
        
        fecha_enfermedad = new ArrayList<>();
        enfermedad = new ArrayList<>();
    }
}
