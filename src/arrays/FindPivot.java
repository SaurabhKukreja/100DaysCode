package arrays;

public class FindPivot {
  public static int findPivot(int[] arr, int low, int high) {
    /*
    * Step 1 - get the mid = low+high / 2
    * STep 2 = Check if mid is pivot ==> arr[mid] > arr[mid+1]
    * Step3 = if arr[low] <= arr[mid] that means low to mid elements are sorted,
    * so we need to check pivot in mid+1 to high elements
    * Step4 = else ==> this means low to mid are not sorted
    * so pivot lies in the range of 0 to mid -1
    * */
    int mid = (low+ high)/2;
    if(arr[mid] > arr[mid+1]) {
      return mid;
    } else if(arr[low] <= arr[mid]) {
      return findPivot(arr,mid+1, high);
    } else {
      return findPivot(arr,0, mid-1);
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {5,6,7,8,1,2,3,4};
    int pivot = findPivot(arr, 0, arr.length-1);
    System.out.println("Pivot found at index : " + pivot);
  }

}
