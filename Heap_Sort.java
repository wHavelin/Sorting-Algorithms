
public class Heap_Sort
{
    public static int heap_size = 0;
    public static int comparisons = 0;
    
    public static void sort(int[] input_array){
        comparisons = 0;
        build_max_heap(input_array);
        for(int i = input_array.length-1; i >= 1; --i){
            int temp_int = input_array[i];
            input_array[i] = input_array[0];
            input_array[0] = temp_int;
            --heap_size;
            max_heapify(input_array, 0);
        }
    }

    public static void max_heapify(int[] input_array, int i){
        int left_index = left(i);
        int right_index = right(i);
        int max_index;
        if(left_index <= heap_size && input_array[left_index] > input_array[i])
            max_index = left_index;
        else
            max_index = i;
        if(right_index <= heap_size && input_array[right_index] > input_array[max_index])
            max_index = right_index;
        comparisons+=2;
        if(max_index != i){
            int temp_int = input_array[i];
            input_array[i] = input_array[max_index];
            input_array[max_index] = temp_int;
            max_heapify(input_array, max_index); // this is no longer the index of the max element
        }
    }

    public static void build_max_heap(int[] input_array){
        heap_size = input_array.length-1;
        for(int i = input_array.length/2; i >= 0; --i){
            max_heapify(input_array, i);
        }
    }
    
    public static int parent(int i){
        return i/2;
    }

    public static int left(int i){
        return 2 * i;
    }

    public static int right(int i){
        return (2 * i) + 1;
    }
}
