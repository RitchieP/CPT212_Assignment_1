import java.util.*;

public class RadixSort {

    //counter to count primitive operations
    static long counter = 0;

    public void LSD(List<String> array, int index, char low, char high){

        int[] count = new int[(high - low) + 2]; //Create a counting array to calcul
        String[] temp  = new String[array.size()];
        Arrays.fill(count, 0);

        /*
        Assignment +2
        Subtraction & Addition + 2 for (high - low) 
        Method calling +2 for array.size() and Array.fill() 
        */
        counter += 6;

        //Assignment +1 for int i = 0
        counter ++;
        for (int i = 0; i < array.size(); i++){

            /*
            Comparison +1 for i < array.size()
            Addition and Assignment +2 for i++
            Method calling +1 for array.size()
            */
            counter += 4;

            int d;

            /*
            Comparison +1
            Method calling +2 for get() and length()
            Subtraction + 1
            */
            counter += 4;
            if (array.get(i).length() - 1 < index){
                
                d = 0;

                // Assignment +1
                counter ++;
            }
            else{

                d = (array.get(i).charAt(index) - low ) + 1;

                /*
                Assignment +1
                Method calling + 2 for get() and charAt()
                Addition and Subtraction +2
                */
                counter += 5;
            }

            count[d]++; 

            /*
            Indexing into array +1
            Addition and assignment +2
            */
            counter += 3;

        }


        //Assignment +1 for i = 1
        counter ++;
        for (int i = 1; i < count.length; i++){

            /*
            Comparison +1 for i < count.length
            Method calling +1
            Addition and Assignment +2 for i++
            */
            counter += 4; 


            count[i] += count[i - 1];

            /*
            Indexing into array +3 for count[i] = count[i] + count[i - 1]
            Assignment +1
            Addition +1
            Subtratction +1 for i - 1
            */
            counter += 6;
        }

        /*
        Assignment +1 for i = array.size() - 1
        Method calling +1 for size()
        Subtraction + 1 
        */
        counter += 3;
        for (int i = array.size() - 1; i >= 0; i--){

            /*
            Comparison +1 for i >= 0
            Subtraction and Assignment +2 for i--
            */
            counter += 3;

            int d;

            /*
            Comparison +1
            Method calling +2 for get() and length()
            Subtraction + 1
            */
            counter += 4;
            if (array.get(i).length() - 1 < index){
                
                d = 0;

                // Assignment +1
                counter ++;
            }
            else{

                d = (array.get(i).charAt(index) - low ) + 1;

                /*
                Assignment +1
                Method calling + 2 for get() and charAt()
                Addition and Subtraction +2
                */
                counter += 5;
            }

            temp[count[d]-1] = array.get(i);
            count[d]--; 

            /*
            Indexing into array +3
            Method calling +1 for get()
            Subtraction +1 for count[d] - 1
            Subtraction and Assignment +2 for count[d]--
            */
            counter += 7;

        }

        //Assignment +1 for int i = 0
        counter ++;
        for (int i = 0; i < temp.length; i ++){

            /*
            Comparison +1 for i < temp.length
            Method calling +1 for temp.length
            Addition and Assignment +2 for i++
            */
            counter += 4;

            array.set(i,temp[i]);

            /*
            Method calling +1 for set()
            Indexing into array +1 for temp[i]
            */
            counter += 2;
        }
    }

    private int getMaxLength(List<String> array){

        int maxlength = 0;

        //Assignment +2 for maxlength = 0 and i = 0
        counter += 2;
        for (int i = 0; i < array.size(); i++){

            /*
            Comparison +1 for i < array.size()
            Addition and Assignment +2 for i++
            Method calling +1 for array.size()
            */
            counter += 4;

            /*
            Comparison +1 for array.get(i).length() - 1 > maxlength
            Method calling +2 for get() and length()
            Subtraction + 1
            */
            counter += 4;
            if (array.get(i).length() - 1 > maxlength){

                maxlength = array.get(i).length() - 1;

                /*
                Assignment +1
                Method calling +2 for get() and length()
                Subtraction + 1
                */
                counter += 4;
            }
        }

        //Return method +1
        counter ++;
        return maxlength;
    }

    public long radixsort(List<String> array, char low, char high){
        
        int w = getMaxLength(array);

        //Assignment +2 for w = getMaxLength(array) and i = w
        counter += 2;
 
         for (int i = w; i >= 0; i--){

            LSD(array, i, low, high);

            /*
            Comparison +1
            Assignment and Subtraction +2 for i--
            Method calling +1
            */
            counter += 4;
         }

         return counter;

     }

     public long getWorstOperations(List<String> array) {
        System.out.println("Reversing array list");
        Collections.reverse(array);
        return radixsort(array, '\'', '™');
    }

    
}

