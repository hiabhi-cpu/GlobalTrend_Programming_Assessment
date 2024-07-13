package problem10;

public class MainClass {
	
	public static void main(String []args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
	
	public static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char chi=s.charAt(i);
            char chj=s.charAt(j);
            if(!Character.isLetterOrDigit(chi)){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(chj)){
                j--;
                continue;
            }
            if(Character.toLowerCase(chi) != Character.toLowerCase(chj)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
