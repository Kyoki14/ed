
package crewmanagement;

import java.util.ArrayList;

/**
 * @author Gonzalo
 */

public class Employee {
    
    protected String name;
    protected String surname;
    protected String dni;
    protected Turn[] turn = new Turn[7];
    protected byte turnCount = 0;
    
    
    public Employee(){       
    }
    
    public Employee(String aName, String aSurname) {
        if ( aName != null ) {
            name = aName;
        }
        if ( aSurname != null ) {
            surname = aSurname; 
        }      
    }

    public Employee(String aDNI, String aName, String aSurname) {
                
        if (aDNI != null) {
            String[] table = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
            int numero1 = Integer.parseInt(aDNI.substring(0, 7));
            int result = numero1 % 23;
            String letra =  aDNI.substring(8).toUpperCase();

            if ((!letra.equals(table[result-1])) && aDNI.length() == 9 ) {
                dni = aDNI; 
            }
        }
        
        if ( aName != null ) {
            name = aName;
        }
        
        if ( aSurname != null ) {
            surname = aSurname; 
        }
           
    }
    
    /**
     * 
     * @param aName Permite asignar el nombre
     */
    public void setName(String aName){
        if ( aName != null ) {
            name = aName;
        }
    }
    
    /**
     * 
     * @return Permite sacar el nombre
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @param aSurname Asignar el apellido
     */
    public void setSurname(String aSurname){
        if ( aSurname != null ) {
            surname = aSurname; 
        }
    }
    
    /**
     * 
     * @return Permite sacar el apellido
     */
    public String getSurname() {
        return surname;
    }
    
    /**
     * 
     * @param nameInUppercase Si la variable es true pone el nombre en mayúsculas
     * @param surnameInUpperCase Si la variable es true pone el apellido en mayúsculas
     * @return 
     */
    public String getFullName(boolean nameInUppercase, boolean surnameInUpperCase) {
        
        if (name == null) {
            name = "";
        }
        if (surname == null) {
            surname = "";
        }    
        
        if (nameInUppercase && surnameInUpperCase) {        
            return name.toUpperCase() + ", " + surname.toUpperCase();
        }
        else {
            if (nameInUppercase) {
                return name.toUpperCase() + ", " + surname;
            }            
            else if (surnameInUpperCase) {
                return name + ", " + surname.toUpperCase();
            }
        }
            
        
        return name + ", " +surname;          
    }
    
    public void setDNI(String aDNI) {
        
        if (aDNI != null) {
            String[] table = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
            int numero1 = Integer.parseInt(aDNI.substring(0, 7));
            int result = numero1 % 23;
            String letra =  aDNI.substring(8).toUpperCase();

            if ((!letra.equals(table[result-1])) && aDNI.length() == 9 ) {
                dni = aDNI; 
            }
        }
             
    }
    /**
     * 
     * @return Permite obtener el DNI
     */
    public String getDNI() {
        return dni;
    }
    
    /**
     * 
     * @return Permite obtener los turnos
     */
    public int getTurnCount(){

        return turnCount;
      
    }

    /**
     * 
     * @param turno Añade un turno
     */
    public void addTurn(Turn turno) {
        
        if ( (getTurnCount() < 7 ) && (turno != null)) {
            turn[getTurnCount()] = turno;
            turnCount++;
        }      
    }
    
    /**
     * 
     * @param aDay Quita un turno
     */
    public void removeTurn(String aDay) {
        
        if ( (turnCount > 0) && (turnCount <= 7 ) ) {
            
            ArrayList tempList = new ArrayList();
        
            for (int i = 0; i < turnCount; i++) {
                tempList.add(turn[i]); 
            }
            
            for (int i = 0; i < turnCount; i++) {
                if (turn[i].getDay().equals(aDay.toUpperCase())) {
                    tempList.remove(i);
                }
            }
            tempList.toArray(turn);

            turnCount--;
        }
    }

    
    /**
     * 
     * @param anIndex Obtiene un turno en una determinada posición
     * @return 
     */
    public Turn getTurnAt(int anIndex){
        if ( (anIndex >= 0) &&  (anIndex <= 6) ) {
            return turn[anIndex];
        }
        
        return null;
    }
    
    /**
     * 
     * @return Obtiene los turnos
     */
    public Turn[] getTurns() {
        
        Turn[] temp = new Turn[getTurnCount()];
        
        for (int i = 0; i < getTurnCount(); i++) {
            temp[i] = turn[i];
        }
        
        return temp;
    }
                 
}
