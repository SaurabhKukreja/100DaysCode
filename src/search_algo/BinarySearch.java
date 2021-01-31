package search_algo;

public class BinarySearch {
  /*
   * Reason we use Binary Search is because linear Search is very expensive
   * In real world if the array is too big, we dont want to iterate through every index to
   * find what we want. Thats why we have Binary Search.
   * */

  public static int binarySearchRecursive(int[] arr, int left, int right, int num) {
    /*
     * Now because we are recursive calling the method Space Complexity = O(Log n)
     * And because we divided the array in half in every iteration so time complexity = O(Log n )
     * */
    if (left < right) {
      int mid = (right + left) / 2;
      if (arr[mid] == num) {
        return mid;
      } else if (arr[mid] > num) {
        return binarySearchRecursive(arr, left, mid - 1, num);
      } else {
        return binarySearchRecursive(arr, mid + 1, right, num);
      }
    }
    return -1;
  }

  public static int binarySearchIterative(int[] arr, int left, int right, int num) {
    while (left <= right) {
      int mid = (right + left) / 2;

      if (arr[mid] == num) {
        //Checking if arr[mid] is what we are looking for
        return mid;
      }
      if (arr[mid] < num) {
        //We search on the left half if num is smaller
        left = mid + 1;
      }
      else {
        //We search on the right half if num is greater
        right = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 4, 5, 6};
    int position = binarySearchRecursive(arr, 0, arr.length-1, 5);
    System.out.println("Number found at " + position + " position");
    int positionI = binarySearchIterative(arr, 0, arr.length-1, 5);
    System.out.println("Number found at " + positionI + " position");
  }


}
