package sorting;

import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {

        // Create Scanner class to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the array elements");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // Print the original array
        System.out.println("The original array is ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // method call
        quickSort(arr, 0, size - 1);

        // print message to print the sorted array
        System.out.println("The Sorted array is ");

        // method call
        printArr(arr);
    }

    // method definition to print the array
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * method definition to sort the array using quicksort. low ---> Starting index
     * high ---> Ending index
     */
    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            /**
             * index is the partition return index
             */
            int index = partition(arr, low, high);

            /**
             * recursively call this method to sort elements before the partitioning index
             */
            quickSort(arr, low, index - 1);

            /**
             * recursively call this method to sort elements after the partitioning index
             */
            quickSort(arr, index + 1, high);
        }
    }

    /**
     * This method takes the last element as pivot, place the pivot element at it's
     * correct position in the sorted array, and place all the smaller
     * element(smaller than pivot) to the left side of the pivot and place all the
     * greater element(greater than pivot) to the right side of the pivot.
     */
    private static int partition(int[] arr, int low, int high) {

        // Initialize the highest index value as pivot
        int pivot = arr[high];

        /**
         * Index of smaller element and it indicates the right position of pivot
         */
        int i = (low - 1);

        for (int j = low; j <= high; j++) {

            // If the current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment the index of smaller element
                i++;

                // swap the current element with the index of the smaller element value
                swap(arr, i, j);
            }
        }

        /**
         * Finally we place pivot at correct position by swapping arr[i+1] and arr[high]
         * (or pivot)
         */
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // method definition to swap the elements
    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
