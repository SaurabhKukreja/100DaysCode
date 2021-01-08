package search_algo;

public class BinarySearch {
  /*
  * Reason we use Binary Search is because linear Search is very expensive
  * In real world if the array is too big, we dont want to iterate through every index to
  * find what we want. Thats why we have Binary Search.
  * */

  public static int binarySearchApproach1(int[] arr, int left, int right, int num) {
    /*
    * Now because we are recursive calling the method Space Complexity = O(Log n)
    * And because we divided the array in half in every iteration so time complexity = O(Log n )
    * */
    if (left < right) {
      int mid = (right + left) / 2;
      if (arr[mid] == num) {
        System.out.println("Number found at " + mid + " position");
        return mid;
      } else if (arr[mid] > num) {
        return binarySearchApproach1(arr, left, mid - 1, num);
      } else {
        return binarySearchApproach1(arr, mid + 1, right, num);
      }
    }
    System.out.println("Sorry Number not found");
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1,2,3,4,5,6};
    binarySearchApproach1(arr, 0, arr.length, 30);
  }

}
