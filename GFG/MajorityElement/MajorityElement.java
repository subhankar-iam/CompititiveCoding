
// Moore’s Voting Algorithm

import java.util.*;
import java.io.*;

public class MajorityElement{
	public static void main(String[] args) {
		
		File file = new File("../../input.txt");
		try(Scanner scanner = new Scanner(file)){
			int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			System.out.println(Solution.majorityElement(arr));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}

class Solution {
    static int majorityElement(int arr[]) {
       int count =0;
       int candidate =-1;
       int n = arr.length;
       System.out.println(n);

       for(int ele : arr){
       		if(count == 0 ){
       			count = 1;
       			candidate = ele;
       			
       		}
       		else if(ele == candidate){
       			count++;
       		}
       		else{
       			count --;
       		}	
       	}
       System.out.println(candidate);
       final int target = candidate;
       int cnt = (int) Arrays.stream(arr).filter(i->i==target).count();
       
       return cnt>n/2 ? target :-1 ;
    }
}