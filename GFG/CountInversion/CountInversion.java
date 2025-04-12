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
