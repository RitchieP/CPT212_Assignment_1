import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuickSort {

    //counter to count primitive operations
    static long counter = 0;

    private int partition(List<String> array, int low, int high){

        // generate random element pivot  
        int pivotIndex = new Random().nextInt(high - low) + low;
        String pivot = array.get(pivotIndex);
        Collections.swap(array, pivotIndex, high);

        int i = (low - 1); // Smaller element index

        /*
        Assignment +3
        Method calling +3 for Random().nextInt() & array.get() & swap()
        Subtraction +2
        Addition +1
         */
        counter += 9;

        // Assignment +1 for int j = low
        counter ++; 
        for (int j = low; j <= high - 1; j++){

            /*
            Comparison +1 for j <= (high - 1) 
            Addition and Assignment +2 for j++
            Subtraction +1 for high - 1
            */
            counter += 4; 

            /* 
            Comparison +1
            Method calling +1 for array.get()
            */
            counter += 2; 
            // If current element is smaller than the pivot  
            if (array.get(j).compareTo(pivot) < 0)  
            {  
                i++; // increment index of smaller element  
                Collections.swap(array, i, j);

                /*
                Addition and assignment +2 for i++
                Method calling +1 for swap()
                 */
                counter += 3;
            }  
        }  

        /*
        Method calling +1 for swap()
        Addition +2 for two (i + 1)
        Return method +1
        */
        counter += 4;

        Collections.swap(array, i + 1, high);
        return (i + 1);
    }

    public long quicksort(List<String> array, int low, int high){

        // Comparison + 1 
        counter ++;
        if (low < high){     
        
        int lp = partition(array, low, high);

        quicksort(array, low, lp - 1);
        quicksort(array, lp + 1, high);

        /*
        Assignment +1
        Method calling +3
        Addition and subtraction +2
        */
        counter += 7;
        }

        return counter;
    }

    public long getWorstOperations(List<String> array) {
        System.out.println("Reversing array list");
        Collections.reverse(array);
        return quicksort(array, 0, array.size() - 1);
    }


}