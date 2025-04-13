import java.util.*;
import java.io.*;

public class PeekElement {
	public static void main(String[] args) {
		File file = new File("../../input.txt");
		try(Scanner scanner = new Scanner (file)) {
				int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				Solution sol = new Solution();
				System.out.println(sol.peakElement(arr));
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}			
}

class Solution {

    public int peakElement(int[] arr) {
			int res =-1;
			int n = arr.length;
			int start=0,end = n-1;
			if(n==1)
				return 0;
			while (start<=end) {
				int mid = (start+end)/2;
				System.out.println(start+" "+mid+" "+end);
				/* if(mid == 0 && n>1 && arr[1]<arr[0])
						return 0;
				if(mid == n-1 && n-2>=0 && arr[n-2]<arr[n-1])
					return n-1; */

				if (mid==0){
					if(arr[start]>arr[start+1]) return start;
					else start=mid+1;
					continue;
				}else if(mid == n-1){
					if(arr[end] > arr[end-1])return end;
					else end = mid-1;
					continue;
				}

				if(arr[mid]< arr[mid-1]){
					end = mid-1;
				}else if(arr[mid] <arr[mid+1]){
					start = mid+1;
				}else{
					return mid;
				}
			}
      return res;   
    }
}
