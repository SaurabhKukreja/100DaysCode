package search_algo;

public class LinearSearch {

  public static void searchNumberApproach1(int[] arr, int num, int n) {
    /*
    * Because we have to iterate over the whole array our
    * Time Complexity = O(n)
    * And we are not using any extra space so
    * Space Complexity = O(1)
    *
    * */
    int position = -1;
    for(int i = 0; i < n ; i++) {
      if(arr[i]==num) {
        position = i;
      }
    }
    System.out.println(num + "found at " + position + "position");
  }

  public static void searchNumberApproach2(int[] arr, int num, int n) {

    /*
    *
    * We can save some time by looping from both sides of array as we know the indexes
    * So we can say out Time Complexity = O(n/2)
    * SO if element is found at last position Time Compl = O(1) instead of O(n)
    * And if element is not found Time Compl = O(n/2) instead of O(n)
    * And we are not using any extra space so
    * Space Complexity = O(1)
    * */
    int right = n-1;
    int left = 0;
    int position = -1;
    int count = 0;
    while(true) {
      if(left > right) {
        break;
      }
      if(arr[left] == num) {
        System.out.println("count in left" + count + " " + left);
        position = left;
        break;
      }
      if(arr[right] == num) {
        System.out.println("count in right" + count + " " + right);
        position = right;
        break;
      }
      left++;
      right--;
    }
    System.out.println(num + "found at " + position + "position");
  }

  public static void main(String[] main) {
    int[] arr = new int[] {1,2,3,4,5,6};
    searchNumberApproach1(arr, 3, arr.length);
    searchNumberApproach2(arr, 3, arr.length);
  }
}
