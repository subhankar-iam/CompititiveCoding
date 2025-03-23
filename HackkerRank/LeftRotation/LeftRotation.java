import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class LeftRotation{

	public static void main(String[] args) {
		File file = new File("../../input.txt");
		try(Scanner scanner = new Scanner(file)){

			int n = scanner.nextInt();
			int d = scanner.nextInt();
			scanner.nextLine();
			String s = scanner.nextLine();
			List<Integer> input = Arrays.stream(s.split(" "))
						   .map(Integer::parseInt)
						   .collect(Collectors.toList());
						   
			getSolution(input,d,n);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
	}

	public static void getSolution(List<Integer> input,int d,int n){
		d = d%n;
		while(d-- > 0){
			int top = input.get(0);
			input.remove(0);
			input.add(top);
		}

		input.forEach(i->System.out.print(i+" "));
	}
}