import java.util.*;
import java.io.*;


public class MinHeightsII{
	public static void main(String[] args) {
		File file = new File("../../input.txt");
		try(Scanner scanner = new Scanner(file)){
			 int k = scanner.nextInt();
			 scanner.nextLine();
			 int [] arr = Arrays.stream(scanner.nextLine().split(" "))
			 					.mapToInt(Integer::parseInt).toArray();
			 Solution sol = new Solution();
			 System.out.println(sol.getMinDiff(arr,k));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}

class Solution {
    int getMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = arr[n-1]-arr[0]; 
        for(int i=1;i<n;i++){
        	if (arr[i] - k < 0)
            	continue;
        	int minTower = Math.min(arr[0]+k,arr[i]-k);
        	int maxTower = Math.max(arr[i-1]+k,arr[n-1]-k);

        	minDiff = Math.min(minDiff,maxTower-minTower);
        }
        return minDiff;
    }
}