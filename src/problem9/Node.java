package problem9;

public class Node {
	Interval interval;
	Node left,right;
	int height;
	int max;
	
	public Node(Interval interval) {
		this.interval=interval;
		max=interval.end;
		height=1;
	}
}
