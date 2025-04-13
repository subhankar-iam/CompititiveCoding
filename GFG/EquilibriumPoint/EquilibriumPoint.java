import java.util.*;
import java.io.*;

public class EquilibriumPoint{
	public static void main(String[] args) {
    File file = new File("../../input.txt");
		try(Scanner scanner = new Scanner(file)){
				int [] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				// System.out.println(Arrays.toString(arr));
				System.out.println(Solution.findEquilibrium(arr));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}

class Solution{
	public static int findEquilibrium(int arr[]) {

        int len = arr.length;
				int [] fwd = new int [len];
				int [] bwd = new int [len];
				fwd[0]=arr[0];
				bwd[len-1]=arr[len-1];
				for(int i=1,j=len-2;i<len && j>=0 ;i++,j-- ){
						fwd[i]=fwd[i-1]+arr[i];
						bwd[j]=bwd[j+1]+arr[j];
				}

				for(int i=0;i<len ;i++){
					if(fwd[i]-arr[i] == bwd[i]-arr[i]){
						return i;
					}
				}
				return -1;
    }
}
