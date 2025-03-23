import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class SparseArray{
	private static Map<String,Integer> map = new HashMap<String,Integer>();
	public static void main(String[] args) {
		
		File file = new File("../../input.txt");

		try(Scanner scanner = new Scanner(file)){
			int inputLen = scanner.nextInt();
			String input="";
			while(inputLen-- > 0 ){
				String s = scanner.next();
				// System.out.println(s);
				map.put(s,map.getOrDefault(s,0)+1);
			}
			
			int queryLen = scanner.nextInt();
			while(queryLen-- > 0){
				System.out.println(map.getOrDefault(scanner.next(),0));
			}


		}catch(Exception ex){

		}
	}
}