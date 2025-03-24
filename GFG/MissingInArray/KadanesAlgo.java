import java.util.*;
import java.io.*;

public class KadanesAlgo{
	public static void main(String[] args) {
		File file = new File("../../input.txt");
		try(Scanner scanner = new Scanner(file)){
			int [] arr = Arrays.stream(scanner.nextLine().split(" "))
							   .mapToInt(Integer::parseInt)
							   .toArray();
			System.out.println(Solution.maxSubarraySum(arr));

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class Solution{
	static int maxSubarraySum(int[] arr) {
     	int currentSum = arr[0];
     	int maxSum = arr[0];

     	for(int i=1;i<arr.length;i++){
     		currentSum = Math.max(arr[i],currentSum+arr[i]);
     		maxSum = Math.max(maxSum,currentSum);
     	}   
     	return maxSum;
    }
}