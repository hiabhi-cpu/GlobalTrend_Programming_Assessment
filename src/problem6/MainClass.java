package problem6;

import java.util.Stack;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()")); //true
		System.out.println(isValid("()[]{}"));	//true
		System.out.println(isValid("(}"));	//false
		System.out.println(isValid("[{(}]"));	//false
	}
	
	
	public static boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stk.isEmpty()){
                stk.add(s.charAt(i));
            }
            else{
                if(s.charAt(i)=='[' || s.charAt(i)=='(' || s.charAt(i)=='{'){
                    stk.add(s.charAt(i));
                }
                else if(s.charAt(i)==')' && stk.peek()=='('){
                    stk.pop();
                }
                else if(s.charAt(i)==']' && stk.peek()=='['){
                    stk.pop();
                }
                else if(s.charAt(i)=='}' && stk.peek()=='{'){
                    stk.pop();
                }
                else{
                    stk.add(s.charAt(i));
                }
            }
        }
        if(stk.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
