package arrays;

public class MaximumSumArrayRotation {

  /*
   * Time Complexity : O(N)
   * Space Complexity : O(1)
   *
   * First Brute approach way to it is Keep rotating array 1 by 1 and calculate the sum of i*a[i]
   * This will give TimeComplexity : O(N*N)
   * Space Complexity : O(1)
   *
   * But Let's understand the better approach
   * Example : [8, 3, 1, 2]
   *                                       0 | 1 | 2 | 3
   * R[0] = 0*8 + 1*3 + 2*1 + 3*2 = 11     8   3   1   2
   * R[1] = 0*3 + 1*1 + 2*2 + 3*8 = 29     3   1   2   8
   * R[2] = 0*1 + 1*2 + 2*8 + 3*3 = 27     1   2   8   3
   * R[3] = 0*2 + 1*8 + 2*3 + 3*1 = 17     2   8   3   1
   *
   * Now Lets try to find out the common pattern between these summations.
   *
   * lets take R' = R[1] - R[0]
   * R' = 0*3 + 1*1 + 2*2 + 3*8 - 0*8 - 1*3 - 2*1 - 3*2 = 6
   * R' = 6 which is same as 3 + 1 + 2 Or in other words the sum of remaining elements.
   *
   * Lets validate this again
   * R" = R[2]- R[1]
   * R" = 0*1 + 1*2 + 2*8 + 3*3 - 0*3 - 1*1 - 2*2 - 3*8 = 11
   * R" = 11 which is same as 1 + 2 + 8 or in other words the sum of remaining elements.
   *
   * Now what can we derive out of this.
   * let take sum = Sum of all elements in arr =  8+3+1+2 = 14
   * Can we say that
   * R[1] = maxSum - X + arr[0]* (n-1)
   * R[2] = maxSum - X + arr[1]* (n-1)
   * R[3] = maxSum - X + arr[2]* (n-1)
   * where
   * maxSum = i*arr[i] for first loop = R[0]
   *
   * Now what is this X, X is the sum of remainting 3 elemens other than first element which was rotated
   * so can we say
   * X = 3+1+2
   * OR
   * X = 8+3+1+2 - 8
   * OR
   * X = sum - arr[i-1]
   *
   * So we can conclude this
   * R = maxSum - (sum - arr[i-1] ) + arr[i-1] * (n-1)
   * OR
   * R = maxSum - sum + arr[i-1]*(n)
   *
   *
   * Now we just compare the max sum and get the max sum as the result
   * */
  public static void findMaxSum(int[] arr) {
    int sum = 0;
    int maxSum = 0;
    int res = 0;
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      sum += arr[i];
      maxSum += i * arr[i];
    }
    System.out.println("Sum: " + sum);
    System.out.println("Max Sum: " + maxSum);
    for (int i = 1; i <= len; ++i) {
      maxSum = maxSum - sum + arr[i - 1] * len;
      res = Math.max(res,maxSum);
    }
    System.out.println("Max Sum: " + res);
  }

  public static void main(String[] args) {
    int[] arr = {2, 10, 13, 1, 14, 16, 43, 11};
    findMaxSum(arr);
  }

}
