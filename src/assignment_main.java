import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class assignment_main {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        String[] array;

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

        /* Printing out the elements of the array to validate
        for (String str : array) {
            System.out.println(str);
        }
        */
    }

    public int bubbleSort(String[] array) {
        int counter = 0;
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
