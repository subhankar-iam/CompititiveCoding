import java.util.*;
import java.io.*;



public class DNAString{

	public static void main(String[] args) {
		
		File file = new File("../input.txt");
		Map<String,String> map = new HashMap<String,String>(){{
			put("00","A");
			put("01","T");
			put("10","C");
			put("11","G");
		}};
		
		try(Scanner scanner = new Scanner(file)){
			int t = scanner.nextInt();

			while(t-- > 0){
				int n= scanner.nextInt();
				String s = scanner.next();
				solution(n,s,map);
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}

	}

	public static void solution(int n , String s, Map<String,String> map){
		String output = "";
		for(int i=0;i<n;i+=2){
			output+= map.get(s.substring(i,i+2));
		}

		System.out.println(output);
	}
}