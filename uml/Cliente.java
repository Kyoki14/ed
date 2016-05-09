package ejercicio14UML;

import java.util.List;
import java.util.ArrayList;

public class Cliente {  
    
    List<Persona> persona;
    List<Mascota> mascota;
    String primer_apellido;
    int numero_cuenta_banco;
    String direccion;
    String codigo;
    int telefono;   
    
    public Cliente() {
        
        mascota = new ArrayList<>();
        persona = new ArrayList<>();       
    }  
}
