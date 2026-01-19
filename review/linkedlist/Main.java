package review.linkedlist;

class Main {
	public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.print();   

        list.addFirst(5);
        list.print();   

        list.delete(20);
        list.print();   	

        System.out.println(list.contains(30));  
    }
}
