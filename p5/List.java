package p5;

import java.util.ArrayList;
import java.util.LinkedList;

public class List {
    
    private static final int SIZE = 1000;
    private static final int DIVISOR = 1000000;
    private static LinkedList<Integer> linkedList;
    private static ArrayList<Integer> arrayList;

    public static ArrayList FillArrayList( ArrayList list) {
        
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
        
        return list;
        
    }
    
    public static LinkedList FillLinkedList( LinkedList list) {
        
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
        
        return list;
        
    }
    
    public static void insertTest() {
        
        double startTime;
        double totalTimeList;
        double totalTimeLinked;   
        
             
        startTime = System.nanoTime();
        arrayList.add(9);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.add(9);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Insertar elemento al final de lista: ");
        
        startTime = System.nanoTime();
        arrayList.add(0, 9);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.add(0, 9);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Insertar elemento al principio de lista");
        
        startTime = System.nanoTime();
        arrayList.add(arrayList.size() / 2, 9);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.add(arrayList.size() / 2, 9);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Insertar elemento en medio de lista");
    }
    
    public static void deleteTest() {
        
        double startTime;
        double totalTimeList;
        double totalTimeLinked;
        
        startTime = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.remove(arrayList.size() - 1);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Borrar elemento al final de lista: ");
        
        startTime = System.nanoTime();
        arrayList.remove(0);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.remove(0);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Borrar elemento al principio de lista");
        
        startTime = System.nanoTime();
        arrayList.remove(arrayList.size() / 2);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.remove(arrayList.size() / 2);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println(totalTimeList + " ---- " + totalTimeLinked + " Borrar elemento en medio de lista");
    }
    
    public static void deleteByValueTest() {
        
        double startTime;
        double totalTimeList;
        double totalTimeLinked;
        
        startTime = System.nanoTime();
        arrayList.remove(999);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.remove(999);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Borrar elemento por valor al final de lista");
        
        startTime = System.nanoTime();
        arrayList.remove(0);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.remove(0);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Borrar elemento por valor al principio de lista");
        
        startTime = System.nanoTime();
        arrayList.remove(500);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.remove(500);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Borrar elemento por valor en medio de lista");
    }
    
    public static void emptyListTest() {
        
        double startTime;
        double totalTimeList;
        double totalTimeLinked;
        
        startTime = System.nanoTime();
        arrayList.removeAll(arrayList);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.removeAll(linkedList);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Vaciar todos los elementos de la lista");
    }
    
    public static void searchTest() {
        double startTime;
        double totalTimeList;
        double totalTimeLinked;
        
        startTime = System.nanoTime();
        arrayList.indexOf(0);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.indexOf(0);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Buscar elemento al principio de la lista");
        
        startTime = System.nanoTime();
        arrayList.indexOf(500);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.indexOf(500);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Buscar elemento en medio de la lista");
        
        startTime = System.nanoTime();
        arrayList.indexOf(999);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.indexOf(999);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Buscar elemento al final de la lista");
        
        startTime = System.nanoTime();
        arrayList.indexOf(99999);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        linkedList.indexOf(99999);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Busqueda de un elemento inexistente");
        
        startTime = System.nanoTime();
        searchAlgorithmArray(0);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        searchAlgorithmLinked(0);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Buscar elemento al principio de la lista algoritmo propio "); 
        
        startTime = System.nanoTime();
        searchAlgorithmArray(500);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        searchAlgorithmLinked(500);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Buscar elemento en medio de la lista algoritmo propio ");   
        
        startTime = System.nanoTime();
        searchAlgorithmArray(999);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        searchAlgorithmLinked(999);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Buscar elemento al final de la lista algoritmo propio "); 
        
        startTime = System.nanoTime();
        searchAlgorithmArray(9999);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        searchAlgorithmLinked(9999);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Busqueda de un elemento inexistente algoritmo propio ");
        
    }
    
    public static void binarySearchTest() {
        double startTime;
        double totalTimeList;
        double totalTimeLinked;
        
        startTime = System.nanoTime();
        binarySearchAlgorithmList(0);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        binarySearchAlgorithmLinked(0);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Busqueda binaria de un elemento al principio de la lista ");
        
        startTime = System.nanoTime();
        binarySearchAlgorithmList(500);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        binarySearchAlgorithmLinked(500);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Busqueda binaria de un elemento al principio en medio de la lista ");
        
        startTime = System.nanoTime();
        binarySearchAlgorithmList(999);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        binarySearchAlgorithmLinked(999);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Busqueda binaria de un elemento al principio al final de la lista ");
        
        startTime = System.nanoTime();
        binarySearchAlgorithmList(9999);
        totalTimeList = (System.nanoTime() - startTime) / DIVISOR;
        startTime = System.nanoTime();
        binarySearchAlgorithmLinked(9999);
        totalTimeLinked = (System.nanoTime() - startTime) / DIVISOR;  
        System.out.println( totalTimeList + " ---- " + totalTimeLinked + " Busqueda binaria de un elemento inexistente ");
    }
    
    public static boolean binarySearchAlgorithmList(int key) {

        int size = arrayList.size();

        int low = 0;
        int high = size - 1;
          
         while(high >= low) {
            int middle = (low + high) / 2;
            if(arrayList.get(middle) == key) {
                return true;
            }
            if(arrayList.get(middle) < key) {
                low = middle + 1;
            }
            if(arrayList.get(middle) > key) {
                high = middle - 1;
            }
       }
       return false;
   }
    
    public static boolean binarySearchAlgorithmLinked(int key) {

        int size = linkedList.size();

        int low = 0;
        int high = size - 1;
          
         while(high >= low) {
            int middle = (low + high) / 2;
            if(linkedList.get(middle) == key) {
                return true;
            }
            if(linkedList.get(middle) < key) {
                low = middle + 1;
            }
            if(linkedList.get(middle) > key) {
                high = middle - 1;
            }
       }
       return false;
   }
     
    
    public static int searchAlgorithmArray(int number) {
        
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == number) {
                return i;
            }
        }              
        return -1;
    }
    
    public static int searchAlgorithmLinked(int number) {
        
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i) == number) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static void runTimes() {
        
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
        linkedList= FillLinkedList(linkedList);
        arrayList= FillArrayList(arrayList);    
        
        System.out.println("ArrayList    LinkedList  (MS)");    
        insertTest();
        deleteTest();
        deleteByValueTest();
        emptyListTest();      
        searchTest();
        binarySearchTest();
        
    }
    
    
    public static void main(String[] args) {
               
        runTimes();          
        
    }
    
}
