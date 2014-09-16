

public class Selection_Sort
{
    public static int comparisons = 0;
    public static void sort(int[] input_array){
        comparisons = 0;
        int temp_int;
        int min_index;
        for(int i = 0; i < input_array.length; ++i){
            min_index = i;
            for(int x = i+1; x < input_array.length; ++x){
                if(input_array[x] < input_array[min_index])
                    min_index = x;
                ++comparisons;
            }
            if(min_index != i){
                temp_int = input_array[i];
                input_array[i] = input_array[min_index];
                input_array[min_index] = temp_int;
            }
        }
    }
}
