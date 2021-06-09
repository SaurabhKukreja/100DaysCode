package arrays;

public class RotationCount {

  public static int findRotationCountLinear(int[] arr) {
    /*
    * This is simple Linear Search*/
    int count = 0;
    for (int i = 0; i < arr.length-1; i++) {
      if (arr[i] > arr[i + 1]) {
        count = i + 1;
        break;
      }
    }
    return count;
  }

  public static int findRotationCountBinary(int[] arr, int low, int high) {
    if(low > high){
      return -1;
    }
    int mid = ( high + low ) / 2;
    if(mid > low && arr[mid] < arr[mid-1]) {
      return mid;
    }
    if(mid < high && arr[mid] > arr[mid+1]) {
      return mid+1;
    }
    if(arr[low] < arr[mid]) {
      // this is sorted
      return findRotationCountBinary(arr, mid+1, high);
    } else {
      // this part is definitely not sorted
      return findRotationCountBinary(arr,mid+1, high);
    }
  }

  public static void main(String[] args) {
    int arr[] = {3,4,5,6,7,8,9,10};
    int count = findRotationCountLinear(arr);
    System.out.println("Array is rotated at: "+count);
    int countBinary = findRotationCountBinary(arr, 0, arr.length-1);
    System.out.println("Array is rotated at: "+countBinary);
  }

}
