import java.util.*;
import java.io.*;

public class MinPlatformRequired {
	public static void main(String[] args) {
		File file = new File("../../input.txt");
		try(Scanner scanner = new Scanner(file)) {
				int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int [] dep = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				// System.err.println(Arrays.toString(arr)+" "+Arrays.toString(dep));
				System.err.println(Solution.findPlatform(arr,dep));
				Solution.findPlatform(arr,dep);
		} catch (Exception e) {
				System.err.println(e.getMessage());	
		}
	}
}

class Solution {

		/* Sweep Line Algorithm
		This Algorithm used in time duration related problems,It sorts the time durations in 
		chronological order. we get the max dep time and from 0 to max dep time if train arraives at a time
		we add 1 to the array at that time denoting that train is there and if the train departs we reduce
		i+1 time by 1 , the max cummulative sum the max num of trains at any point, so max num of platform
		required. */



    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
				int maxDep = Arrays.stream(dep).max().orElseThrow();
				int [] V = new int [maxDep+2];
				for(int i =0;i<n;i++){
					V[arr[i]]++;
					V[dep[i]+1]--;
				}
				// System.err.println(Arrays.toString(V));
				int count =0;
				int res = 0;
				for(int i=0;i<=maxDep+1;i++){
					count += V[i];
					res = Math.max(res,count);
				}
				return res;
    }
}



