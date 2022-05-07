import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;

public class assignment_main {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        String[] array;

        long primitiveOps = 0;

        /*
            Reading the words from the file into an array list, we will convert the array
            list later into an array.
        */
        try (BufferedReader br = new BufferedReader(new FileReader("src/wordList.txt"))) {
            String word = br.readLine();

            while (word != null) {
                arr.add(word);
                word = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Converting the array list into an array
        // Collections.shuffle(arr);
        array = arr.toArray(new String[0]);
        BubbleSort bubbleSort = new BubbleSort(array);
        primitiveOps = bubbleSort.sort();
        System.out.println("Bubble Sort:\nNumber of primitive operations: " + primitiveOps);

        // array = arr.toArray(new String[0]);
        // primitiveOps = insertionSort(array);
        // System.out.println("Insertion Sort:\nNumber of primitive operations: " + primitiveOps);
        /* Printing out the array for validation */
        /*for (String str : array) {
            System.out.println(str);
        }*/

        //WEIRU//
        //QUICKSORT
        /*
        array = arr.toArray(new String[0]);
        QuickSort qsort = new QuickSort(array);
        primitiveOps = qsort.quicksort(array, 0, array.length-1);
        System.out.println("Quick Sort:\nNumber of primitive operations: " + primitiveOps);
        */
        /*
        // Printing out the array for validation 
        for (String str : array) {
            System.out.println(str);
        }*/

    }

    public static long insertionSort(String[] array) {
        long counter = 0;

        // assignment for i = 1
        counter ++;
        for (int i = 1; i < array.length; i++) {

            /*
                Comparison + 1 for i < array.length
                Addition and assignment + 2 for i++
                Method calling + 1 for array.length
            */
            counter += 4;

            // Get the current element
            String key = array[i];
            counter++;
            // Get the element before
            int j = i - 1;
            counter += 2;

            while(j >= 0 && array[j].compareTo(key) > 0) {

                /*
                    Comparison + 3 for i >= 0 and array[j].compareTo(key) > 0 and AND operation
                    Array reference + 1
                 */
                counter += 4;
                /*
                    If the element before is greater than key, move
                    it up the array
                 */
                array[j + 1] = array[j];
                /*
                    Array reference + 2
                    Assignment + 1
                 */
                counter += 3;
                j--;
                counter += 2;
            }
            array[j + 1] = key;
            /*
                Array reference + 1
                Assignment + 1
                TODO: Is j + 1 counted as one primitive ops?
             */
            counter += 2;
        }

        return counter;
    }

    public int quickSort(String[] array) {
        int counter = 0;



        
        return counter;
    }

    public int radixSort(String[] array) {
        int counter = 0;
        return counter;
    }
}
