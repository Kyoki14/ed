
package p5;

import java.util.ArrayList;
import java.util.Random;

public class Sort {
    
    private static final int DIVISOR = 1000000;
    private static ArrayList<Integer> list;
    
    private static double startTime;
    private static double totalTimeBubble;
    private static double totalTimeSelection;
    private static double totalTimeInsertion;
    private static double totalTimeQuick;
    private static double totalTimeMerge;
    private static double totalTimeBinary;
    private static double totalTimeSequential;

    public static void bubbleSort() {
        for(int i = list.size() - 1; i >= 0; i--) {
            for(int j = 0; j < i; j++) {
                if( list.get(i) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, j + 1);
                    list.set(j + 1, temp);
                }
            }
        }
    }
    
    public static void selectionSort() {
        
        for (int i = 0; i < list.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < list.size(); j++)
                if (list.get(j) < list.get(index))
                    index = j;
      
            int smallerNumber = list.get(index); 
            list.set(index, i);
            list.set(i, smallerNumber);
        }
    }
    
    public static void insertionSort() {
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            for (int j = i - 1; j >= 0 && temp < list.get(j); j++) {
                list.set(j + 1, j);
                list.set(j + 1, temp);
            }
                       
        }
    }
    
    public static void quickSort(int izq, int der) {
        
        int pivote=list.get(izq); // tomamos primer elemento como pivote
        int i=izq; // i realiza la búsqueda de derecha a izquierda
        int j=der; // j realiza la búsqueda de izquierda a derecha
        int aux;

        while(i<j){ // mientras no se crucen las búsquedas           
           while(list.get(i)<=pivote && i<j) i++; // busca elemento mayor que pivote
           while(list.get(j)>pivote) j--;         // busca elemento menor que pivote
           if (i<j) {                             // si no se han cruzado     
               aux= list.get(i);                  // los intercambia
               list.set(i, j);
               list.set(j, aux);
           }
        }
        list.set(izq, j); // se coloca el pivote en su lugar de forma que tendremos
        list.set(j, pivote);  // los menores a su izquierda y los mayores a su derecha

        if(izq<j-1)
           quickSort(izq,j-1); // ordenamos subarray izquierdo
        if(j+1 <der)
           quickSort(j+1,der); // ordenamos subarray derecho
    }
    
    public static void merge(int izq, int m, int der){
       
        int i, j, k;
        int [] B = new int[list.size()]; //array auxiliar
        for (i=izq; i<=der; i++) //copia ambas mitades en el array auxiliar
            B[i]=list.get(i);

        i=izq; j=m+1; k=izq;
        while (i<=m && j<=der) //copia el siguiente elemento más grande
            if (B[i]<=B[j])
                list.set(k++, B[i++]);
            else
                list.set(k++, B[j++]);
             while (i<=m)              //copia los elementos que quedan de la
                list.set(k++, B[i++]); //primera mitad (si los hay)
    }
    
    public static void mergeSort(int izq, int der){
        if (izq<der){
            int m=(izq+der)/2;
            mergeSort(izq, m);
            mergeSort(m+1, der);
            merge(izq, m, der);
        }
    }
   
    
    public static boolean binarySearch(int key) {

        int size = list.size();

        int low = 0;
        int high = size - 1;
          
         while(high >= low) {
            int middle = (low + high) / 2;
            if(list.get(middle) == key) {
                return true;
            }
            if(list.get(middle) < key) {
                low = middle + 1;
            }
            if(list.get(middle) > key) {
                high = middle - 1;
            }
       }
       return false;
    }
    
    public static boolean sequentialSearch(int key) {
        for (int i = 0; i < list.size(); i++) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }
    
    public static void randomList() {
        list = new ArrayList<>();
        Random rn = new Random();
        
        for (int i = 0; i < 1000; i++) {
            list.add(i * i * i % 100);
        }
    }
    
    public static void sortedAscendantList() {
        list = new ArrayList<>();
        
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    }
    
    public static void sortedDescendantList() {
        list = new ArrayList<>();
        
        for (int i = 1000; i > 0; i--) {
            list.add(i);
        }
    }
    
    public static void sameValueList() {
        list = new ArrayList<>();
        
        for (int i = 0; i < 1000; i++) {
            list.add(10);
        }
    }
    
    public static void randomTest() {
        randomList();      
        startTime = System.nanoTime();
        bubbleSort();
        totalTimeBubble = (System.nanoTime() - startTime) / DIVISOR;
        randomList();  
        startTime = System.nanoTime();
        selectionSort();
        totalTimeSelection = (System.nanoTime() - startTime) / DIVISOR;  
        randomList();  
        startTime = System.nanoTime();
        insertionSort();
        totalTimeInsertion = (System.nanoTime() - startTime) / DIVISOR;
        randomList();  
        startTime = System.nanoTime();
        quickSort(0, list.size() - 1);
        totalTimeQuick = (System.nanoTime() - startTime) / DIVISOR;
        randomList();  
        startTime = System.nanoTime();
        mergeSort(0, list.size() - 1 );
        totalTimeMerge = (System.nanoTime() - startTime) / DIVISOR;  
        
        
        System.out.println(totalTimeBubble + "   " + totalTimeSelection + "    "
                + totalTimeInsertion + "     " + totalTimeQuick + "     " 
                + totalTimeMerge + "    Lista aleatoria");
    }
    
    public static void ascendandTest() {
        sortedAscendantList();      
        startTime = System.nanoTime();
        bubbleSort();
        totalTimeBubble = (System.nanoTime() - startTime) / DIVISOR;
        sortedAscendantList();  
        startTime = System.nanoTime();
        selectionSort();
        totalTimeSelection = (System.nanoTime() - startTime) / DIVISOR;  
        sortedAscendantList();  
        startTime = System.nanoTime();
        insertionSort();
        totalTimeInsertion = (System.nanoTime() - startTime) / DIVISOR;
        sortedAscendantList();  
        startTime = System.nanoTime();
        quickSort(0, list.size() - 1);
        totalTimeQuick = (System.nanoTime() - startTime) / DIVISOR;
        sortedAscendantList();  
        startTime = System.nanoTime();
        mergeSort(0, list.size() - 1 );
        totalTimeMerge = (System.nanoTime() - startTime) / DIVISOR;  
        
        System.out.println(totalTimeBubble + "   " + totalTimeSelection + "    "
                + totalTimeInsertion + "     " + totalTimeQuick + "     " 
                + totalTimeMerge + "    Lista creciente");
    }
   
    public static void descendandTest() {
        sortedDescendantList();      
        startTime = System.nanoTime();
        bubbleSort();
        totalTimeBubble = (System.nanoTime() - startTime) / DIVISOR;
        sortedDescendantList();  
        startTime = System.nanoTime();
        selectionSort();
        totalTimeSelection = (System.nanoTime() - startTime) / DIVISOR;  
        sortedDescendantList();  
        startTime = System.nanoTime();
        insertionSort();
        totalTimeInsertion = (System.nanoTime() - startTime) / DIVISOR;
        sortedDescendantList();  
        startTime = System.nanoTime();
        quickSort(0, list.size() - 1);
        totalTimeQuick = (System.nanoTime() - startTime) / DIVISOR;
        sortedDescendantList();  
        startTime = System.nanoTime();
        mergeSort(0, list.size() - 1 );
        totalTimeMerge = (System.nanoTime() - startTime) / DIVISOR;  
        
        System.out.println(totalTimeBubble + "   " + totalTimeSelection + "    "
                + totalTimeInsertion + "     " + totalTimeQuick + "     " 
                + totalTimeMerge + "    Lista decreciente");
    }
    
      public static void sameValueTest() {
        sameValueList();      
        startTime = System.nanoTime();
        bubbleSort();
        totalTimeBubble = (System.nanoTime() - startTime) / DIVISOR;
        sameValueList();  
        startTime = System.nanoTime();
        selectionSort();
        totalTimeSelection = (System.nanoTime() - startTime) / DIVISOR;  
        sameValueList();  
        startTime = System.nanoTime();
        insertionSort();
        totalTimeInsertion = (System.nanoTime() - startTime) / DIVISOR;
        sameValueList();  
        startTime = System.nanoTime();
        quickSort(0, list.size() - 1);
        totalTimeQuick = (System.nanoTime() - startTime) / DIVISOR;
        sameValueList();  
        startTime = System.nanoTime();
        mergeSort(0, list.size() - 1 );
        totalTimeMerge = (System.nanoTime() - startTime) / DIVISOR;  
        
        System.out.println(totalTimeBubble + "   " + totalTimeSelection + "    "
                + totalTimeInsertion + "     " + totalTimeQuick + "     " 
                + totalTimeMerge + "    Lista mismo valor");
    }
      
    public static boolean runTest() {
        
        sortedAscendantList();
        if (list.get(500) != 500)
            return false;
        
        sortedDescendantList();
        if (list.get(500) != 500)
            return false;
        
        sameValueList();
        if (list.get(500) != 10)
            return false;       
        
        return true;
    }
    
    public static void runTimes() {
        
        if (runTest()) {
            System.out.println("Bubble sort  Selection sort  Insertion sort  Quick sort  Merge sort (MS)");
            randomTest(); 
            ascendandTest();
            descendandTest();
            sameValueTest();    
        }                   
    }

     public static void main(String[] args) {
               
        runTimes();              
    }
            
}

