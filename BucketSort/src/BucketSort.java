import java.util.*;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 3150 Fall 2014
 * Written: 2/26/2015
 *
 * This class represents a O(dn) Bucket Sort but slight modifications can make it work for Radix Sort too.
 *
 * Purpose: Allows the sorting of integers at a O(dn) where d is the number of radix positions amongst the keys.
 * This is ideal for numbers since integer keys do not compare keys. Other algorithms are based on comparison and max
 * at O(nlogn)
 */
public class BucketSort
{
    public static void bucketSort(int[] list, int maxVal)
    {
        ArrayList[] buckets = new ArrayList[maxVal + 1];  //ranges 0 - 9

        //creates any arraylist the size of the largest element + 1
        //int[] bucket = new int[maxVal + 1];  //t is the highest value

        //Distributes the elements from the list to the buckets
        for (int i = 0; i < list.length; i++)
        {
            int key = list[i];  //collects the number as a key
            if (buckets[key] == null)  //checks to see if that bucket has been defined or has contents
            {
                buckets[key] = new ArrayList<Integer>();
            }

            buckets[key].add(list[i]);
        }

        //now move the elements from the buckets back to the list
        int k = 0; //index for original list
        for (int i = 0; i < buckets.length; i++)
        {
            if (buckets[i] != null)
            {
                //retrieves all elements from this particular bucket
                for (int j = 0; j < buckets[i].size(); j++)
                {
                    list[k++] = (Integer)buckets[i].get(j);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] mylist = {5,3,0,2,4,1,0,5,2,3,1,4};

        System.out.println("Before: " + Arrays.toString(mylist));
        bucketSort(mylist, 5);
        System.out.println("After:  " + Arrays.toString(mylist));
    }
}
