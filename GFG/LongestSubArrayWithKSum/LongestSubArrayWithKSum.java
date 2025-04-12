import java.util.*;
import java.io.*;

public class LongestSubArrayWithKSum{
    public static void main(String ... args){

        File file = new File("../../input.txt");
        try(Scanner scanner = new Scanner(file)){
            int k = scanner.nextInt();
            scanner.nextLine();
            int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Solution sol = new Solution();
            System.out.println(sol.longestSubarray(arr,k));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

class Solution{
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        int res = 0;
        int sum =0;
        for(int i=0;i<arr.length;i++){
            sum+= arr[i];
            // arr[i]=sum;
            if(sum == k)res =Math.max(res,i+1);
            else if( hmap.containsKey(sum-k)){
                res = Math.max(res, i-hmap.get(sum-k));
            }
            if(!hmap.containsKey(sum)){
                hmap.put(sum,i);
            }
            
        }

        return res;
    }
}