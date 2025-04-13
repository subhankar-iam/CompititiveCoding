import java.util.*;
import java.io.*;

public class MissingAndRepeating {
	public static void main(String[] args) {
		 File file = new File("../../input.txt");
		 try(Scanner scanner = new Scanner(file)) {
				int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				Solution sol = new Solution();
				System.out.println(sol.findTwoElement(arr));
		 } catch (Exception e) {
				 System.out.println(e.getMessage());
		 }
	}
}

class Solution {
  ArrayList<Integer> findTwoElement(int arr[]) {
		// ArrayList<Integer> res = new ArrayList<>();
		int i=0;
		int result=-1;
		int sum = Arrays.stream(arr).sum();
		int n = arr.length;
		int nSum = (n*(n+1))/2;
		while(true){
			int pos = Math.abs(arr[i])-1;
			System.out.println(pos);
			if(arr[pos]<0){
				result=Math.abs(arr[i]);
				break;
			}else{
				// pos = arr[i]-1;
				arr[pos] = -1*arr[pos];
			}
			System.out.println(Arrays.toString(arr));
			i++;
		}
		  // System.out.println(result+" "+(nSum-(sum-result)));
		
			

		return new ArrayList<>(Arrays.asList(result,(nSum-(sum-result))));
	}
}

