import java.util.Collections;
import java.util.List;

public class InsertionSort {

    public long sort(List<String> array) {
        long counter = 0;

        // assignment for i = 1
        counter ++;
        for (int i = 1; i < array.size(); i++) {

            /*
                Comparison + 1 for i < array.size()
                Addition and assignment + 2 for i++
                Method calling + 1 for array.size()
            */
            counter += 4;

            // Get the current element
            String key = array.get(i);
            counter += 2; // For assignment and method calling
            // Get the element before
            int j = i - 1;
            counter += 2;

            while(j >= 0 && array.get(j).compareTo(key) > 0) {

                /*
                    Comparison + 3 for i >= 0 and array[j].compareTo(key) > 0 and AND operation
                    Method calling + 2 for array.get(j).compareTo()
                 */
                counter += 5;
                /*
                    If the element before is greater than key, move
                    it up the array
                 */
                array.set(j + 1, array.get(j));
                /*
                    Method calling + 2 for array.set and array.get
                    Addition + 1 for j + 1
                 */
                counter += 3;
                j--;
                counter += 2;
            }
            array.set(j + 1, key);
            /*
                Method calling + 1 for array.set()
                Addition + 1 for j + 1
             */
            counter += 2;
        }

        return counter;
    }

    public long getWorstOperation(List<String> array) {
        System.out.println("Reversing array list");
        Collections.reverse(array);
        return sort(array);
    }
}
