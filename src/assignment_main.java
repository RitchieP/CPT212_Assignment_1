import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class assignment_main {
    public static void main(String[] args) {


        /*
        inputList will be constant after reading from text file
        arrList will change based on the size needed for sorting
         */
        List<String> inputList = new ArrayList<>();
        List<String> arrList = new ArrayList<>();
        int size;

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
                    inputList.add(word);
                }
                word = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        This for loop is used to obtain number of operations for different input sizes.
        The input size will increment by 5000
        Eg: Best case when input = 1, 5001, 10001 and so on.
         */
        for (int c = 45001; c < inputList.size(); c += 5000) {

            try {
                arrList = inputList.subList(0, c);
                size = c;
            } catch (IndexOutOfBoundsException e) {
                /*
                If the index is out of bounds, then that means the slicing index is over the length of the input list.
                We will just take the original input list
                 */
                arrList = inputList;
                size = inputList.size();
            }

            System.out.println("*******************************************");
            System.out.println("Sorting for list of size of " + size);
            System.out.println("*******************************************\n");


            // Bubble Sort
            System.out.println("===================");
            System.out.println("Bubble Sort");
            System.out.println("===================\n");
            BubbleSort bubbleSort = new BubbleSort();

            System.out.println("Sorting to find average case...");
            // Find average case
            averageOps = 0; // Reset the average variable first
            for (int i = 0; i < timesToShuffle; i++) {
                 /*
                 The array will be shuffled for five times to get the average case
                  */
                Collections.shuffle(arrList);
                primitiveOps = bubbleSort.sort(arrList);
                System.out.println("Number of operations for " + (i + 1) + " time: " + primitiveOps);
                averageOps += primitiveOps;
            }
            averageOps /= timesToShuffle;
            System.out.println("The average number of primitive operations for Bubble Sort: " + averageOps + "\n");

            // Finding the best case
            System.out.println("Sorting to find best case...");
            bestOps = bubbleSort.sort(arrList);
            System.out.println("The best number of primitive operations for Bubble Sort: " + bestOps + "\n");

         /*
         Finding the worst case
         We will take the sorted array and transform to array list, and reverse it to get the worst case
          */
            System.out.println("Sorting for worst case...");
            worstOps = bubbleSort.getWorstOperations(arrList);
            System.out.println("The worst number of primitive operations for Bubble Sort: " + worstOps + "\n");


            // Insertion Sort
            System.out.println("===================");
            System.out.println("Insertion Sort");
            System.out.println("===================\n");
            // Reset average operations value
            averageOps = 0;
            InsertionSort insertionSort = new InsertionSort();

            System.out.println("Sorting to find average case");
            for (int i = 0; i < timesToShuffle; i++) {
                Collections.shuffle(arrList);
                primitiveOps = insertionSort.sort(arrList);
                System.out.println("Number of operations for " + (i + 1) + " time: " + primitiveOps);
                averageOps += primitiveOps;
            }
            averageOps /= timesToShuffle;
            System.out.println("Number of average operations: " + averageOps + "\n");

            // Best case
            System.out.println("Sorting to fnd best case");
            bestOps = insertionSort.sort(arrList);
            System.out.println("The best number of primitive operations for Bubble Sort: " + bestOps + "\n");

            // Finding worst case
            System.out.println("Sorting for worst case...");
            worstOps = insertionSort.getWorstOperation(arrList);
            System.out.println("The worst number of primitive operations for Bubble Sort: " + worstOps + "\n");


            // Quick Sort
            System.out.println("===================");
            System.out.println("Quick Sort");
            System.out.println("===================\n");
            // Reset average operations value
            averageOps = 0;
            QuickSort qsort = new QuickSort();

            System.out.println("Sorting to find average case...");
            // Find average case
            for (int i = 0; i < timesToShuffle; i++) {
                Collections.shuffle(arrList);
                primitiveOps = qsort.quicksort(arrList, 0, arrList.size() - 1);
                System.out.println("Number of operations for " + (i + 1) + " time: " + primitiveOps);
                averageOps += primitiveOps;
            }
            averageOps /= timesToShuffle;
            System.out.println("The average number of primitive operations for Quick Sort: " + averageOps + "\n");

            // Finding the best case
            System.out.println("Sorting to find best case...");
            bestOps = qsort.quicksort(arrList, 0, arrList.size() - 1);
            System.out.println("The best number of primitive operations for Quick Sort: " + bestOps + "\n");

            // Finding the worst case
            System.out.println("Sorting for worst case...");
            worstOps = qsort.getWorstOperations(arrList);
            System.out.println("The worst number of primitive operations for Quick Sort: " + worstOps + "\n");


            //Radix Sort
            System.out.println("===================");
            System.out.println("Radix Sort");
            System.out.println("===================\n");
            //Reset average operations value
            averageOps = 0;
            RadixSort rsort = new RadixSort();

            System.out.println("Sorting to find average case");
            for (int i = 0; i < timesToShuffle; i++) {
                Collections.shuffle(arrList);
                primitiveOps = rsort.radixsort(arrList, '\'', '™');
                System.out.println("Number of operations for " + (i + 1) + " time: " + primitiveOps);
                averageOps += primitiveOps;
            }
            averageOps /= timesToShuffle;
            System.out.println("Number of average operations: " + averageOps + "\n");

            // Best case
            System.out.println("Sorting to fnd best case");
            bestOps = rsort.radixsort(arrList, '\'', '™');
            System.out.println("The best number of primitive operations for Radix Sort: " + bestOps + "\n");

            // Finding worst case
            System.out.println("Sorting for worst case...");
            worstOps = rsort.getWorstOperations(arrList);
            System.out.println("The worst number of primitive operations for Radix Sort: " + worstOps + "\n");
        }
    }

}
