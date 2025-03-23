import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class IndexSubArraySum{
	public static void main(String[] args) {
		File file = new File("../../input.txt");
		try(Scanner scanner = new Scanner(file)){
			int target = scanner.nextInt();
			scanner.nextLine();
			int [] input = Arrays.stream(scanner.nextLine().split(" "))
								  .mapToInt(Integer::parseInt)
								  .toArray();


			System.out.println(Solution.subarraySum(input,target));
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}

	}
}


class Solution{

	static int lowerBound(int [] arr,int target){
		int low =0, high = arr.length-1;
		while(low<high){
			int mid = low+(high-low)/2;
			if(target <= arr[mid]){
				high = mid;
			}else{
				low = mid+1;
			}
		}
		if (low < arr.length && arr[low] < target) {
            low++;
        }
        return low;
	}
	static ArrayList<Integer> searchMatchingSum(int [] arr, int target,int lowerBound,int n){
		int start =0;
		while(start <= lowerBound && lowerBound <n){
			if(arr[lowerBound]-arr[start] == target){
				return new ArrayList<Integer> (Arrays.asList(start+2,lowerBound+1));
			}else if (arr[lowerBound]-arr[start] > target ){
				start++;
			}else{
				lowerBound++;
			}
		}
		return new ArrayList<Integer>(Arrays.asList(-1));
	}
	static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int sum =0;
        for(int i=0;i<arr.length;i++){
        	sum+=arr[i];
        	// if(arr[i]==target)
        	// 	return new ArrayList<Integer>(Arrays.asList(i+1,i+1));
        	if(sum==target)
        		return new ArrayList<Integer>(Arrays.asList(1,i+1));
        	arr[i]=sum;
        }
        int low = lowerBound(arr,target);	

        // System.out.println(low);
       	// ArrayList<Integer> array = (ArrayList<Integer> )Arrays.stream(arr).boxed().collect(Collectors.toList());
        return searchMatchingSum(arr,target,low,arr.length);
    }
}				