import java.util.*;

public class Mergesort
{
    public static int comparisons = 0;
    public static int[] run_mergesort(int[] input_array){
        if(input_array.length==1){
            return input_array;
        }
        int[] array_1 = new int[input_array.length/2];
        int[] array_2 = new int[((input_array.length+1)/2)];
        int[] return_array = new int[input_array.length];
        int a_1_index = 0;
        int a_2_index = 0;
        int return_a_index = 0;
        int i = 0;
        while(i < (input_array.length/2)){ 
            array_1[i] = input_array[i];
            ++i;
        }
        while(i < (input_array.length)){ 
            array_2[a_2_index] = input_array[i];
            ++a_2_index;
            ++i;
        }
        array_1 = Mergesort.run_mergesort(array_1);
        array_2 = Mergesort.run_mergesort(array_2);
        a_2_index = 0;
        while(return_a_index<return_array.length){
            ++comparisons;
            if(array_1[a_1_index] < array_2[a_2_index]){
                return_array[return_a_index] = array_1[a_1_index];
                ++a_1_index;
                if(a_1_index == array_1.length){
                    finish_filling_up_array(array_2, a_2_index, return_array, return_a_index);
                    break;
                }
            }
            else{
                return_array[return_a_index] = array_2[a_2_index];
                ++a_2_index;
                if(a_2_index == array_2.length){
                    finish_filling_up_array(array_1, a_1_index, return_array, return_a_index);
                    break;
                }
            }
            ++return_a_index;
        }
        input_array = return_array;
        return return_array;
    }

    public static void finish_filling_up_array(int[] source_array, int src_a_index, int[] dest_array, int dest_a_index){ 
        ++dest_a_index;
        while(src_a_index < source_array.length){
            dest_array[dest_a_index] = source_array[src_a_index];
            ++src_a_index;
            ++dest_a_index;
        }
    }
}
