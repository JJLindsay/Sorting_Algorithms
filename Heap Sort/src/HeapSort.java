/**
 * Created by JON-JULIUS on 2/25/2015.
 */
public class HeapSort {

    public static <E extends Comparable<E>> void heapSort(E[] list)
    {
        //create a heap of integers
        Heap<E> heap = new Heap<E>();

        //add elements to the heap
        for (int y = 0; y < list.length; y++)
        {
            heap.add(list[y]);
        }

        //remove elements from the heap
        for (int x = list.length-1; x >= 0; x--)
        {
            list[x] = heap.remove();
        }
    }

    //a test method
    public static void main(String[] args)
    {
        Integer[] list = {-44, -5, -3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(list);
        for (int t = 0; t < list.length; t++)
        {
            System.out.print(list[t] + " ");
        }
    }
}
