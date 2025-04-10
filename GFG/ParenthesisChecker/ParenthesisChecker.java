import java.util.*;
import java.io.*;

public class ParenthesisChecker{
	public static void main(String[] args) {
		File file = new File("../../input.txt");
		try(Scanner scanner = new Scanner(file)){
			String s = scanner.nextLine();
			System.out.println(Solution.isBalanced(s));

		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}

class Solution {
    static boolean isBalanced(String s) {
     	Stack<Character> st = new Stack<>();
     	for(char ch: s.toCharArray()){
     		if(ch == '}' || ch == ')' || ch == ']'){
     			if(st.isEmpty())return false;
     			if(isMatch(ch,st.peek())){
     				st.pop();
     			}else{
     				return false;
     			}
     		}else{
     			st.push(ch);
     		}
     	}
     	return st.isEmpty();
    }
    static boolean isMatch(char ch,Character top){

    	switch(ch){
    		case ')':
    			return top == '(';
    		case '}':
    			return top == '{';
    		case ']':
    			return top == '[';
    		default:
    			return false;
    	}
    }
}
