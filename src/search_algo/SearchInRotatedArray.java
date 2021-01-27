package search_algo;

/*Search an element in a sorted and rotated array
 * An element in a sorted array can be found in O(log n) time via binary search.
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
 * Devise a way to find an element in the rotated array in O(log n) time*/

public class SearchInRotatedArray {

  public static int findPivot(int[] arr, int low, int high) {
    /*
    * Lets first find a pivot to see at which element is the array rotate
    * Once we know the pivot, we will have 2 sorted Arrays
    * and then we can simpley use Binary Search
    * To find the pivot :
    * https://github.com/SaurabhKukreja/100DaysCode/blob/master/src/arrays/FindPivot.java
    * */
    int mid = (low + high) / 2;
    if (arr[mid] > arr[mid + 1]) {
      return mid;
    }
    if (arr[low] <= arr[mid]) {
      return findPivot(arr, mid + 1, high);
    } else {
      return findPivot(arr, low, mid - 1);
    }
  }

  public static int searchAnElement(int[] arr, int key, int low, int high, int pivot) {

    /*
    * Once we have the pivot we have 2 Sorted Arrays
    * 0..pivot and pivot+1..high
    * Simply use Binary Search and find the key
    *
    * */
    if (arr[pivot] == key) {
      return pivot;
    } else if (key < arr[pivot]) {
      low = pivot +1;
      System.out.println("Searching for " + key +" between " + low + " - "+ high);
      return binarySearch(arr, key, pivot + 1, high);

    } else {
      high = pivot-1;
      System.out.println("Searching for " + key +" between " + low + "- "+ high);
      return binarySearch(arr, key, low, pivot - 1);
    }
  }

  public static int binarySearch(int[] arr, int key, int low, int high) {

    if(low < high) {
      int mid = (low + high) / 2;
      if (key == arr[mid]) {
        return mid;
      } else if (key < arr[mid]) {
        return binarySearch(arr, key, low, mid - 1);
      } else {
        return binarySearch(arr, key, mid + 1, high);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {6,7,8, 1, 2, 3, 4,5};
    int pivot = findPivot(arr, 0, arr.length - 1);
    System.out.println("Pivot found at: " + pivot);
    int elementFoundAtIndex = searchAnElement(arr, 13, 0, arr.length - 1, pivot);
    System.out.println("Key found at: "+elementFoundAtIndex);

  }
}
