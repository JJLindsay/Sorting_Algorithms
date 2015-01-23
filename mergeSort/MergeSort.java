package mergeSort;

/**
 * Class: MergeSort.java
 * @author JJ Lindsay
 * @version 1.0
 * Course: Preparing for 2015 Internship 
 * Written: Jan 23, 2015
 *
 * This class represents a merge sort which is quite efficient and operates at an O(nlogn)
 *
 * Purpose: To divide a list in half an recursively call merge sort until the array is 1.
 * Then, call merge on the last two arrays and work up.
 */
public class MergeSort
{

	public static void mergeSort(int[] list)
	{
		if (list.length>1) // this is the breaking point/stopping point
		{
			int[] firstHalf = new int[list.length/2];
			int[] secondHalf = new int[list.length - list.length/2];
			
			/*parameters:
			 * 1: the list being copied
			 * 2: the position to begin the copying
			 * 3: the new list being copied to
			 * 4: the position in the new list to send the copies to
			 * 5: the size or number elements being copied
			 */
			System.arraycopy(list, 0, firstHalf, 0, list.length/2);		
			System.arraycopy(list, list.length/2, secondHalf, 0, list.length - list.length/2);
			
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list);
		}
	}	
	
	public static void merge(int[] first, int[] second, int[] temp)
	{
		//how do you merge two elements into one array
		//
		int count = 0;  //index for the temp list
		int countFirst = 0;  //index for the first half
		int countSecond = 0;  //index for the second half list
		
		//as long as there are elements left in both continue comparing and merging
		//ERROR!! Make sure to compare the RIGHT index to its proper list, e.g. using count for temp
		//as count < first
		while (countFirst < first.length && countSecond < second.length)
		{
			if (first[countFirst] > second[countSecond]){
				temp[count] = second[countSecond];
				count++;
				countSecond++;
			}
			else{
				temp[count] = first[countFirst];
				count++;
				countFirst++;
			}
		}
		
		//add everything left in second list if first is all searched
		while (countSecond < second.length)
		{
			temp[count] = second[countSecond];
			count++;
			countSecond++;
		}
		
		//add everything left in first if second is all searched
		while (countFirst < first.length)
		{
			temp[count] = first[countFirst];
			count++;
			countFirst++;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		mergeSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}

}
