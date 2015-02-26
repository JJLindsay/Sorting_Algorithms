import java.io.*;

/**
 * author: JJ Lindsay
 * version: 1.0
 * Course: ITEC 3150 Fall 2014
 * Written: 2/26/2015
 *
 * This class represents a .
 *
 * Purpose: Allows the manipulation of a ...
 */
public class CreateLargeFile
{
    public static void main(String[] args) throws IOException
    {
        //creates a large file
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("largedata.dat")));

        //populates the largedata.dat file with 800,004 numbers
        for (int i = 0; i < 800004; i++)
        {
            output.writeInt((int)(Math.random() * 1000000));
        }
        output.close();

        //open and display first 100 numbers
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("largedata.dat")));

        for (int i = 0; i < 100; i++)
        {
            System.out.print(input.readInt() + " ");
        }
        input.close();

        SortLargeFile.sort("largedata.dat", "sortedfile.dat");
        System.out.println("\nThis is from the sorted file:");
        SortLargeFile.displayFile("sortedfile.dat");
    }
}
