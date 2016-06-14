
package crewmanagement;

/**
 * @author Gonzalo
 */

public class Turn {
    
    protected String day;
    protected int initHour;
    protected int finishHour;
    
    public  Turn() {
    }
    
    public Turn(String aDay) {
        if (aDay != null) {           
            day = aDay.toUpperCase();            
        }   
    }
    
    public Turn(String aDay, int aInitHour, int aFinishHour) {
        
        if (aDay != null) {
            day = aDay.toUpperCase(); 
        }
        
        if ( (aInitHour >= 0) && (aInitHour <= 23) ) {
            initHour = aInitHour;
        }
               
        if ( (aFinishHour >= 0) && (aFinishHour <= 23) ) {
            finishHour = aFinishHour;
        }    
    }
    
    /**
     * 
     * @param aDay Permite añadir un día
     */
    public void setDay(String aDay) {
        if (aDay != null) {
            day = aDay.toUpperCase(); 
        }
        else  {
            day = null;
        }
    }
    
    /**
     * 
     * @return Devuelve el día
     */
    public String getDay() {
        return day;
    }
    
    /**
     * 
     * @param aInitHour Permite añadir un hora de inicio
     */
    public void setInitHour(int aInitHour) {
        if ( (aInitHour >= 0) && (aInitHour <= 23) ) {
            initHour = aInitHour;
        }
    }
    
    /**
     * 
     * @return Devuelve la hora de inicio
     */
    public int getInitHour() {
        return initHour;
    }
    
    /**
     * 
     * @param aFinishHour Permite asignar la hora de finalización
     */
    public void setFinishHour(int aFinishHour) {
        if ( (aFinishHour >= 0) && (aFinishHour <= 23) ) {
            finishHour = aFinishHour;
        }
    }
    
    /**
     * 
     * @return Devuelve la hora de finalización
     */
    public int getFinishHour() {
        return finishHour;
    }    
}
