package search_algo;

public class SearchInRotatedArrayApproach2 {
  /*
  * In this Solution, we will try to find an element without find the pivot
  * Because iN order to find the pivot we may traverse the array multiple times
  **/

  public static int searchAnElement(int[] arr, int low, int high, int key) {
    if(low > high) {
      return -1;
    }
    int mid = (low + high) /2 ;
    if(key == arr[mid]) {
      return mid;
    }
    if(arr[low] <= arr[mid]) {
      /*Means low to mid is sorted*/
      if(key <= arr[mid] && key >= arr[low]) {
        /* If key lies between low to mid
        * then search the key between low to mid-1
        * else mid+1 to high
        * */
        return searchAnElement(arr,low, mid-1, key);
      } else {
        return searchAnElement(arr, mid+1, high, key);
      }
    } else {
      /*means mid +1 to high is sorted*/
      if(key >= arr[mid] && key <= arr[high]) {
        /*
        * if key lies between mid to high
        * then search the key between mid+1 to high
        * else low to mid-1
        * */
        return searchAnElement(arr,mid+1, high, key);
      } else {
        return searchAnElement(arr, low, mid-1, key);
      }
    }
  }
  public static void main(String[] args) {
    int[] arr = new int[] {6,7,8, 1, 2, 3, 4,5};
    int elementFoundAtIndex = searchAnElement(arr, 0,arr.length - 1, 16);
    System.out.println("Key found at: "+elementFoundAtIndex);
  }

}
