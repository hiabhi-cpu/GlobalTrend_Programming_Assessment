package problem7;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Max water that can be stored is : "+findMaxWater(new int[] {1,8,6,2,5,4,8,3,7}));
	}
	
	public static int findMaxWater(int []arr) {
		int l=0;
		int r=arr.length-1;
		int max=-1;
		
		while(l<r) {
			int temp=(r-l)*Math.min(arr[l], arr[r]);
			if(temp>max) {
				max=temp;
			}
			if(arr[l]<arr[r]) {
				l++;
			}
			else {
				r--;
			}
		}
		return max;
	}
	
}
