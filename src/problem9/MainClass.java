package problem9;

import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntervalTree tree = new IntervalTree();

        tree.insertInterval(15, 20);
        tree.insertInterval(10, 30);
        tree.insertInterval(17, 19);
        tree.insertInterval(5, 20);
        tree.insertInterval(12, 15);
        tree.insertInterval(30, 40);

        List<Interval> result = tree.findOverlappingIntervals(14, 16);
        System.out.println("Overlapping intervals: " + result);

        tree.deleteInterval(10, 30);
        result = tree.findOverlappingIntervals(14, 16);
        System.out.println("Overlapping intervals after deletion: " + result);
	}

}
