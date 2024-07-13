package problem1;

public class MainClass {
	public static void main(String []args) {
		CacheHandler cache=new CacheHandler(2);
		cache.put(1, 10);
        cache.put(2, 20);
//        cache.list.printList();
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 30); // evicts key 2
//        cache.list.printList();
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 40); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
//        cache.list.printList();
	}
}
