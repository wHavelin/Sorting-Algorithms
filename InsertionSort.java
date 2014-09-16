
public class InsertionSort
{
    public static int comparisons = 0;
    public static int[] run_insertionsort(int[] input_array){
        comparisons = 0;
        if(input_array.length<2)
            return input_array;
        int[] return_array = new int[0];
        for(int i = 0; i < input_array.length; ++i){
            return_array = insert_into_sorted_array(input_array[i], return_array);
        }
        return return_array;
    }
    
    public static int[] insert_into_sorted_array(int new_int, int[] source_array){
        int[] return_array = new int[source_array.length+1];
        int i;
        for(i = 0; i < source_array.length; ++i){
            if(new_int<=source_array[i]){
                return_array[i] = new_int;
                ++i;
                while(i < source_array.length+1){
                    return_array[i] = source_array[i-1];
                    ++i;
                }
            }
            else{
                return_array[i] = source_array[i];
            }
            ++comparisons;
        }
        if(i==source_array.length){
            return_array[return_array.length-1] = new_int;
        }
        return return_array;
    }
}
