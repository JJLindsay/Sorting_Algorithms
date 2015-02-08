package quickSort;

/**
 * Class: QuickSort.java
 * @author JJ Lindsay
 * @version 1.0
 * Written: Feb 7, 2015
 *
 * This class represents a Quick sort algorithm
 *
 * Purpose: To demonstrate how to sort data using quick sort which finds a pivot by selecting the first
 * element of a list and sorting the list into elements higher and lower than the pivot. this is repeated,
 * making the list smaller each time until the list is sorted.
 */
public class QuickSort
{
	public static void quickSort(int[] list)
	{
		quickSort(list, 0, list.length-1);		
	}
	
	//first is where the list starts
	//last is where the list ends
	public static void quickSort(int[] list, int first, int last)
	{
		//is the list last position index greater than the list first position index
		if (last > first)
		{
			//picks a random number for the pivot
			int pivotNum = partition(list, first, last);
			//Everything below the pivot is sorted and not including the pivot
			quickSort(list, first, pivotNum-1);
			//Everything above the pivot is sorted and not including the pivot
			quickSort(list, pivotNum+1 ,last);
		}
	}
	
	public static int partition(int[] list, int first, int last)
	{
		int pivot = list[first];
		int low = first +1;
		int high = last;
		
		//is the low index less than the high index 
		while (low < high)
		{
			//is the low value less than the list[first]
			while (low <= high && list[low] <= pivot)
			{
				//raise the low index up one
				low++;
			}
			
			//is the high value > list[first]
			while (low <= high && list[high] > pivot)
			{
				//move the high index down one
				high--;
			}
			
			//is the high index greater than the low index
			if (high > low)
			{
				//swap high an low index values
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}			
		}
		
		//is high value >= list[first]
		while(high > first && list[high] >= pivot)
		{
			//lower the high index
			high--;
		}
		
		//if list[first] > high value
		if (pivot > list[high])
		{
			//swap list[high] and list[first]
			list[first] = list[high];
			list[high] = pivot;
			return high; //the new index for the original list[fist]
		}
		else
		{
			//return list[first], unchanged
			return first;
		}
	}
	
	public static void main(String[] args)
	{
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		quickSort(list);
		
		for (int element : list)
		{
			System.out.print(element + " ");
		}
	}
}