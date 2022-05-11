import java.util.Collections;
import java.util.List;

public class BubbleSort {

    public long sort(List<String> array) {
        long counter = 0;

        // assignment for i = 0
        counter ++;
        for (int i = 0; i < array.size(); i++) {

            /*
                Comparison + 1 for i < array.length
                Addition and assignment + 2 for i++
                Assignment + 1 for j = 0
            */
            counter += 4;

            for (int j = 0; j < array.size() - i - 1; j++) {

                /*
                    Comparison and subtraction + 2 for j < array.length - i - 1
                    Addition and assignment + 2 for i++
                    Method calling + 1 for array.length
                */
                counter += 5;

                /*
                    If s1 > s2, returns positive integer
                    If s1 < s2, returns negative integer
                    If s1 == s2, returns 0
                */
                if (array.get(j).compareTo(array.get(j + 1)) > 0) {
                    Collections.swap(array, j, j+1);

                    /*
                        Assignment + 3
                        Array reference + 4
                     */
                    counter += 7;
                }
                // Comparison and array reference + 1 + 2
                counter += 2;
            }

            // Just to keep me sane
            if (i % 1000 == 0) {
                System.out.println(i);
            }
        }

        return counter;
    }

    public long getWorstOperations(List<String> array) {
        System.out.println("Reversing array list");
        Collections.reverse(array);
        return sort(array);
    }
}
