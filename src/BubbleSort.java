public class BubbleSort {
    private String[] array;
    private long averageOperations;
    private long bestOperations;
    private long worstOperations;

    public BubbleSort(String[] array) {
        this.array = array;
    }

    public long sort() {
        long counter = 0;

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
                    Method calling + 1 for array.length
                */
                counter += 5;

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


}
