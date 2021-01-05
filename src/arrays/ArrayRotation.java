package arrays;

public class ArrayRotation {

  public static void printArray(int[] arr) {
    int n = arr.length;
    for(int i = 0; i<n ;i++){
      System.out.print(arr[i] + " ");
    }
  }

  public static void rotateApproach1(int[] arr, int n, int d) {
    int[] newArr = new int[n];
    int j = 0 ;
    for(int i = d ; i <n ;i++) {
      newArr[j] = arr[i];
      j++;
    }
    for(int i = 0;i<d ;i++){
      newArr[j]=arr[i];
      j++;
    }
    printArray(newArr);
  }

  public static void rotateApproach2(int[] arr, int n, int d) {
    for(int i = 0 ; i < d ; i++) {
      leftRotate(arr, n, d);
    }
    printArray(arr);
  }

  private static void leftRotate(int[] arr, int n, int d) {
    int temp = arr[0];
    for(int i =0 ; i < n-1 ; i++){
      arr[i] = arr[i+1];
    }
    arr[n-1] = temp;
    printArray(arr);
    System.out.println("Round");
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1,2,3,4,5,6};
    int d = 2;
    printArray(arr);
    System.out.println("");
    rotateApproach2(arr,arr.length,d);

  }

}


