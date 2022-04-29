public class Stack<Item>{
    
    private Node first = null;
    private int n = 0;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void push(Item item){
        Node new_first = new Node();
        new_first.item = item;
        new_first.next = first;
        first = new_first;
        n++;
    }

    public Item pop(){
        Item head_item = first.item;
        first = first.next;
        n--;
        return head_item;
    }

    public String toString(){
        return "Linked List of " + n + " items of " + first.item.getClass();
    }

    public static void main(String args[]){
        Stack<Integer> list = new Stack<Integer>();
            
        int n_pushes = Integer.parseInt(args[0]);
        int n_pops = Integer.parseInt(args[1]);

        for (int i = 0; i < n_pushes; i++){
            list.push(i);
        }

        for (int i = 0; i < n_pops; i++){
            System.out.println(list.pop());
        }

        System.out.println(list);
    }

}
