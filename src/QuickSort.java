public class QuickSort {

    //counter to count primitive operations
    static long counter = 0;

    private String[] array;

    public QuickSort(String[] array) {
        this.array = array;
    }

    private void swap(String[] array, int index1, int index2){

        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp; 

        /*
        Assignment +3
        Array reference +4
        */
        counter += 7;
        // return counter;
    }

    private int partition(String[] array, int low, int high){

        String pivot = array[high]; // choose last element pivot  
        int i = (low - 1); // Smaller element index

        /*
        Assignment +2
        Array reference +1
        Subtraction +1
         */
        counter += 4;

        // Assignment +1 for int j = low
        counter ++; 
        for (int j = low; j <= high - 1; j++)  
        {  
            /*
            Comparison +1 for j <= (high - 1) 
            Addition and Assignment +2 for j++
            Subtraction +1 for high - 1
            */
            counter += 4; 

            /* 
            Comparison +1
            Array reference +1
            */
            counter += 2; 
            // If current element is smaller than the pivot  
            if (array[j].compareTo(pivot) < 0)  
            {  
                i++; // increment index of smaller element  
                swap(array, i, j);

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

        swap(array, i + 1, high);
        return (i + 1);
    }

    long quicksort(String[] array, int low, int high){

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


}