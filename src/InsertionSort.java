import java.util.Collections;
import java.util.List;

public class InsertionSort {

    public long sort(List<String> array) {
        long counter = 0;

        // assignment for i = 1
        counter ++;
        for (int i = 1; i < array.size(); i++) {

            /*
                Comparison + 1 for i < array.length
                Addition and assignment + 2 for i++
                Method calling + 1 for array.length
            */
            counter += 4;

            // Get the current element
            String key = array.get(i);
            counter++;
            // Get the element before
            int j = i - 1;
            counter += 2;

            while(j >= 0 && array.get(j).compareTo(key) > 0) {

                /*
                    Comparison + 3 for i >= 0 and array[j].compareTo(key) > 0 and AND operation
                    Array reference + 1
                 */
                counter += 4;
                /*
                    If the element before is greater than key, move
                    it up the array
                 */
                array.set(j + 1, array.get(j));
                /*
                    Array reference + 2
                    Assignment + 1
                 */
                counter += 3;
                j--;
                counter += 2;
            }
            array.set(j + 1, key);
            /*
                Array reference + 1
                Assignment + 1
                TODO: Is j + 1 counted as one primitive ops?
             */
            counter += 2;

            // Just to keep me sane
            if (i % 1000 == 0) {
                System.out.println(i);
            }
        }

        return counter;
    }

    public long getWorstOperation(List<String> array) {
        System.out.println("Reversing array list");
        Collections.reverse(array);
        return sort(array);
    }
}
