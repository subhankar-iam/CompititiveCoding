import java.util.*;
import java.io.*;

public class ArrayDS{
	public static void main(String[] args) {
		
		File file = new File("../input.txt");

		try(Scanner scanner = new Scanner(file)){
			int n = scanner.nextInt();
			scanner.nextLine();
			String s = scanner.nextLine();
			
			int [] inputArray = Arrays.stream(s.split(" "))
								.mapToInt(Integer::parseInt)
								.toArray();

			int i=0,j=n-1;
			while(i<=j){
				int temp = inputArray[j];
				inputArray[j]=inputArray[i];

				inputArray[i]=temp;
				i++;
				j--;
			}

			for(int ele: inputArray){
				System.out.print(ele);
			}

		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}