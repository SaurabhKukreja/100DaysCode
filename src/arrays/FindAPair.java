package arrays;

import java.util.HashSet;

public class FindAPair {
  public static boolean findAPair(int[] arr, int sum) {
    /*
    * TimeComplexity - O(n) because we traverse through whole array
    * Space Complexity - O(n) because we have a new Hashset which may or may not contain n elements
    *
    * */
    HashSet<Integer> set = new HashSet<>();
    boolean ifPair = false;
    for(int i = 0 ;i<arr.length;i++) {
      int temp = sum - arr[i];
      if(set.contains(temp)) {
        ifPair = true;
        break;
      } else {
        set.add(arr[i]);
      }
    }
    return ifPair;
  }

  public static void main(String[] args) {
    int[] arr = {11, 15, 6, 8, 9, 10};
    int sum = 16;
    boolean ifPair = findAPair(arr, sum);
    System.out.println("The Pair exists: "+ ifPair);
  }

}
