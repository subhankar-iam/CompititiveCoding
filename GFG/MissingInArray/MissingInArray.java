import java.util.*;
import java.io.*;


public class MissingInArray{
	public static void main(String[] args) {
		File file = new File("../../input.txt");
		try(Scanner scanner = new Scanner(file)){
			int [] input = Arrays.stream(scanner.nextLine().split(" "))
								 .mapToInt(Integer::parseInt)
								 .toArray();
			System.out.println(Solution.missingNumber(input));					 	

		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}

class Solution{
	static int missingNumber(int arr[]) {
		int n = arr.length+1;
		// System.out.println(n);
		long sumOfFirst = (long)n*(n+1)/2;
		long sumOfArray = Arrays.stream(arr).boxed().mapToLong(Integer::longValue).sum();
		// System.out.println(sumOfFirst+" "+sumOfArray);
		return (int)(sumOfFirst-sumOfArray);
	}
}