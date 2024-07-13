package problem8;

import java.util.PriorityQueue;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums=new int[]{3,2,3,1,2,4,5,5,6};
		int k=4;
		PriorityQueue<Integer> queue=new PriorityQueue<>(k);
		for(int i=0;i<k;i++) {
			queue.add(nums[i]);
		}
		for(int i=k;i<nums.length;i++) {
			if(nums[i]>queue.peek()) {
				queue.poll();
				queue.add(nums[i]);
			}
		}
		System.out.println(k+"th largest number is: "+ queue.poll());
	}

}
