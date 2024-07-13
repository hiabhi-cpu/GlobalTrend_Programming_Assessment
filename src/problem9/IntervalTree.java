package problem9;

import java.util.ArrayList;
import java.util.List;

public class IntervalTree {
	Node root;
	
	public void insertInterval(int start,int end) {
		root=insert(root,new Interval(start, end));
	}

	private Node insert(Node node, Interval interval) {
		// TODO Auto-generated method stub
		if(node==null) {
			return new Node(interval);
		}
		
		if (interval.start < node.interval.start) {
            node.left = insert(node.left, interval);
        } 
		else {
            node.right = insert(node.right, interval);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        node.max = Math.max(node.max, interval.end);

        return balance(node);
	}
	
	public void deleteInterval(int start, int end) {
        root = delete(root, new Interval(start, end));
    }

    private Node delete(Node node, Interval interval) {
        if (node == null) {
        	return null;
        }

        if (interval.start < node.interval.start) {
            node.left = delete(node.left, interval);
        } 
        else if (interval.start > node.interval.start) {
            node.right = delete(node.right, interval);
        } 
        else {
            if (node.left == null || node.right == null) {
                Node temp = node.left != null ? node.left : node.right;
                if (temp == null) {
                    temp = node;
                    node = null;
                } 
                else {
                    node = temp;
                }
            } 
            else {
                Node temp = minValueNode(node.right);
                node.interval = temp.interval;
                node.right = delete(node.right, temp.interval);
            }
        }

        if (node == null) {
        	return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        node.max = Math.max(node.interval.end, Math.max(max(node.left), max(node.right)));

        return balance(node);
    }
    
    public List<Interval> findOverlappingIntervals(int start, int end) {
        List<Interval> result = new ArrayList<>();
        findOverlappingIntervals(root, new Interval(start, end), result);
        return result;
    }

    private void findOverlappingIntervals(Node node, Interval interval, List<Interval> result) {
        if (node == null) {
        	return;
        }

        if (doOverlap(node.interval, interval)) {
            result.add(node.interval);
        }

        if (node.left != null && node.left.max >= interval.start) {
            findOverlappingIntervals(node.left, interval, result);
        }

        findOverlappingIntervals(node.right, interval, result);
    }

    private boolean doOverlap(Interval i1, Interval i2) {
        return i1.start <= i2.end && i2.start <= i1.end;
    }

    private Node balance(Node node) {
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int max(Node node) {
        return node == null ? Integer.MIN_VALUE : node.max;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        y.max = Math.max(y.interval.end, Math.max(max(y.left), max(y.right)));
        x.max = Math.max(x.interval.end, Math.max(max(x.left), max(x.right)));

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        x.max = Math.max(x.interval.end, Math.max(max(x.left), max(x.right)));
        y.max = Math.max(y.interval.end, Math.max(max(y.left), max(y.right)));

        return y;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }
	
	
}
