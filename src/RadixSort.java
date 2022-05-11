import java.io.*;
import java.util.*;

public class RadixSort {

    
    public static void LSD(List<String> array, int index, char low, char high){

        int[] count = new int[(high - low) + 2];
        String[] temp  = new String[array.size()];
        Arrays.fill(count, 0);

        for (int i = 0; i < array.size(); i++){

            int d;

            if (array.get(i).length() - 1 < index)
                d = 0;
            else
                d = (array.get(i).charAt(index) - low ) + 1;
            
            count[d]++; 
        }

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        for (int i = array.size() - 1; i >= 0; i--){

            int d;

            if (array.get(i).length() - 1 < index)
                d = 0;
            else
                d = (array.get(i).charAt(index) - low ) + 1;

            temp[count[d]-1] = array.get(i);
            count[d]--; 

        }

        for (int i = 0; i < temp.length; i ++)
            array.set(i,temp[i]);
    }

    private static int getMaxLength(List<String> array){

        int maxlength = 0;

        for (int i = 0; i < array.size(); i++){
            if (array.get(i).length() - 1 > maxlength){
                maxlength = array.get(i).length() - 1;
            }
        }
        return maxlength;
    }

    public static void radixsort(List<String> array, char low, char high){
        int w = getMaxLength(array);
 
         for (int i = w; i >= 0; i--)
             LSD(array, i, low, high);
 
     }

    
}

