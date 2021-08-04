package deque;

import java.time.temporal.Temporal;
import java.util.Iterator;

public class LinkedListDeque <T> {

    private StuffNode sentinel;
    private int size = 0 ;

    public class StuffNode{
        public StuffNode pre;
        public T item;
        public StuffNode next;

        public StuffNode(StuffNode p, T x, StuffNode n ){
            pre = p;
            item = x;
            next = n;
        }
    }

    public int size(){
        return size;
    }

    public LinkedListDeque(){
        sentinel = new StuffNode(null, (T) "666",null);
    }


    public void addFirst(T item){
        if(size == 0){
            sentinel.next = new StuffNode(sentinel,item,sentinel);
            sentinel.pre = sentinel.next;
        }
        else{
            StuffNode p = new StuffNode(null,item,null);
            p.pre = sentinel;
            p.next = sentinel.next;
            sentinel.next.pre = p;
            sentinel.next = p;
        }
        size +=1;
    }
    
    public void addLast(T item){
        if(size == 0){
            sentinel.next = new StuffNode(sentinel,item,sentinel);
            sentinel.pre = sentinel.next;
        }else{
            StuffNode temp = new StuffNode(null,item,null);
            temp.pre = sentinel.pre;
            temp.next = sentinel;
            sentinel.pre.next = temp;
            sentinel.pre = temp;
        }
        size +=1;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public void printDeque(){
        if(isEmpty()){
            System.out.println("Empty List");
        }else{
            int count;
            StuffNode temp = sentinel;
            for( count = 0; count < size; count++ ){
                System.out.print(temp.next.item + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public T removeFirst(){
        T tempT;
        if (isEmpty()){
            return null;
        }
        else{
            tempT = sentinel.next.item;
            sentinel.next.next.pre = sentinel;
            sentinel.next = sentinel.next.next;
        }
        size -= 1;
        return tempT;
    }

    public T removeLast(){
        T tempT;
        if (isEmpty()){
            return null;
        }
        else{
            tempT = sentinel.pre.item;
            sentinel.pre.pre.next = sentinel;
            sentinel.pre = sentinel.pre.pre;

        }
        size -= 1;
        return tempT;
    }

    public T get(int index){
        if(index>=size){
            return null;
        }
        else{
            StuffNode temp = sentinel.next;
            while(index != 0){
                temp = temp.next;
                index--;
            }
            return temp.item;
        }
    }

    public T getRecursive(int index){
        return getRecursive(index,sentinel);
    }

    private T getRecursive(int index, StuffNode Temp){
        if(index>=size){
            return null;
        }
        else if(index == 0){
            return Temp.next.item;
        }
        else{
            return getRecursive(index -1, Temp.next);
        }
    }


    public static void main(String[] args){
//        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
//        for (int i = 0; i < 5; i++) {
//            lld1.addLast(i);
//        }

        LinkedListDeque<String> L = new LinkedListDeque<>();
        L.addFirst("Start");
        L.addLast("6");
        L.addLast("7");
        L.addLast("8");
        L.addLast("Last");
        System.out.println("Size = " + L.size());
        //System.out.println(L.removeLast());
        L.printDeque();
        System.out.println(L.getRecursive(0));
        System.out.println(L.getRecursive(1));
        System.out.println(L.getRecursive(2));
        System.out.println(L.getRecursive(3));
        System.out.println(L.getRecursive(4));
        System.out.println(L.getRecursive(5));
    }


}
