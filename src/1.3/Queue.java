public class Queue<Item>{

    private Node first = null;
    private Node last = null;
    private int n = 0;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public void enqueue(Item item){
        Node old_last = last;
        Node new_node = new Node();
        new_node.item = item;
        last = new_node;
        if (first == null){
            first = new_node;
        }
        else{
            old_last.next = new_node;
        }
        n++;
    }

    public Item dequeue(){
        Item first_item = first.item;
        first = first.next;
        n--;
        if(isEmpty()){
            last = null;
        }
        return first_item;
    }

    public static void main(String args[]){

        Queue<Integer> queue = new Queue<Integer>();

        int n_ons = Integer.parseInt(args[0]);
        int n_offs = Integer.parseInt(args[1]);

        for(int i=0; i<n_ons; i++){
            queue.enqueue(i);
        }

        for(int i=0; i<n_offs; i++){
            System.out.println(queue.dequeue());
        }

    }

}
