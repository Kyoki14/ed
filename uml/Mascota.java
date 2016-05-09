package ejercicio14UML;

import java.util.List;
import java.util.ArrayList;

public class Mascota {
    
    List<Cliente> clientes;
    Calendario_vacuna calendario_vacunas;  
    Historial historial;
    double peso_medio;   
    double peso_actual;   
    double[] pesos_visitas;
    String raza;
    String codigo;
    String alias;
    String color;   
    String especie;
    String fecha_nacimiento;
    
    public Mascota() {
        
        clientes = new ArrayList<>();
        peso_actual = 0;      
    }    
}
