package problem5;

	public class MainClass {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			HelperClass helper=new HelperClass();
			helper.insert("abhi");
			helper.insert("bhai");
			
			System.out.println("Search for bhai " +helper.search("bhai")); //true
			System.out.println("Starts with bhai "+helper.startsWith("bhai")); //true
			System.out.println("Starts with bio "+helper.startsWith("bio")); //false
			System.out.println("Search for abh "+ helper.search("abh")); //false
			System.out.println("Starts with abh "+helper.startsWith("abh")); //true
		}
	
	}
