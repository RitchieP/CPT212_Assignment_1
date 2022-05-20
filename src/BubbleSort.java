import java.util.Collections;
import java.util.List;

public class BubbleSort {

    public long sort(List<String> array) {
        long counter = 0;

        // assignment for i = 0
        counter ++;
        for (int i = 0; i < array.size() - 1; i++) {

            /*
                Comparison + 1 for i < array.size()
                Addition and assignment + 2 for i++
                Method calling +1 for array.size()
                Assignment + 1 for j = 0
            */
            counter += 5;

            for (int j = 0; j < array.size() - i - 1; j++) {

                /*
                    Comparison and subtraction + 2 for j < array.length - i - 1
                    Addition and assignment + 2 for i++
                    Method calling + 1 for array.size()
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
                    Method calling + 1 for Collections.swap()
                    Addition for j + 1
                     */
                    counter += 2;
                }
                /*
                Method calling + 3 for array.get(j).compareTo(array.get(j + 1))
                Comparison + 1 for > 0
                Addition for j + 1
                 */
                counter += 3;
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
