package problem2;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Creating two threads that modify the list
        Thread thread1 = new Thread(new ListModifier(list));
        Thread thread2 = new Thread(new ListModifier(list));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ListModifier implements Runnable {
    private List<String> list;

    public ListModifier(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
    	synchronized (list) {
    		try {
                Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()) {
                    String item = iterator.next();
                    if ("B".equals(item)) {
                        list.remove(item); // This should throw ConcurrentModificationException
                    }
                }
                System.out.println("After list:"+list);
            } catch (ConcurrentModificationException e) {
                System.out.println("Caught ConcurrentModificationException: " + e.getMessage());
            }
    	}
    }
}
