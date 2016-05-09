package ejercicio14UML;

public class Persona {
    
    String primer_apellido;
    String segundo_apellido;
    String dni;
    String nombre;   
    
    public Persona(String primer_apellido, 
        String segundo_apellido, String nombre, String dni) {
        
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.dni = dni;
        this.nombre = nombre;       
    }
}
