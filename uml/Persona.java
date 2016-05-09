package ejercicio14UML;

public class Persona {
    
    String primer_apellido;
    String segundo_apellido;
    String dni;
    String nombre;   
    
    public Persona(String dni, String nombre, String primer_apellido, String segundo_apellido) {
        
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.dni = dni;
        this.nombre = nombre;       
    }
}
