import java.util.*;
import java.io.*;

public class CountInversion{
    public static void main(String [] args){
        File file = new File("../../input.txt");
        try(Scanner scanner = new Scanner(file)){
            int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                                .toArray();
            System.out.println(Solution.inversionCount(arr));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

class Solution{
    
    static int inversionCount(int arr[]) {
        IntRef intRef = new IntRef(0);
        inversionCountHelper(arr,0,arr.length-1,intRef);
        return intRef.intRef;
    }
    static int [] inversionCountHelper(int [] arr,int start,int end,IntRef result){
        
        if(start==end){
            
            return new int[]{arr[start]};
        }
        
        int mid = (start+end)/2;
        int [] left = inversionCountHelper(arr,start,mid,result);
        int [] right = inversionCountHelper(arr,mid+1,end,result);
        
        int left_len = left.length;
        int right_len = right.length;
        int i=0,j=0,k=0;
        int [] res = new int [left_len+right_len];
        
        while(i<left_len && j<right_len){
            if(left[i]>right[j]){
                result.intRef += (left_len-i);
                
                res[k]=right[j];
                j++;
            }else{
                res[k]=left[i];
                i++;
            }
            k++;
        }
        
        if(i<left_len){
            while(i<left_len){
                res[k++]=left[i++];
            }
        }

        if(j<right_len){
            while(j<right_len){
                res[k++]=right[j++];
            }
        }
        
        return res;
    }
}

class IntRef{
    public int intRef ;
    public IntRef(int intRef){this.intRef=intRef;}
}