import java.util.*;
import java.io.*;

public class MinJumps{
	public static void main(String[] args) {
		File file = new File("../../input.txt");
		try(Scanner scanner = new Scanner(file)){
			int [] arr = Arrays.stream(scanner.nextLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
			System.out.println(Solution.minJumps(arr));
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}

class Solution{
	static int [] dp;
	static int minJumps(int[] arr) {
        int size = arr.length;
        dp = new int[size];
        Arrays.fill(dp,-1);
        int res= minJumpsUtil(arr,0,size-1);
        return res==Integer.MAX_VALUE-1?-1:res;
    }
    static int minJumpsUtil(int [] arr,int index,int n){
    	// System.out.println(index);
    	if(index >=n )
    		return 0;

    	if(dp[index]!=-1)
    		return dp[index];
    	int minVal = Integer.MAX_VALUE;	
    	int maxPath = arr[index];
    	while(maxPath>0){
    		minVal = Math.min(minVal,1+minJumpsUtil(arr,index+maxPath,n));
    		maxPath--;
    	}
    	System.out.println(index +" "+minVal);
    	return dp[index]=minVal==Integer.MAX_VALUE?Integer.MAX_VALUE-1:minVal;
    }
}