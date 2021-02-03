package arrays;

public class MaximumSumArrayRotation {

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
