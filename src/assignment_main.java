import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class assignment_main {
    public static void main(String[] args) {
        List<String> arrList = new ArrayList<>();

        int timesToShuffle = 5;
        long primitiveOps, averageOps = 0, bestOps, worstOps;
        /*
            Reading the words from the file into an array list, we will convert the array
            list later into an array.
        */
        try (BufferedReader br = new BufferedReader(new FileReader("src/wordList.txt"))) {
            String word = br.readLine();

            while (word != null) {
                // Filter words with non-ASCII characters
                if(StandardCharsets.US_ASCII.newEncoder().canEncode(word)) {
                    arrList.add(word);
                }
                word = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // // Bubble Sort
        // System.out.println("Bubble Sort\n");
        // BubbleSort bubbleSort = new BubbleSort();

        // System.out.println("Sorting to find average case...");
        // // Find average case
        // for (int i = 0; i < timesToShuffle; i++) {

        //     /*
        //     The array will be shuffled for five times to get the average case
        //      */
        //     System.out.println("Sorting for " + i + " times.");
        //     Collections.shuffle(arrList);
        //     primitiveOps = bubbleSort.sort(arrList);
        //     System.out.println("Number of operations for " + (i+1) + " time: " + primitiveOps);
        //     averageOps += primitiveOps;
        // }
        // averageOps /= timesToShuffle;
        // System.out.println("The average number of primitive operations for Bubble Sort: " + averageOps);

        // // Finding the best case
        // System.out.println("Sorting to find best case...");
        // bestOps = bubbleSort.sort(arrList);
        // System.out.println("The best number of primitive operations for Bubble Sort: " + bestOps);

        // /*
        // Finding the worst case
        // We will take the sorted array and transform to array list, and reverse it to get the worst case
        //  */
        // System.out.println("Sorting for worst case...");
        // worstOps = bubbleSort.getWorstOperations(arrList);
        // System.out.println("The worst number of primitive operations for Bubble Sort: " + worstOps);
        

        // // Insertion Sort
        // System.out.println("Insertion Sort\n");
        // // Reset average operations value
        // averageOps = 0;
        // InsertionSort insertionSort = new InsertionSort();

        // System.out.println("Sorting to find average case");
        // for (int i = 0; i < timesToShuffle; i++) {
        //     Collections.shuffle(arrList);
        //     primitiveOps = insertionSort.sort(arrList);
        //     System.out.println("Number of operations for " + (i+1) + " time: " + primitiveOps);
        //     averageOps += primitiveOps;
        // }
        // averageOps /= timesToShuffle;
        // System.out.println("Number of average operations: " + averageOps);

        // // Best case
        // System.out.println("Sorting to fnd best case");
        // bestOps = insertionSort.sort(arrList);
        // System.out.println("The best number of primitive operations for Bubble Sort: " + bestOps);

        // // Finding worst case
        // System.out.println("Sorting for worst case...");
        // worstOps = insertionSort.getWorstOperation(arrList);
        // System.out.println("The worst number of primitive operations for Bubble Sort: " + worstOps);

        //WEIRU//
        // Quick Sort
        // System.out.println("Quick Sort\n");
        // QuickSort qsort = new QuickSort();
        // primitiveOps = qsort.quicksort(arrList, 0, arrList.size()-1);

        // System.out.println("Sorting to find average case...");
        // // Find average case
        // for (int i = 0; i < timesToShuffle; i++) {

        //     /*
        //     The array will be shuffled for five times to get the average case
        //      */
        //     System.out.println("Sorting for " + i + " times.");
        //     Collections.shuffle(arrList);
        //     primitiveOps = qsort.quicksort(arrList, 0, arrList.size()-1);
        //     System.out.println("Number of operations for " + (i+1) + " time: " + primitiveOps);
        //     averageOps += primitiveOps;
        // }
        // averageOps /= timesToShuffle;
        // System.out.println("The average number of primitive operations for Quick Sort: " + averageOps);

        // // Finding the best case
        // System.out.println("Sorting to find best case...");
        // bestOps = qsort.quicksort(arrList, 0, arrList.size()-1);
        // System.out.println("The best number of primitive operations for Quick Sort: " + bestOps);

        /*
        Finding the worst case
        We will take the sorted array and transform to array list, and reverse it to get the worst case
         */
        // System.out.println("Sorting for worst case...");
        // worstOps = qsort.getWorstOperations(arrList);
        // System.out.println("The worst number of primitive operations for Bubble Sort: " + worstOps);

        //Radix Sort
        System.out.println("Radix Sort\n");
        RadixSort.radixsort(arrList, '\'','™');
        // for (String str : arrList) {
        //     System.out.println(str);
        // }
        
    }

}
