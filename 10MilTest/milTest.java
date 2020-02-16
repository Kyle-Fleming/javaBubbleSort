import java.util.*;
class milTest
{



  public static void mergeSort(int[] inputArray)
   {
       int size = inputArray.length;
       if (size < 2)
           return;
       int mid = size / 2;
       int leftSize = mid;
       int rightSize = size - mid;

       int[] left = new int[leftSize];
       int[] right = new int[rightSize];

       System.arraycopy(inputArray, 0, left, 0, leftSize);
       System.arraycopy(inputArray, leftSize, right, 0, rightSize);

       mergeSort(left);
       mergeSort(right);
       merge(left, right, inputArray);
   }

   public static void merge(int[] left, int[] right, int[] arr)
   {
       int leftSize = left.length;
       int rightSize = right.length;
       int i = 0, j = 0, k = 0;
       while (i < leftSize && j < rightSize)
       {
         if (left[i] <= right[j])
         {
           arr[k++] = left[i++];
         }
        else
         {
           arr[k++] = right[j++];
        }
      }
      while (i < leftSize)
       {
         arr[k++] = left[i++];
       }
       while (j < leftSize)
        {
          arr[k++] = right[j++];
        }
   }

  public static void main(String[] args)
  {
    int [] data = new int[  10000000];
    Scanner input = new Scanner(System.in);
    int i = -1;
    long time0 = System.currentTimeMillis();

    while(input.hasNextInt())
    {
      data[++i] = input.nextInt();

    }

    long time1 = System.currentTimeMillis();
    System.out.println("\n Finished reading data, time to read data == " + (time1 - time0)/1000.0 + " Seconds");

    mergeSort(data);
    System.out.println(Arrays.toString(data));
    long time2 = System.currentTimeMillis();
    System.out.println("\n Finished sorting data, time to sort data == " + (time2 - time1)/1000.0 + " Seconds");
  }
}
