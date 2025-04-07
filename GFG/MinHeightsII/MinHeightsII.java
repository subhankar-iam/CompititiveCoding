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
        
        int [] min_arr = {Integer.MAX_VALUE,Integer.MAX_VALUE};
        int [] max_arr = {Integer.MIN_VALUE,Integer.MIN_VALUE};

        for(int ele : arr){
        	min_arr[0] = Math.min(min_arr[0],ele+k);
        	min_arr[1] = ele-k<0 ? min_arr[1]:Math.min(min_arr[1],ele-k);

        	max_arr[0] = Math.max(max_arr[0],ele+k);
        	max_arr[1] = ele-k<0 ? max_arr[1]:Math.max(max_arr[1],ele-k);
        }

        int minDiff = Integer.MAX_VALUE;
        for(int min:min_arr){
        	for(int max : max_arr){
        		minDiff = max-min<0 ? minDiff:Math.min(minDiff,(max-min));
        	}
        }
        return minDiff;
    }
}