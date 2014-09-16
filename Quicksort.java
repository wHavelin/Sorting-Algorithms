import java.util.*;

public class Quicksort
{
    public static int comparisons =0;
    static Random random_number_generator = new Random();
    public static int[] run_quicksort(int[] input_array, boolean randomize_pivot){
        if(input_array.length<10){
            InsertionSort.comparisons = 0;
            input_array = InsertionSort.run_insertionsort(input_array);
            comparisons += InsertionSort.comparisons;
            return input_array;
        }
        int[] left_array = new int[input_array.length-1];
        int left_array_last_index = 0;
        int[] right_array = new int[input_array.length-1];
        int right_array_last_index = 0;
        int pivot_count = 0;
        int pivot;
        if(randomize_pivot)
            pivot = input_array[random_number_generator.nextInt(input_array.length)];
        else
            pivot = input_array[0];
        boolean left_this_time = true;
        for(int i = 0; i < input_array.length; ++i){
            comparisons+=2;
            if(input_array[i] < pivot){
                left_array[left_array_last_index] = input_array[i];
                ++left_array_last_index;
                --comparisons;
            }
            else if(input_array[i] == pivot){
                ++pivot_count;
            }
            else{
                right_array[right_array_last_index] = input_array[i];
                ++right_array_last_index;
            }
        }
        int[] new_left_array = Arrays.copyOfRange(left_array,0, left_array_last_index);
        new_left_array = run_quicksort(new_left_array, randomize_pivot);
        int[] new_right_array = Arrays.copyOfRange(right_array,0, right_array_last_index);
        new_right_array = run_quicksort(new_right_array, randomize_pivot);
        for(int i = 0; i < new_left_array.length; ++i){
            input_array[i] = new_left_array[i];
        }
        for(int i = 0; i <pivot_count; ++i){
            input_array[new_left_array.length+i] = pivot;
        }
        for(int i = 0; i < new_right_array.length; ++i){
            input_array[new_left_array.length+pivot_count+i] = new_right_array[i];
        }
        return input_array;
    }
}
