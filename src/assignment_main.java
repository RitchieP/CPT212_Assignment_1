import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class assignment_main {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        String[] array;

        int primitiveOps = 0;

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
        array = arr.toArray(new String[0]);
        primitiveOps = bubbleSort(array);
        System.out.println("Bubble Sort:\nNumber of primitive operations: " + primitiveOps);

        /* Printing out the array for validation
        for (String str : array) {
            System.out.println(str);
        }
         */
    }

    public static int bubbleSort(String[] array) {
        int counter = 0;

        // assignment for i = 0
        counter ++;
        for (int i = 0; i < array.length; i++) {

            /*
                Comparison + 1 for i < array.length
                Addition and assignment + 2 for i++
                Assignment + 1 for j = 0
            */
            counter += 4;

            for (int j = 0; j < array.length - i - 1; j++) {

                /*
                    Comparison and subtraction + 2 for j < array.length - i - 1
                    Addition and assignment + 2 for i++
                    TODO: Ask lecturer does array.length considered as one primitive operations
                */
                counter += 4;

                /*
                    If s1 > s2, returns positive integer
                    If s1 < s2, returns negative integer
                    If s1 == s2, returns 0
                */
                if(array[j].compareTo(array[j+1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                    /*
                        Assignment + 3
                        Array reference + 4
                     */
                    counter += 7;
                }
                // Comparison and array reference + 1 + 2
                counter += 2;
            }
        }
        return counter;
    }

    public int insertionSort(String[] array) {
        int counter = 0;
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
