package ejercicio14UML;

import java.util.List;
import java.util.ArrayList;

public class Calendario_vacuna {
    
    List<String> fecha_vacuna;
    List<String> vacuna_enfermedad;
    Mascota mascota;
    
    public Calendario_vacuna(Mascota mascota) {
        
        this.mascota = mascota;
        fecha_vacuna = new ArrayList<>();
        vacuna_enfermedad = new ArrayList<>();              
    }   
}
