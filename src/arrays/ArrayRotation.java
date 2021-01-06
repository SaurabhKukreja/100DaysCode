package arrays;

public class ArrayRotation {

  public static void printArray(int[] arr) {
    int n = arr.length;
    for(int i = 0; i<n ;i++){
      System.out.print(arr[i] + " ");
    }
  }

  public static void rotateApproach1(int[] arr, int n, int d) {

    /*
    * Take a new empty Array of size n
    * Add d to n-1 to new Array starting from 0 index
    * Save the position of last Index
    * Now Add 0 to d - 1 to new array starting from j+1 index
    * */

    /*
    * Because we took a new array of same size our
    * Space Complexity = O(n)
    * And time taken to rotate the array is proportional to number of elements our
    * time Complexity = O(n)
    * */
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

    /*
    * Rotate the array d times
    * */

    /*
     * Because our code is directly protpotional to d and there are n elements which are rearranged d times our
     * Time Complexity : O(d*n)
     * Because we are not using any new Array our
     * Space Complexity : O(1)
     * */
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

  public static void rotateApproach3(int[] arr, int n, int d) {
    /*
    * Now to optimize even more on time complexity, we will use Bubble Swap approach
    * In this approach we will rotate the array in sets.
    * Example [1,2,3,4,5,6] to be rotated for d = 2
    * We will make 2 ( gcd of n and d ) sets [1,2,3] and [4,5,6]
    * So we will loop 2 times and try to find out what value will come at i position.
    *
    * to begin we will have i =0 and j = i
    * We will try to find out which element will come on 0th position
    * and to get that we will use a variable
    * k = (j + d) % n
    * and then once we get the K we will make j = k to keep moving forward
    * we will break the loop once k == i
    *
    * */

    /*
    * Because we are not taking any extra array our
    * Space Complexity = O(1)
    * And Time Complexity = O(n)*/

    int gcd = gcd(n , d);
    int temp;
    System.out.println("Gcd is " + gcd);
    for(int i = 0; i < gcd ; i++) {
      int j = i;
      temp = arr[i];
      while(true) {
        int k = (d + j) % n;
        if(k == i) {
          break;
        }
        arr[j] = arr[k];
        j = k;
      }
      arr[j] = temp;

    }
    printArray(arr);


  }
  public static int gcd(int a , int b) {
    if(b == 0) {
      return a;
    } else {
      return gcd (b , a % b);
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1,2,3,4,5,6};
    int d = 2;
    printArray(arr);
    System.out.println("");
    rotateApproach3(arr,arr.length,d);

  }

}


